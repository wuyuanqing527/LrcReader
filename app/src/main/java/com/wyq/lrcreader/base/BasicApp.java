package com.wyq.lrcreader.base;

import android.app.Application;
import android.content.Context;

import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.wyq.lrcreader.datasource.DataRepository;
import com.wyq.lrcreader.db.AppDatabase;
import com.wyq.lrcreader.share.WeiboConstants;

/**
 * @author Uni.W
 * @date 2019/1/16 18:35
 */
public class BasicApp extends Application {

    private AppExecutors executors;

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;

        AppInitIntentService.start(this);

        executors = new AppExecutors();

        WbSdk.install(this, new AuthInfo(this, WeiboConstants.APP_KEY, WeiboConstants.REDIRECT_URL, WeiboConstants.SCOPE));
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, getExecutors());
    }

    public DataRepository getDataRepository() {
        return DataRepository.getInstance(getDatabase());
    }

    public AppExecutors getExecutors() {
        return executors;
    }

    public static Context getAppContext(){
        return appContext;
    }
}
