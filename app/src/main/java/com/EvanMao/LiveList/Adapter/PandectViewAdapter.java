package com.EvanMao.LiveList.Adapter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.EvanMao.LiveList.EvanApp;
import com.EvanMao.LiveList.MainActivity.MainActivity;
import com.EvanMao.LiveList.R;
import com.EvanMao.Tool.UIFragmentControl;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by Administrator on 2016/1/15.
 */
public class PandectViewAdapter extends RecyclerView.Adapter<PandectViewAdapter.ViewHolder> {
    public SparseArray<UIFragmentControl> sparseArray;
    private MainActivity context;

    public PandectViewAdapter(SparseArray<UIFragmentControl> sparseArray, MainActivity mainActivity) {
        this.sparseArray = sparseArray;
        context = mainActivity;
    }

    @Override
    public PandectViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(EvanApp.getInstance()).inflate(R.layout.main_card, parent, false);
        AutoUtils.autoSize(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PandectViewAdapter.ViewHolder holder, int position) {
        holder.cardContainer.setId(1000 + position);
        FragmentManager fm = context.getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(holder.cardContainer.getId(), sparseArray.get(position));
        transaction.commit();
    }

    @Override
    public int getItemCount() {
        if (sparseArray != null && sparseArray.size() > 0)
            return sparseArray.size();
        else
            return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AutoRelativeLayout cardContainer;

        public ViewHolder(View itemView) {
            super(itemView);

            cardContainer = (AutoRelativeLayout) itemView.findViewById(R.id.card_container);

        }
    }
}
