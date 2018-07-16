package com.bluecode.mhmd.share_pic.di.component;

import android.app.Application;
import android.content.Context;

import com.bluecode.mhmd.share_pic.MvpApp;
import com.bluecode.mhmd.share_pic.data.DataManager;
import com.bluecode.mhmd.share_pic.di.ApplicationContext;
import com.bluecode.mhmd.share_pic.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApp app);

    @ApplicationContext
    Context context();

    Application getApplication();

    DataManager getDataManager();
}
