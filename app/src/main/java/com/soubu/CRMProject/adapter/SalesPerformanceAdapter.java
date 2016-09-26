package com.soubu.CRMProject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soubu.CRMProject.R;

/**
 * Created by dingsigang on 16-8-12.
 */
public class SalesPerformanceAdapter extends BaseHomePageIndicatorViewPagerAdapter {
    Context context;

    public SalesPerformanceAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getViewForPage(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getViewPagerLayoutRes(), container, false);
        }
        return convertView;
    }

    @Override
    public int getViewPagerLayoutRes() {
        return R.layout.item_sales_performance;
    }
}
