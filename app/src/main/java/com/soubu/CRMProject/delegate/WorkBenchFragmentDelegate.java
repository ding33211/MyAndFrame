package com.soubu.CRMProject.delegate;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.soubu.CRMProject.R;
import com.soubu.CRMProject.adapter.HomePageRvAdapter;
import com.soubu.CRMProject.widget.DividerItemDecoration;


public class WorkBenchFragmentDelegate extends BaseFragmentDelegate {
    RecyclerView mRvHomePage;
    HomePageRvAdapter mAdapter;

    @Override
    public int getRootLayoutId() {
        return R.layout.fragment_work_bench;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        mAdapter = new HomePageRvAdapter();
        mRvHomePage = get(R.id.rv_home_page);
//        WrapContentLayoutManager wclm = new WrapContentLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        wclm.setAutoMeasureEnabled(false);
//        mRvHomePage.setHasFixedSize(false);
        mRvHomePage.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvHomePage.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        mRvHomePage.setAdapter(mAdapter);
    }
}
