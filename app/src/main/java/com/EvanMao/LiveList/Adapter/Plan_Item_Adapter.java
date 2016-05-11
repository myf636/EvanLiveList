package com.EvanMao.LiveList.Adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.EvanMao.LiveList.EvanApp;
import com.EvanMao.LiveList.MainActivity.MainActivity;
import com.EvanMao.LiveList.R;
import com.EvanMao.LiveList.card.TimeManagerCard;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by myf636 on 2016/4/6.
 * 时间提醒的adapter
 */
public class Plan_Item_Adapter extends RecyclerView.Adapter<Plan_Item_Adapter.ViewHolder> {
    private MainActivity context;

    public Plan_Item_Adapter(MainActivity mainActivity) {
        context = mainActivity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(EvanApp.getInstance()).inflate(R.layout
                .main_card, parent, false);
        AutoUtils.autoSize(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cardContainer.setId(4000 + position);
        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(holder.cardContainer.getId(), TimeManagerCard.newInstance(null, null));
        transaction.commit();
    }

    @Override
    public int getItemCount() {
        return 16;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AutoRelativeLayout cardContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            cardContainer = (AutoRelativeLayout) itemView.findViewById(R.id.card_container);
        }
    }
}
