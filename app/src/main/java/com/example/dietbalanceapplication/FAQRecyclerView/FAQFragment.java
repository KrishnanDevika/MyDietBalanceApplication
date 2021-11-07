package com.example.dietbalanceapplication.FAQRecyclerView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dietbalanceapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FAQFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FAQFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FAQFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FAQFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FAQFragment newInstance(String param1, String param2) {
        FAQFragment fragment = new FAQFragment();
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
        View view = inflater.inflate(R.layout.fragment_f_a_q, container, false);
        ArrayList<FAQ> faqs = new ArrayList<>();
        faqs.add(new FAQ("How important are fruit and veg?","To achieve a healthy diet, vegetables and fruit must be a vital feature to ensure the access to a mixture of vitamins and minerals that are abundant within them. Not only do fruit and veg provide a rich source of vitamins, minerals and antioxidants, they also serve as a source of energy, aid weight loss and can be an influential tool in the prevention of disease."));
        faqs.add(new FAQ("In what way is fibre healthy?","Fibre is an essential element for any balanced diet, its main purpose is the promotion of digestive health and the movement of the digestive system, but fibre also has many other health benefits. Prevention of heart disease, diabetes, weight gain, cancers and so on are all influenced by fibre, making it a necessary part of a healthy lifestyle."));
        faqs.add(new FAQ("Are foods that contain sugar unhealthy?","Sugar can be an enemy to a healthy diet, tasting so delicious in a variety of food and even hidden in foods that you wouldn’t suspect. Yet it is important to address the difference between natural and added sugars for a healthy diet. Sugars are carbs which provide a vital source of energy and nutrition, yet many popular foods have sugar added to them, this is when sugars become unhealthy."));
        faqs.add(new FAQ("Are carbs unhealthy?","Many different foods contain carbs, including the typical foods such as pastas and breads, yet fruits and vegetables also contain carbohydrates, which are a healthy source of not only energy but also vitamins and nutrients. Processed carbohydrates can impact your health, and when trying to lose weight restricting carbs may be helpful, but carbs are a significant element to a balanced diet "));
        faqs.add(new FAQ("What are the symptoms or signs that a person is not getting enough vitamin D?","Some people who aren’t getting enough vitamin D have pain in their bones, trouble getting around, and are more prone to infections. Though it’s rare, children with a vitamin D deficiency can get rickets, which is a condition that causes bones to become soft and bendable."));
        faqs.add(new FAQ("What is weight loss medication?","Weight loss medications are designed for people who have tried losing weight with diet and exercise alone. Most weight loss medications can help people lose five to 10 pounds."));
        faqs.add(new FAQ("What are the health benefits of eating fish?","Fish are an important part of a healthy diet.\n" +
                "Along with other seafood, fish provide you with protein, vitamin D, and healthy omega-3 fats."));
        faqs.add(new FAQ("What is the relationship between eating healthily and calories?","Calories are your body’s source of fuel. We need to refuel our energy supply by eating food, yet many diets have branded calories as our enemy for weight, yet calories are a necessary part of our lives. "));

        RecyclerView recyclerView = view.findViewById(R.id.faqView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CustomRecyclerViewAdapter(faqs));

        return view;
    }
}