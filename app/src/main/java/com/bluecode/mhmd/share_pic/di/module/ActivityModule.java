package com.bluecode.mhmd.share_pic.di.module;

import android.app.Activity;
import android.content.Context;

import com.bluecode.mhmd.share_pic.di.ActivityContext;
import com.bluecode.mhmd.share_pic.di.PerActivity;
import com.bluecode.mhmd.share_pic.ui.main.MainMvpPresenter;
import com.bluecode.mhmd.share_pic.ui.main.MainMvpView;
import com.bluecode.mhmd.share_pic.ui.main.MainPresenter;
import com.bluecode.mhmd.share_pic.ui.splash.SplashMvpPresenter;
import com.bluecode.mhmd.share_pic.ui.splash.SplashMvpView;
import com.bluecode.mhmd.share_pic.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
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
}
