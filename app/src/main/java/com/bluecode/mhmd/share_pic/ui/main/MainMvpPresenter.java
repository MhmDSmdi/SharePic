package com.bluecode.mhmd.share_pic.ui.main;

import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.di.PerActivity;
import com.bluecode.mhmd.share_pic.ui.base.MvpPresenter;
import com.bluecode.mhmd.share_pic.ui.base.MvpView;

import java.util.List;

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    List<ImageCardHolder> getImageCardList();
}
