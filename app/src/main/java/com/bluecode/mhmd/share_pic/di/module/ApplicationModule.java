package com.bluecode.mhmd.share_pic.di.module;

import android.app.Application;
import android.content.Context;

import com.bluecode.mhmd.share_pic.R;
import com.bluecode.mhmd.share_pic.data.AppDataManager;
import com.bluecode.mhmd.share_pic.data.DataManager;
import com.bluecode.mhmd.share_pic.data.db.AppDbHelper;
import com.bluecode.mhmd.share_pic.data.db.DbHelper;
import com.bluecode.mhmd.share_pic.data.prefs.AppPreferencesHelper;
import com.bluecode.mhmd.share_pic.data.prefs.PreferencesHelper;
import com.bluecode.mhmd.share_pic.di.ApplicationContext;
import com.bluecode.mhmd.share_pic.di.DatabaseInfo;
import com.bluecode.mhmd.share_pic.di.PreferenceInfo;
import com.bluecode.mhmd.share_pic.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class ApplicationModule {

    private final Application mApplication;


    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
