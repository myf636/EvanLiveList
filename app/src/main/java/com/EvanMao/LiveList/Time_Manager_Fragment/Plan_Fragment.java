package com.EvanMao.LiveList.Time_Manager_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.EvanMao.LiveList.Adapter.Plan_Item_Adapter;
import com.EvanMao.LiveList.MainActivity.MainActivity;
import com.EvanMao.LiveList.R;
import com.EvanMao.Tool.UIFragmentControl;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Plan_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Plan_Fragment extends UIFragmentControl {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView planList;
    private Plan_Item_Adapter plan_item_adapter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Plan_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Plan_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Plan_Fragment newInstance(String param1, String param2) {
        Plan_Fragment fragment = new Plan_Fragment();
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
        plan_item_adapter = new Plan_Item_Adapter((MainActivity) this.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plan_, container, false);


        planList = (RecyclerView) view.findViewById(R.id.plan_list);
        planList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        planList.setAdapter(plan_item_adapter);
        return view;
    }

}
