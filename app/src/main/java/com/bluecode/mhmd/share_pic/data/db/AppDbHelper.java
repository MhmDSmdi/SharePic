package com.bluecode.mhmd.share_pic.data.db;

import com.bluecode.mhmd.share_pic.data.db.Model.CardTag;
import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppDbHelper implements DbHelper {

    @Inject
    public AppDbHelper() {
    }

    @Override
    public void saveImageCard(ImageCardHolder imageCard) {
        imageCard.save();
    }

    @Override
    public void saveTag(CardTag tag) {
        tag.save();
    }

    @Override
    public void updateImageCard(ImageCardHolder imageCard) {
        imageCard.save();
    }

    @Override
    public void updateTag(CardTag tag) {
        tag.save();
    }

    @Override
    public void deleteImageCard(ImageCardHolder imageCard) {
        imageCard.delete();
    }

    @Override
    public void deleteTag(CardTag tag) {
        tag.delete();
    }

    @Override
    public ImageCardHolder getImageCardById(Long id) {
        ImageCardHolder img = ImageCardHolder.findById(ImageCardHolder.class, id);
        return img;
    }

    @Override
    public List<ImageCardHolder> getAllImageCard() {
        List<ImageCardHolder> imageCardHolderList = ImageCardHolder.listAll(ImageCardHolder.class);
        return imageCardHolderList;
    }

    @Override
    public List<ImageCardHolder> getImagesCardByTag(String tag) {
        List<ImageCardHolder> imagesCardHolderList = ImageCardHolder.find(ImageCardHolder.class, "Select * from ImageCardHolder where tag = ?", tag);
        return imagesCardHolderList;
    }

    @Override
    public List<CardTag> getAllTag() {
        List<CardTag> tagList= CardTag.listAll(CardTag.class);
        return tagList;
    }
}
