package com.bluecode.mhmd.share_pic.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bluecode.mhmd.share_pic.data.db.Model.ImageCardHolder;
import com.bluecode.mhmd.share_pic.di.ActivityContext;
import com.bluecode.mhmd.share_pic.di.PerActivity;
import com.bluecode.mhmd.share_pic.ui.add_image.AddImageMvpPresenter;
import com.bluecode.mhmd.share_pic.ui.add_image.AddImageMvpView;
import com.bluecode.mhmd.share_pic.ui.add_image.AddImagePresenter;
import com.bluecode.mhmd.share_pic.ui.main.MainMvpPresenter;
import com.bluecode.mhmd.share_pic.ui.main.MainMvpView;
import com.bluecode.mhmd.share_pic.ui.main.MainPresenter;
import com.bluecode.mhmd.share_pic.ui.main.card_recyclerview.ImageCardRecyclerAdapter;
import com.bluecode.mhmd.share_pic.ui.splash.SplashMvpPresenter;
import com.bluecode.mhmd.share_pic.ui.splash.SplashMvpView;
import com.bluecode.mhmd.share_pic.ui.splash.SplashPresenter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext(){
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    AddImageMvpPresenter<AddImageMvpView> provideAddImagePresenter(AddImagePresenter<AddImageMvpView> presenter) {
        return presenter;
    }

    @Provides
    ImageCardRecyclerAdapter provideImageCardAdapter() {
        return new ImageCardRecyclerAdapter(new ArrayList<ImageCardHolder>());
    }

    @Provides
    StaggeredGridLayoutManager provideGridLayoutManager(Activity activity) {
        return new StaggeredGridLayoutManager(2, 1);
    }
}
