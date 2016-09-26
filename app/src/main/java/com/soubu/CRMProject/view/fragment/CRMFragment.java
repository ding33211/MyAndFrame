package com.soubu.CRMProject.view.fragment;

import com.soubu.CRMProject.base.mvp.presenter.FragmentPresenter;
import com.soubu.CRMProject.delegate.CRMFragmentDelegate;

public class CRMFragment extends FragmentPresenter<CRMFragmentDelegate> {

    @Override
    protected Class<CRMFragmentDelegate> getDelegateClass() {
        return CRMFragmentDelegate.class;
    }
}
