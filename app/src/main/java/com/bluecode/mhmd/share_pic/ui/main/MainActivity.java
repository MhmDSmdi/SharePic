package com.bluecode.mhmd.share_pic.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.bluecode.mhmd.share_pic.R;
import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.ui.base.BaseActivity;
import com.bluecode.mhmd.share_pic.ui.createImage.AddImageActivity;
import com.bluecode.mhmd.share_pic.ui.main.card_recyclerview.ImageCardRecyclerAdapter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainMvpView {

    static final int REQUEST_TAKE_PHOTO = 1;

    @Inject
    MainPresenter<MainMvpView> mPresenter;

    @Inject
    ImageCardRecyclerAdapter mCardAdapter;

    @Inject
    StaggeredGridLayoutManager gridLayoutManager;

    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);

        recyclerView = findViewById(R.id.recycler_main);
        fab = findViewById(R.id.fab_main);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickFab();
            }
        });

        setUpRecycler();
        mCardAdapter.addItem(new ImageCardHolder("Title1", "Caption1", "Note", "photoPath"));
        mCardAdapter.addItem(new ImageCardHolder("Title2", "Captioisfhoisdafhsoidfhsiodfhoisdafhoisadhfoishfoisafhoisdfhosdn1", "Note", "photoPath"));
        mCardAdapter.addItem(new ImageCardHolder("Title3", "Caption3", "Note", "photoPath"));
        mCardAdapter.addItem(new ImageCardHolder("Title4", "Caption4", "Note", "photoPath"));
    }

    public void setUpRecycler() {
        gridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mCardAdapter);
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    /*private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
            }
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }*/

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
           setImageViewPic();
        }
    }*/

   /* private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName,".jpg", storageDir);
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }*/

    /*private void setImageViewPic() {
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);

        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(currentPhotoPath, bmOptions);
        imageView.setImageBitmap(bitmap);
    }*/

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
    public void onClickFab() {
        Intent intent = new Intent(this, AddImageActivity.class);
        startActivity(intent);
    }
}
