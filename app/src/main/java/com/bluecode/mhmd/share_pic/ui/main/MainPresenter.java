package com.bluecode.mhmd.share_pic.ui.main;

import com.bluecode.mhmd.share_pic.data.DataManager;
import com.bluecode.mhmd.share_pic.ui.base.BasePresenter;

import javax.inject.Inject;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
