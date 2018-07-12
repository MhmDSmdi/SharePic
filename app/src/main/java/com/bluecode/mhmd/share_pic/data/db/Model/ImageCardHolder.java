package com.bluecode.mhmd.share_pic.data.db.Model;

import com.orm.SugarRecord;

public class ImageCardHolder extends SugarRecord {

    private String caption;
    private String tile;
    private String tag;
    private String note;
    private String photoPath;
    private String location;

    public ImageCardHolder() {
    }

    public ImageCardHolder(String caption, String tile, String note, String photoPath) {
        this.caption = caption;
        this.tile = tile;
        this.note = note;
        this.photoPath = photoPath;
        this.location = location;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getTag() {
        return tag;
    }

    public void setTags(String tag) {
        this.tag = tag;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
