package com.soubu.CRMProject.view.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.igexin.sdk.PushManager;
import com.soubu.CRMProject.R;
import com.soubu.CRMProject.base.mvp.presenter.ActivityPresenter;
import com.soubu.CRMProject.delegate.SplashActivityDelegate;
import com.soubu.CRMProject.utils.PermissionUtil;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * 欢迎页
 */
//标注这个类需要使用到6.0动态权限请求
@RuntimePermissions
public class SplashActivity extends ActivityPresenter<SplashActivityDelegate> {

    @Override
    protected Class<SplashActivityDelegate> getDelegateClass() {
        return SplashActivityDelegate.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化个推
        PushManager.getInstance().initialize(this.getApplicationContext());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SplashActivityPermissionsDispatcher.loadWithCheck(SplashActivity.this);
            }
        }).start();
    }

    //需要验证权限的方法
    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    void load() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    //之前拒绝过这个请求,当再次请求这个权限的时候调起的方法
    //建议是对话框的方式,告知用户请求这个权限的原因
    //注意由于是在build中生成的类文件,因此每次对注释方法有有修改需要clean,rebuild.
    @OnShowRationale(Manifest.permission.READ_EXTERNAL_STORAGE)
    void showDialog(PermissionRequest request) {
        PermissionUtil.showPermissionExplainDialog(getApplicationContext(), R.string.permission_explain_storage, request);
    }

    @OnPermissionDenied(Manifest.permission.READ_EXTERNAL_STORAGE)
    void onPermissionDenied() {
        finish();
    }

    @OnNeverAskAgain(Manifest.permission.READ_EXTERNAL_STORAGE)
    void showGoToSettingDialog() {
        PermissionUtil.showGoToSettingDialog(this, R.string.permission_explain_storage, true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PermissionUtil.REQUEST_PERMISSION_SETTING:
                    load();
                default:
                    break;
            }
        }
    }
}
