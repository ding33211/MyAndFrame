package com.soubu.CRMProject;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import com.soubu.CRMProject.utils.CrashHandler;
import com.soubu.CRMProject.utils.PhoneUtil;
import com.soubu.CRMProject.utils.ToastUtil;


import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.GINGERBREAD;

/**
 * Created by dingsigang on 16-8-1.
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    public static String cacheDir = "";
//    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        //Log机制
        instance = (MyApplication) getApplicationContext();
        cacheDir = PhoneUtil.getCacheDir(instance);

        //初始化crash输出工具
        //具体决策需要商议
        CrashHandler.getInstance().init(instance);

        ToastUtil.register(this);
    }

    private void enabledStrictMode() {
        if (SDK_INT >= GINGERBREAD) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll()  //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return instance;
    }
}
