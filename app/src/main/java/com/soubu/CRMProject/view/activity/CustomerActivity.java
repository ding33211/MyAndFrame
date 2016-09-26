package com.soubu.CRMProject.view.activity;

import com.soubu.CRMProject.base.mvp.presenter.ActivityPresenter;
import com.soubu.CRMProject.delegate.CustomerActivityDelegate;

/**
 * Created by dingsigang on 16-8-12.
 */
public class CustomerActivity extends ActivityPresenter<CustomerActivityDelegate> {
    @Override
    protected Class<CustomerActivityDelegate> getDelegateClass() {
        return CustomerActivityDelegate.class;
    }
}
