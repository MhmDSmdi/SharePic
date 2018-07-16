package com.bluecode.mhmd.share_pic.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.bluecode.mhmd.share_pic.di.ApplicationContext;
import com.bluecode.mhmd.share_pic.di.PreferenceInfo;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }
}
