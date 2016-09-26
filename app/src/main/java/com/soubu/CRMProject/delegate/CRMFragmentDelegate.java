package com.soubu.CRMProject.delegate;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.soubu.CRMProject.R;
import com.soubu.CRMProject.adapter.CRMRvAdapter;
import com.soubu.CRMProject.adapter.HomePageRvAdapter;
import com.soubu.CRMProject.base.mvp.view.AppDelegate;
import com.soubu.CRMProject.widget.DividerItemDecoration;

/**
 * Created by dingsigang on 16-8-9.
 */
public class CRMFragmentDelegate extends BaseFragmentDelegate {

    RecyclerView mRvHomePage;
    CRMRvAdapter mAdapter;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_crm;
    }


    @Override
    public void initWidget() {
        super.initWidget();
        mAdapter = new CRMRvAdapter(getActivity());
        mRvHomePage = get(R.id.rv_crm);
        mRvHomePage.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvHomePage.setAdapter(mAdapter);
    }


}
