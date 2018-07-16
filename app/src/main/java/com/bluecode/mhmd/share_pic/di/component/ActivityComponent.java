package com.bluecode.mhmd.share_pic.di.component;

import com.bluecode.mhmd.share_pic.di.PerActivity;
import com.bluecode.mhmd.share_pic.di.module.ActivityModule;
import com.bluecode.mhmd.share_pic.ui.main.MainActivity;
import com.bluecode.mhmd.share_pic.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);

    void inject(SplashActivity activity);

}
