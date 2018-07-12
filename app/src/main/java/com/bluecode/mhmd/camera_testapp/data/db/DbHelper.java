package com.bluecode.mhmd.camera_testapp.data.db;

import com.bluecode.mhmd.camera_testapp.data.db.Model.CardTag;
import com.bluecode.mhmd.camera_testapp.data.db.Model.ImageCardHolder;

import java.util.List;

public interface DbHelper {

    void saveImageCard(ImageCardHolder imageCard);
    void saveTag(CardTag tag);
    void updateImageCard(ImageCardHolder imageCard);
    void updateTag(CardTag tag);
    void deleteImageCard(ImageCardHolder imageCard);
    void deleteTag(CardTag tag);
    ImageCardHolder getImageCardById(Long id);
    List<ImageCardHolder> getAllImageCard();
    List<ImageCardHolder> getImagesCardByTag(String tag);
    List<CardTag> getAllTag();

}
