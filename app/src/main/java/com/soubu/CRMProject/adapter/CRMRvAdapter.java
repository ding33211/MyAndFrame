package com.soubu.CRMProject.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soubu.CRMProject.R;
import com.soubu.CRMProject.view.activity.CustomerActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dingsigang on 16-8-12.
 */
public class CRMRvAdapter extends RecyclerView.Adapter {

    private static final int TYPE_CUSTOMER_MANAGEMENT = 0x00;//客户管理
    private static final int TYPE_BUSINESS_MANAGEMENT = 0x01;//业务管理
    private static final int TYPE_POPULAR_FUNCTION = 0x02;//常用功能


    private List<CRMRvItem> mCustomerItems;
    private List<CRMRvItem> mBusinessItems;
    private List<CRMRvItem> mPopularItems;

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_CUSTOMER_MANAGEMENT;
            case 1:
                return TYPE_BUSINESS_MANAGEMENT;
            case 2:
                return TYPE_POPULAR_FUNCTION;
            default:
                return 0;
        }
    }

    public CRMRvAdapter(Activity activity) {
        int[] labelsOne = new int[]{R.string.customer, R.string.clue, R.string.business_opportunity, R.string.contract};
        int[] iconsOne = new int[]{R.drawable.fx_find_normal, R.drawable.fx_find_normal, R.drawable.fx_find_normal, R.drawable.fx_find_normal};
        Intent[] intentsOne = new Intent[]{new Intent(activity, CustomerActivity.class), new Intent(activity, CustomerActivity.class),
                new Intent(activity, CustomerActivity.class), new Intent(activity, CustomerActivity.class)};

        int[] labelsTwo = new int[]{R.string.sales_management, R.string.contract_management, R.string.product_management, R.string.customer_high_seas,
                R.string.weekly_and_monthly_report, R.string.approval};
        int[] iconsTwo = new int[]{R.drawable.fx_find_normal, R.drawable.fx_find_normal, R.drawable.fx_find_normal, R.drawable.fx_find_normal, R.drawable.fx_find_normal, R.drawable.fx_find_normal};
        Intent[] intentsTwo = new Intent[]{new Intent(activity, CustomerActivity.class), new Intent(activity, CustomerActivity.class),
                new Intent(activity, CustomerActivity.class), new Intent(activity, CustomerActivity.class), new Intent(activity, CustomerActivity.class), new Intent(activity, CustomerActivity.class)};

        int[] labelsThree = new int[]{R.string.business_card_scanning, R.string.nearby_customers, R.string.fill_in_follow_up, R.string.new_reminder};
        int[] iconsThree = new int[]{R.drawable.fx_find_normal, R.drawable.fx_find_normal, R.drawable.fx_find_normal, R.drawable.fx_find_normal};
        Intent[] intentsThree = new Intent[]{new Intent(activity, CustomerActivity.class), new Intent(activity, CustomerActivity.class),
                new Intent(activity, CustomerActivity.class), new Intent(activity, CustomerActivity.class)};
        mCustomerItems = new ArrayList<>();
        for (int i = 0; i < labelsOne.length; i++) {
            CRMRvItem crm = new CRMRvItem();
            crm.setTitle(labelsOne[i]);
            crm.setIconRes(iconsOne[i]);
            crm.setTarget(intentsOne[i]);
            mCustomerItems.add(crm);
        }
        mBusinessItems = new ArrayList<>();
        for (int i = 0; i < labelsTwo.length; i++) {
            CRMRvItem crm = new CRMRvItem();
            crm.setTitle(labelsTwo[i]);
            crm.setIconRes(iconsTwo[i]);
            crm.setTarget(intentsTwo[i]);
            mBusinessItems.add(crm);
        }
        mPopularItems = new ArrayList<>();
        for (int i = 0; i < labelsThree.length; i++) {
            CRMRvItem crm = new CRMRvItem();
            crm.setTitle(labelsThree[i]);
            crm.setIconRes(iconsThree[i]);
            crm.setTarget(intentsThree[i]);
            mPopularItems.add(crm);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.item_crm_recyclerview, parent, false);
        GridLayout glContainer = (GridLayout) v.findViewById(R.id.gl_container);
        switch (viewType) {
            case TYPE_CUSTOMER_MANAGEMENT:
                addContainer(glContainer, context, mCustomerItems, viewType);
                break;
            case TYPE_BUSINESS_MANAGEMENT:
                addContainer(glContainer, context, mBusinessItems, viewType);
                break;
            case TYPE_POPULAR_FUNCTION:
                addContainer(glContainer, context, mPopularItems, viewType);
                break;
            default:
                break;
        }
        return new ItemViewHolder(v);
    }

    private void addContainer(GridLayout container, final Context context, List<CRMRvItem> list, int type) {
        if(type == TYPE_POPULAR_FUNCTION){
            container.setColumnCount(4);
            for (final CRMRvItem item : list) {
                View v = LayoutInflater.from(context).inflate(R.layout.gridlayout_item_crm_recyclerview, null, false);
                v.findViewById(R.id.tv_right_title).setVisibility(View.GONE);
                v.findViewById(R.id.tv_bottom_title).setVisibility(View.VISIBLE);
                ((TextView) v.findViewById(R.id.tv_bottom_title)).setText(item.getTitle());
                ((ImageView) v.findViewById(R.id.iv_image)).setImageResource(item.getIconRes());
                android.support.v7.widget.GridLayout.LayoutParams params =
                        new android.support.v7.widget.GridLayout.LayoutParams();
                params.columnSpec = android.support.v7.widget.GridLayout.spec(GridLayout.UNDEFINED, 1f);
                v.setLayoutParams(params);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(item.getTarget());
                    }
                });
                container.addView(v);
            }
        }else {
            for (final CRMRvItem item : list) {
                View v = LayoutInflater.from(context).inflate(R.layout.gridlayout_item_crm_recyclerview, null, false);
                ((TextView) v.findViewById(R.id.tv_right_title)).setText(item.getTitle());
                ((ImageView) v.findViewById(R.id.iv_image)).setImageResource(item.getIconRes());
                android.support.v7.widget.GridLayout.LayoutParams params =
                        new android.support.v7.widget.GridLayout.LayoutParams();
                params.columnSpec = android.support.v7.widget.GridLayout.spec(GridLayout.UNDEFINED, 1f);
                params.setMargins(0,2,2,0);//设置边距
                v.setLayoutParams(params);
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        context.startActivity(item.getTarget());
                    }
                });
                container.addView(v);
            }
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            switch (position) {
                case 0:
                    ((ItemViewHolder) holder).tvTitle.setText(R.string.customer_management);
                    break;
                case 1:
                    ((ItemViewHolder) holder).tvTitle.setText(R.string.business_management);
                    break;
                case 2:
                    ((ItemViewHolder) holder).tvTitle.setText(R.string.popular_functions);
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    class CRMRvItem {
        int titleRes;
        int iconRes;
        Intent target;

        public int getTitle() {
            return titleRes;
        }

        public void setTitle(int titleRes) {
            this.titleRes = titleRes;
        }

        public int getIconRes() {
            return iconRes;
        }

        public void setIconRes(int iconRes) {
            this.iconRes = iconRes;
        }

        public Intent getTarget() {
            return target;
        }

        public void setTarget(Intent target) {
            this.target = target;
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
