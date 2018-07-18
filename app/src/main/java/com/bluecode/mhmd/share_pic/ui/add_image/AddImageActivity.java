package com.bluecode.mhmd.share_pic.ui.add_image;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bluecode.mhmd.share_pic.R;
import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.ui.add_image.bottomSheet.BottomSheetDialog;
import com.bluecode.mhmd.share_pic.ui.base.BaseActivity;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

public class AddImageActivity extends BaseActivity implements AddImageMvpView, BottomSheetDialog.BottomSheetListener {

    @Inject
    AddImagePresenter<AddImageMvpView> mPresenter;

    private String currentImageUri;
    private ImageView imageView_holder;
    private FloatingActionButton fab;
    private EditText editText_title, editText_caption, editText_note;
    private Button btnSave;
    private RelativeLayout toolbarLayout;
    private AppBarLayout appBarLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getActivityComponent().inject(this);

        imageView_holder = findViewById(R.id.img_add_holder);
        editText_caption = findViewById(R.id.editTxt_add_caption);
        editText_note = findViewById(R.id.editTxt_add_note);
        editText_title = findViewById(R.id.editTxt_add_title);
        btnSave = findViewById(R.id.btn_add_save);
        fab = findViewById(R.id.fab_add);
        toolbarLayout = findViewById(R.id.layout_add_toolbar);
        appBarLayout = findViewById(R.id.appBar_add);
        appBarLayout.setExpanded(false);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (currentImageUri != "" && isValidInput()) {
                   ImageCardHolder imageCardHolder = new ImageCardHolder(
                           editText_title.getText().toString(),
                           editText_caption.getText().toString(),
                           editText_note.getText().toString(), currentImageUri);
                   mPresenter.saveNewCard(imageCardHolder);
                   finish();
               } else {
                   showMessage(R.string.err_add_unfillItem);
               }
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialogDialog = new BottomSheetDialog();
                bottomSheetDialogDialog.show(getSupportFragmentManager(), "bottomSheet");
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            int mode = 1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset <  - 3 * appBarLayout.getTotalScrollRange() / 4 && mode == 1) {
                    setVisibleToolbar();
                    mode = 0;
                }
                else if (verticalOffset >  - 3 * appBarLayout.getTotalScrollRange() / 4 && mode == 0) {
                    setUnVisibleToolbar();
                    mode = 1;
                }
            }
        });

    }

    public boolean isValidInput() {
        boolean temp = true;
        if (editText_title.getText().toString().trim().equalsIgnoreCase("")) {
            editText_title.setError("Enter Title for Your Picture");
            temp = false;
        }
        if (editText_caption.getText().toString().trim().equalsIgnoreCase("")) {
            editText_caption.setError("Enter Caption for Your Picture");
            temp = false;
        }
        if (editText_note.getText().toString().trim().equalsIgnoreCase("")) {
            editText_note.setError("Enter Note for Your Picture");
            temp = false;
        }
        return temp;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == AddImagePresenter.PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            currentImageUri = /*FileUtils.*/getRealPathFromURI(this, data.getData());
            showMessage(currentImageUri);
            Glide.with(getApplicationContext())
                    .load(data.getData())
                    .into(imageView_holder);
        }

        else if (requestCode == AddImagePresenter.REQUEST_TAKE_PHOTO && resultCode == RESULT_OK ) {
            currentImageUri = mPresenter.getCurrentPhotoPath();
            showMessage(currentImageUri);
            Glide.with(getApplicationContext())
                    .load(currentImageUri)
                    .into(imageView_holder);
        }
    }


    public static String getRealPathFromURI(Context context, Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } catch (Exception e) {
            return "";
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public boolean isPermissionGranted(String permission) {
        return false;
    }

    @Override
    public void takeImageFromCamera() {
        startActivityForResult(mPresenter.getCameraIntent(), AddImagePresenter.REQUEST_TAKE_PHOTO);
    }

    @Override
    public void takeImageFromGallery() {
        startActivityForResult(mPresenter.getIntentImagePicker(), AddImagePresenter.PICK_IMAGE);
    }

    @Override
    public void setVisibleToolbar() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(toolbarLayout, "alpha", 0.2f, 1f);
        animation.setDuration(1000);
        animation.start();
    }

    @Override
    public void setUnVisibleToolbar() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(toolbarLayout, "alpha", 1f, 0.2f);
        animation.setDuration(1000);
        animation.start();
    }
}
