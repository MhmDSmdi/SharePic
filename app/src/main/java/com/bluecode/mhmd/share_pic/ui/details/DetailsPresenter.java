package com.bluecode.mhmd.share_pic.ui.details;

import com.bluecode.mhmd.share_pic.data.DataManager;
import com.bluecode.mhmd.share_pic.ui.base.BasePresenter;

import javax.inject.Inject;

public class DetailsPresenter<V extends DetailsMvpView> extends BasePresenter<V> implements DetailsMvpPresenter<V> {

    @Inject
    public DetailsPresenter(DataManager dataManager) {
        super(dataManager);
    }
}
