package com.soubu.CRMProject.delegate;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.soubu.CRMProject.R;
import com.soubu.CRMProject.base.mvp.view.AppDelegate;
import com.soubu.CRMProject.view.fragment.CRMFragment;
import com.soubu.CRMProject.view.fragment.ProfileFragment;
import com.soubu.CRMProject.view.fragment.TodoFragment;
import com.soubu.CRMProject.view.fragment.WorkBenchFragment;

/**
 * Created by dingsigang on 16-8-2.
 */
public class HomeActivityDelegate extends AppDelegate {

    private Button[] mTabs;
    private Fragment[] fragments;
    private WorkBenchFragment mWorkBenchFragment;
    private CRMFragment mCRMFragment;
    private TodoFragment mTodoFragment;
    private ProfileFragment mProfileFragment;

    @Override
    public void initWidget() {
        super.initWidget();
        mWorkBenchFragment = new WorkBenchFragment();
        mCRMFragment = new CRMFragment();
        mTodoFragment = new TodoFragment();
        mProfileFragment = new ProfileFragment();
        mTabs = new Button[]{get(R.id.btn_conversation), get(R.id.btn_address_list),
                get(R.id.btn_find)};
        fragments = new Fragment[]{mWorkBenchFragment, mCRMFragment, mTodoFragment};
        mTabs[0].setSelected(true);
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mWorkBenchFragment).
                add(R.id.fragment_container, mCRMFragment).hide(mCRMFragment).show(mWorkBenchFragment).commit();
    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_home;
    }


    public void showFragmentAndSelectTab(int index, int currentIndex) {
        if (currentIndex != index) {
            FragmentTransaction trx = getActivity().getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }
        mTabs[currentIndex].setSelected(false);
        // set current tab selected
        mTabs[index].setSelected(true);
    }

    @Override
    public boolean ifNeedHideToolBar() {
        return true;
    }
}
