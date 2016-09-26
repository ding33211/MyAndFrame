package com.soubu.CRMProject.view.fragment;

import com.soubu.CRMProject.base.mvp.presenter.FragmentPresenter;
import com.soubu.CRMProject.delegate.TodoFragmentDelegate;

public class TodoFragment extends FragmentPresenter<TodoFragmentDelegate> {
    @Override
    protected Class<TodoFragmentDelegate> getDelegateClass() {
        return TodoFragmentDelegate.class;
    }
}
