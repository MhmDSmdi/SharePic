package com.bluecode.mhmd.share_pic.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.bluecode.mhmd.share_pic.di.ApplicationContext;
import com.bluecode.mhmd.share_pic.di.PreferenceInfo;
import com.bluecode.mhmd.share_pic.utils.AppConstants;

import javax.inject.Inject;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_PASSWORD = "PREF_KEY_CURRENT_PASSWORD";
    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public Long getCurrentUserId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.DEF_VALUE_ID);
        return (userId == AppConstants.DEF_VALUE_ID ? null : userId);
    }

    @Override
    public void setCurrentUserId(Long id) {
        long userId = (id == null ? AppConstants.DEF_VALUE_ID : id);
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, userId).apply();
    }

    @Override
    public String getCurrentUserName() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentPassword() {
        return mPrefs.getString(PREF_KEY_CURRENT_PASSWORD, AppConstants.DEF_VALUE_PASSWORD);
    }

    @Override
    public void setCurrentPassword(String password) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_PASSWORD, password);
    }

    @Override
    public String getCurrentUserProfilePicUrl() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null);
    }

    @Override
    public void setCurrentUserProfilePicUrl(String profilePicUrl) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicUrl);
    }
}
