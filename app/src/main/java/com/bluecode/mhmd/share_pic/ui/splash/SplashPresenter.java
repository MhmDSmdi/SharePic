package com.bluecode.mhmd.share_pic.ui.splash;

import com.bluecode.mhmd.share_pic.data.DataManager;
import com.bluecode.mhmd.share_pic.ui.base.BasePresenter;

public class SplashPresenter <V extends SplashMvpView> extends BasePresenter<V> {

    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }
}
