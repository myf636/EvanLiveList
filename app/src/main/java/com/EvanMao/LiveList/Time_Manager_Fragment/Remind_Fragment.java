package com.EvanMao.LiveList.Time_Manager_Fragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.EvanMao.LiveList.Adapter.Remind_Item_Adapter;
import com.EvanMao.LiveList.MainActivity.MainActivity;
import com.EvanMao.LiveList.R;
import com.EvanMao.Tool.UIFragmentControl;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Remind_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Remind_Fragment extends UIFragmentControl {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView remindList;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Remind_Item_Adapter remind_item_adapter;

    public Remind_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Remind_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Remind_Fragment newInstance(String param1, String param2) {
        Remind_Fragment fragment = new Remind_Fragment();
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
        remind_item_adapter = new Remind_Item_Adapter((MainActivity) this.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remind_, container, false);

        remindList = (RecyclerView) view.findViewById(R.id.remind_list);
        remindList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        remindList.setAdapter(remind_item_adapter);
        return view;
    }

}
