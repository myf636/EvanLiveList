package com.EvanMao.LiveList.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.EvanMao.LiveList.R;
import com.EvanMao.LiveList.Time_Manager_Fragment.Plan_Fragment;
import com.EvanMao.LiveList.Time_Manager_Fragment.Record_Fragment;
import com.EvanMao.LiveList.Time_Manager_Fragment.Remind_Fragment;
import com.EvanMao.Tool.UIFragmentControl;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimeManager_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeManager_Fragment extends UIFragmentControl implements IMainFragmentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ViewPager timeManagerVpContainer;
    private TabLayout timeManagerBtTab;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private BannerPagerAdapter bannerPagerAdapter;
    private int page = 0;

    public TimeManager_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeManager_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeManager_Fragment newInstance(String param1, String param2) {
        TimeManager_Fragment fragment = new TimeManager_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        bannerPagerAdapter = new BannerPagerAdapter(this.getFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_manager_, container, false);


        timeManagerVpContainer = (ViewPager) view.findViewById(R.id.time_manager_vp_container);
        timeManagerBtTab = (TabLayout) view.findViewById(R.id.time_manager_bt_tab);
        timeManagerVpContainer.setOffscreenPageLimit(0);
        timeManagerVpContainer.setAdapter(bannerPagerAdapter);
        timeManagerBtTab.setupWithViewPager(timeManagerVpContainer);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(v -> Toast.makeText(this.getActivity(), "11", Toast.LENGTH_SHORT)
                .show());
        return view;
    }

    @Override
    public void ShowMainView(SparseArray<UIFragmentControl> sparseArray) {

    }

    @Override
    public void Turn2Next(Intent it) {

    }

    private class BannerPagerAdapter extends FragmentStatePagerAdapter {
        public BannerPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int i) {
            UIFragmentControl fragment;
            switch (i) {
                case 0:
                    fragment = Remind_Fragment.newInstance(null, null);
                    break;
                case 1:
                    fragment = Record_Fragment.newInstance(null, null);
                    break;
                case 2:
                    fragment = Plan_Fragment.newInstance(null, null);
                    break;
                default:
                    fragment = Remind_Fragment.newInstance(null, null);
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            page=position;
            switch (position) {
                case 0:
                    return getString(R.string.bt_tab1);

                case 1:
                    return getString(R.string.bt_tab2);

                case 2:
                    return getString(R.string.bt_tab3);

                default:
                    return "";
            }

        }
    }
}
