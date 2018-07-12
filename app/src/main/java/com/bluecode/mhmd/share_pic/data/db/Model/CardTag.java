package com.bluecode.mhmd.share_pic.data.db.Model;

import com.orm.SugarRecord;

public class CardTag extends SugarRecord {

    private String tag;
    private int color;

    public CardTag() {
    }

    public CardTag(String tag, int color) {
        this.tag = tag;
        this.color = color;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
