package com.bluecode.mhmd.share_pic.ui.add_image;

import android.content.Intent;
import android.graphics.Bitmap;

import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.di.PerActivity;
import com.bluecode.mhmd.share_pic.ui.base.MvpPresenter;

import java.io.File;

@PerActivity
public interface AddImageMvpPresenter<V extends AddImageMvpView> extends MvpPresenter<V> {

    void saveNewCard(ImageCardHolder imageCardHolder);

    Intent getIntentImagePicker();

    Intent getCameraIntent();

}
