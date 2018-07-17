package com.bluecode.mhmd.share_pic.utils;

import android.widget.EditText;

public final class CheckValidity {

    public static boolean isValidPlaneTextInput(EditText editText) {
        return (editText.getText().toString() != "" ? true : false);
    }

    public static boolean isValidPicturePath(String picturePath) {
        return (picturePath != "" ? true : false);
    }
}
