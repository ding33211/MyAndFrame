package com.soubu.CRMProject.view.fragment;

import com.soubu.CRMProject.base.mvp.presenter.FragmentPresenter;
import com.soubu.CRMProject.delegate.WorkBenchFragmentDelegate;

public class WorkBenchFragment extends FragmentPresenter<WorkBenchFragmentDelegate> {
    @Override
    protected Class<WorkBenchFragmentDelegate> getDelegateClass() {
        return WorkBenchFragmentDelegate.class;
    }
}
