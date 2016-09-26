package com.soubu.CRMProject.delegate;

import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.soubu.CRMProject.R;
import com.soubu.CRMProject.base.mvp.view.AppDelegate;

/**
 * Created by dingsigang on 16-8-2.
 */
public class SplashActivityDelegate extends AppDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_splash;
    }

    //欢迎界面需要全屏
    @Override
    public boolean ifNeedFullScreen() {
        return true;
    }




}
