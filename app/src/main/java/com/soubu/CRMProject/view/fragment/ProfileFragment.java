package com.soubu.CRMProject.view.fragment;

import com.soubu.CRMProject.base.mvp.presenter.FragmentPresenter;
import com.soubu.CRMProject.delegate.ProfileFragmentDelegate;

public class ProfileFragment extends FragmentPresenter<ProfileFragmentDelegate> {
    @Override
    protected Class<ProfileFragmentDelegate> getDelegateClass() {
        return ProfileFragmentDelegate.class;
    }
}
