package com.EvanMao.LiveList.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.EvanMao.LiveList.InComeActivity.InfoBean;

import java.util.ArrayList;

/**
 * Created by Meict on 2016/9/2.
 */
public class IncomeListAdapter extends RecyclerView.Adapter<IncomeListAdapter.ViewHolder> {
    private ArrayList<InfoBean> message;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (message != null && message.size() > 0)
            return message.size();
        else
            return 0;
    }

    public void setData(ArrayList<InfoBean> sparseArrays) {
        message = sparseArrays;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
