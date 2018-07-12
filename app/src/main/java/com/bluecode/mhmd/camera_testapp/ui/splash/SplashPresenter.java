package com.bluecode.mhmd.camera_testapp.ui.splash;

import com.bluecode.mhmd.camera_testapp.data.DataManager;
import com.bluecode.mhmd.camera_testapp.ui.base.BasePresenter;

public class SplashPresenter <V extends SplashMvpView> extends BasePresenter<V> {

    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }
}
