package com.bluecode.mhmd.share_pic.data.prefs;

public interface PreferencesHelper {

    Long getCurrentUserId();

    void setCurrentUserId(Long id);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentPassword();

    void setCurrentPassword(String password);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);

}

