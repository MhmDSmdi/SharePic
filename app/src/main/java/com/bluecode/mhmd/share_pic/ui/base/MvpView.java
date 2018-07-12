package com.bluecode.mhmd.share_pic.ui.base;

import android.support.annotation.StringRes;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(String message);

    void onError(@StringRes int message);

    void showMessage(String Message);

    void showMessage(@StringRes int Message);

    boolean isNetworkConnected();

    boolean isPermissionGranted(String permission);

}
