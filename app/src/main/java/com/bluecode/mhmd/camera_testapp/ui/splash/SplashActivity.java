package com.bluecode.mhmd.camera_testapp.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bluecode.mhmd.camera_testapp.R;
import com.bluecode.mhmd.camera_testapp.ui.base.BaseActivity;
import com.bluecode.mhmd.camera_testapp.ui.main.MainActivity;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    SplashMvpPresenter<SplashMvpView> mPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mPresenter.onAttach(SplashActivity.this);
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onError(int message) {

    }

    @Override
    public void showMessage(String Message) {

    }

    @Override
    public void showMessage(int Message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public boolean isPermissionGranted(String permission) {
        return false;
    }
}
