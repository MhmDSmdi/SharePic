package com.bluecode.mhmd.share_pic.ui.createImage;

import com.bluecode.mhmd.share_pic.data.DataManager;
import com.bluecode.mhmd.share_pic.ui.base.BasePresenter;
import com.bluecode.mhmd.share_pic.ui.main.MainMvpPresenter;

public class AddImagePresenter<V extends AddImageMvpView> extends BasePresenter<V> implements AddImageMvpPresenter<V> {

    public AddImagePresenter(DataManager dataManager) {
        super(dataManager);
    }
}
