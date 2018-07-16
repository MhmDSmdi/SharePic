package com.bluecode.mhmd.share_pic.ui.createImage;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bluecode.mhmd.share_pic.R;
import com.bluecode.mhmd.share_pic.ui.base.BaseActivity;

public class AddImageActivity extends BaseActivity implements AddImageMvpView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public boolean isPermissionGranted(String permission) {
        return false;
    }
}
