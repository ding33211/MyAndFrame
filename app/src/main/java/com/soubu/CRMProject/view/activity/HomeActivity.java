package com.soubu.CRMProject.view.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.soubu.CRMProject.R;
import com.soubu.CRMProject.base.mvp.presenter.ActivityPresenter;
import com.soubu.CRMProject.delegate.HomeActivityDelegate;
import com.soubu.CRMProject.utils.ToastUtil;

/**
 * 首页
 */
public class HomeActivity extends ActivityPresenter<HomeActivityDelegate> {

    //点击tab的index
    private int mIndex;
    //当前的tab的index
    private int mCurrentTabIndex;
    //是否需要退出
    private boolean mNeedQuit = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Class<HomeActivityDelegate> getDelegateClass() {
        return HomeActivityDelegate.class;
    }


    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_conversation:
                mIndex = 0;
                break;
            case R.id.btn_address_list:
                mIndex = 1;
                break;
            case R.id.btn_find:
                mIndex = 2;
                break;
//            case R.id.btn_profile:
//                mIndex = 3;
//                break;
        }
        viewDelegate.showFragmentAndSelectTab(mIndex, mCurrentTabIndex);
        mCurrentTabIndex = mIndex;
    }


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mNeedQuit = false;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!mNeedQuit) {
                mNeedQuit = true;
                ToastUtil.showShort(R.string.click_again_to_quit);
                // 利用handler延迟发送更改状态信息
                mHandler.sendEmptyMessageDelayed(0, 2000);
            } else {
                finish();
                System.exit(0);
            }
        }
        return false;
    }
}
