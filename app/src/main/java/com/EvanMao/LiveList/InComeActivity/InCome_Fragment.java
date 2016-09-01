package com.EvanMao.LiveList.InComeActivity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.EvanMao.LiveList.R;
import com.EvanMao.Tool.UIFragmentControl;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InCome_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 * 收支情况
 */
public class InCome_Fragment extends UIFragmentControl implements IInComeView {


    private LinearLayout incomeContainer;
    private RecyclerView incomeC1List;
    private ImageView incomeC1Ifempty;
    private Button incomeC1More;
    private RecyclerView incomeC2List;
    private ImageView incomeC2Ifempty;
    private Button incomeC2More;
    private RecyclerView incomeC3List;
    private ImageView incomeC3Ifempty;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public InCome_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InCome_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InCome_Fragment newInstance(String param1, String param2) {
        InCome_Fragment fragment = new InCome_Fragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_in_come_, container, false);
        instanceView(view);

        return view;
    }

    private void instanceView(View view) {
        incomeContainer = (LinearLayout) view.findViewById(R.id.income_container);
        incomeC1List = (RecyclerView) view.findViewById(R.id.income_c1_list);
        incomeC1Ifempty = (ImageView) view.findViewById(R.id.income_c1_ifempty);
        incomeC1More = (Button) view.findViewById(R.id.income_c1_more);
        incomeC2List = (RecyclerView) view.findViewById(R.id.income_c2_list);
        incomeC2Ifempty = (ImageView) view.findViewById(R.id.income_c2_ifempty);
        incomeC2More = (Button) view.findViewById(R.id.income_c2_more);
        incomeC3List = (RecyclerView) view.findViewById(R.id.income_c3_list);
        incomeC3Ifempty = (ImageView) view.findViewById(R.id.income_c3_ifempty);
    }


    @Override
    public void LoadInfo() {

    }

    @Override
    public void Jump2NextActivity(Intent it) {
        startActivity(it);
    }
}
