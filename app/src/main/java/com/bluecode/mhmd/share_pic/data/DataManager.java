package com.bluecode.mhmd.share_pic.data;

import android.content.Intent;
import android.net.Uri;

import com.bluecode.mhmd.share_pic.data.db.DbHelper;
import com.bluecode.mhmd.share_pic.data.prefs.PreferencesHelper;

import java.io.File;

public interface DataManager extends DbHelper, PreferencesHelper {

    File createImageFile();

    boolean checkIsNull(Intent intent);

    Uri getUriPictureFile(String authority, File imageFile);
}
