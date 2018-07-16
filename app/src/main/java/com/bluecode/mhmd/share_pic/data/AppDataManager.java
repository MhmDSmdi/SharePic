package com.bluecode.mhmd.share_pic.data;

import android.content.Context;

import com.bluecode.mhmd.share_pic.data.db.DbHelper;
import com.bluecode.mhmd.share_pic.data.db.Model.CardTag;
import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.data.prefs.PreferencesHelper;
import com.bluecode.mhmd.share_pic.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";
    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }


    @Override
    public void saveImageCard(ImageCardHolder imageCard) {
        mDbHelper.saveImageCard(imageCard);
    }

    @Override
    public void saveTag(CardTag tag) {
        mDbHelper.saveTag(tag);
    }

    @Override
    public void updateImageCard(ImageCardHolder imageCard) {
        mDbHelper.updateImageCard(imageCard);
    }

    @Override
    public void updateTag(CardTag tag) {
        mDbHelper.updateTag(tag);
    }

    @Override
    public void deleteImageCard(ImageCardHolder imageCard) {
        mDbHelper.deleteImageCard(imageCard);
    }

    @Override
    public void deleteTag(CardTag tag) {
        mDbHelper.deleteTag(tag);
    }

    @Override
    public ImageCardHolder getImageCardById(Long id) {
        return mDbHelper.getImageCardById(id);
    }

    @Override
    public List<ImageCardHolder> getAllImageCard() {
        return mDbHelper.getAllImageCard();
    }

    @Override
    public List<ImageCardHolder> getImagesCardByTag(String tag) {
        return mDbHelper.getImagesCardByTag(tag);
    }

    @Override
    public List<CardTag> getAllTag() {
        return mDbHelper.getAllTag();
    }
}
