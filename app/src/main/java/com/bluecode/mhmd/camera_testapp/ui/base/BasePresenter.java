package com.bluecode.mhmd.camera_testapp.ui.base;

import com.bluecode.mhmd.camera_testapp.data.DataManager;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private static final String TAG = "BasePresenter";

    private final DataManager mDataManager;
    private V mMvpView;

    public BasePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getmMvpView() {
        return mMvpView;
    }

    public DataManager getmDataManager() {
        return mDataManager;
    }
}
