package com.example.dietbalanceapplication.DietTipsViewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int mParam3;

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
    public static HealthyTipsFragment newInstance(String param1, String param2, int param3) {
        HealthyTipsFragment fragment = new HealthyTipsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_healthy_tips, container, false);
        TextView tipsTextView = view.findViewById(R.id.tipsText);
        TextView tipsDesc = view.findViewById(R.id.tipsDesc);
        ImageView tipImage = view.findViewById(R.id.tipsImage);

        if(mParam1 != null){
            tipsTextView.setText(mParam1);
        }
        if(mParam2 != null){
            tipsDesc.setText(mParam2);
        }

        if(mParam3 != 0){
            tipImage.setImageResource(mParam3);
        }

        LinearLayout layout = view.findViewById(R.id.dietContent);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.content_animation);
        layout.startAnimation(animation);

        return view;
    }
}