package com.example.dietbalanceapplication.DietTipsViewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dietbalanceapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HealthyTipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HealthyTipsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HealthyTipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HealthyTipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HealthyTipsFragment newInstance(String param1, String param2) {
        HealthyTipsFragment fragment = new HealthyTipsFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_healthy_tips, container, false);
        TextView tipsTextView = view.findViewById(R.id.tipsText);
        TextView tipsDesc = view.findViewById(R.id.tipsDesc);

        if(mParam1 != null){
            tipsTextView.setText(mParam1);
        }
        if(mParam2 != null){
            tipsDesc.setText(mParam2);
        }
        return view;
    }
}