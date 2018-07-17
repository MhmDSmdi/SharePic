package com.bluecode.mhmd.share_pic.ui.add_image;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bluecode.mhmd.share_pic.R;
import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.ui.add_image.bottomSheet.BottomSheetDialog;
import com.bluecode.mhmd.share_pic.ui.base.BaseActivity;
import com.bumptech.glide.Glide;

import java.io.File;

import javax.inject.Inject;

public class AddImageActivity extends BaseActivity implements AddImageMvpView, BottomSheetDialog.BottomSheetListener {

    @Inject
    AddImagePresenter<AddImageMvpView> mPresenter;

    private ImageView imageView_holder;
    private EditText editText_title, editText_caption, editText_note;
    private Button btnSave;
    private Uri currentImageUri;

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



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageCardHolder imageCardHolder = new ImageCardHolder(
                        editText_title.getText().toString(),
                        editText_caption.getText().toString(),
                        editText_note.getText().toString(), currentImageUri.toString());
                showMessage(mPresenter.getmDataManager().getAllImageCard().size() + "");
                mPresenter.saveNewCard(imageCardHolder);
                finish();
            }
        });

        imageView_holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialogDialog = new BottomSheetDialog();
                bottomSheetDialogDialog.show(getSupportFragmentManager(), "bottomSheet");
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == AddImagePresenter.PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            currentImageUri = data.getData();
            Glide.with(getApplicationContext())
                    .load(currentImageUri)
                    .into(imageView_holder);
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

}
