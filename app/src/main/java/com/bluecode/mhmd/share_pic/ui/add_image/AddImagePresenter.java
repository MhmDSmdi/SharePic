package com.bluecode.mhmd.share_pic.ui.add_image;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;

import com.bluecode.mhmd.share_pic.data.DataManager;
import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.ui.base.BasePresenter;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

public class AddImagePresenter<V extends AddImageMvpView> extends BasePresenter<V> implements AddImageMvpPresenter<V> {

    public static final int PICK_IMAGE = 1;
    static final int REQUEST_TAKE_PHOTO = 2;
    private String currentPhotoPath = "";

    @Inject
    public AddImagePresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void saveNewCard(ImageCardHolder imageCardHolder) {
        getmDataManager().saveImageCard(imageCardHolder);
    }

    @Override
    public Intent getIntentImagePicker() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

        return chooserIntent;
    }

    @Override
    public Intent getCameraIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (getmDataManager().checkIsNull(takePictureIntent)) {
            File photoFile = null;
            photoFile = getmDataManager().createImageFile();
            currentPhotoPath = photoFile.getPath();
            if (photoFile != null) {
                Uri photoURI = getmDataManager().getUriPictureFile("com.example.android.fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            }
        }
        return takePictureIntent;
    }

    @Override
    public Bitmap setImageViewPic() {
        int targetW = 50;
        int targetH = 50;

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
        return bitmap;
    }

    public String getCurrentPhotoPath() {
        return currentPhotoPath;
    }
}
