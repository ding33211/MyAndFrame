package com.soubu.CRMProject.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.soubu.CRMProject.R;
import com.soubu.CRMProject.widget.ColorArcProgressBar;
import com.soubu.CRMProject.widget.IndicatorViewPager.IndicatorViewPager;

/**
 * 业绩目标adapter
 * Created by dingsigang on 16-8-10.
 */
public class PerformanceGoalAdapter extends BaseHomePageIndicatorViewPagerAdapter {
    Context context;

    public PerformanceGoalAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View getViewForPage(int position, View convertView, ViewGroup container) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(getViewPagerLayoutRes(), container, false);
        }
        ColorArcProgressBar bar = (ColorArcProgressBar) convertView.findViewById(R.id.capb_goal);
        if (position == 0) {
            bar.setCurrentValues(70);
            bar.setTag(70);
        } else {
            bar.setCurrentValues(30);
            bar.setTag(30);
        }
        convertView.setTag("position" + position);
        return convertView;
    }

    /**
     * 当点击了item进行viewPager跳转的时候,动画重新走
     * @param viewPager
     * @param preSelect
     * @param select
     */
    public void restartCurrentValuesAnim(ViewPager viewPager, int preSelect, int select) {
        View selectView = viewPager.findViewWithTag("position" + select);
        View preView = viewPager.findViewWithTag("position" + preSelect);
        ColorArcProgressBar bar = (ColorArcProgressBar) selectView.findViewById(R.id.capb_goal);
        ColorArcProgressBar preBar = (ColorArcProgressBar) preView.findViewById(R.id.capb_goal);
        bar.restartAnimation((int) preBar.getTag(), (int) bar.getTag());
    }

    @Override
    public int getViewPagerLayoutRes() {
        return R.layout.item_performance_gole;
    }
}
