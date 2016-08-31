package com.EvanMao.LiveList.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.EvanMao.LiveList.Adapter.PandectViewAdapter;
import com.EvanMao.LiveList.MainActivity.MainActivity;
import com.EvanMao.LiveList.R;
import com.EvanMao.Tool.UIFragmentControl;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pandect_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pandect_Fragment extends UIFragmentControl implements IMainFragmentView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView pandectList;
    private PandectViewAdapter pandectViewAdapter;
    private IFragment_presenter fragment_presenter;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Pandect_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pandect_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Pandect_Fragment newInstance(String param1, String param2) {
        Pandect_Fragment fragment = new Pandect_Fragment();
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
        pandectViewAdapter = new PandectViewAdapter(null, (MainActivity) this.getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pandect_, container, false);

        pandectList = (RecyclerView) view.findViewById(R.id.pandect_list);
        pandectList.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        pandectList.setAdapter(pandectViewAdapter);


        fragment_presenter = new Fragment_presenter(this);
        fragment_presenter.setPandectView();
        return view;
    }

    @Override
    public void ShowMainView(ArrayList<UIFragmentControl> sparseArray) {
        pandectViewAdapter.sparseArray = sparseArray;
        pandectViewAdapter.notifyDataSetChanged();

    }

    @Override
    public void Turn2Next(Intent it) {
        startActivity(it);
    }
}
