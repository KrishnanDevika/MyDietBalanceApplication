package com.example.dietbalanceapplication.RecipesList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dietbalanceapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecipesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipesFragment newInstance(String param1, String param2) {
        RecipesFragment fragment = new RecipesFragment();
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
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);
        ListView recipeList = view.findViewById(R.id.recipeList);

        ArrayList<HealthyRecipes> recipesArrayList = new ArrayList<>();
        recipesArrayList.add(new HealthyRecipes(R.drawable.avacado, "Avocado Sandwich"));
        recipesArrayList.add(new HealthyRecipes(R.drawable.eggs, "Scrambled eggs"));
        recipesArrayList.add(new HealthyRecipes(R.drawable.quesadillas, "Greek Quesadillas"));
        recipesArrayList.add(new HealthyRecipes(R.drawable.veg, "Veggie Sandwich"));
        recipesArrayList.add(new HealthyRecipes(R.drawable.omlet, "Cheese Omelet"));
        recipesArrayList.add(new HealthyRecipes(R.drawable.salad, "Salad"));

        recipeList.setAdapter(new CustomListViewAdapter(getContext(), recipesArrayList));
        recipeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch(position){
                    case 0:
                        Navigation.findNavController(view).navigate(R.id.action_nav_recipe_to_avocadoFragment);
                        break;
                    case 1:
                        Navigation.findNavController(view).navigate(R.id.action_nav_recipe_to_eggsFragment);
                        break;
                    case 2:
                        Navigation.findNavController(view).navigate(R.id.action_nav_recipe_to_quesadillasFragment);
                        break;
                    case 3:
                        Navigation.findNavController(view).navigate(R.id.action_nav_recipe_to_veggieFragment);
                        break;
                    case 4:
                        Navigation.findNavController(view).navigate(R.id.action_nav_recipe_to_omeletFragment);
                        break;
                    case 5:
                        Navigation.findNavController(view).navigate(R.id.action_nav_recipe_to_saladFragment);
                        break;
                }
            }
        });
        return view;
    }
}