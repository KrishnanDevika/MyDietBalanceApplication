package com.example.dietbalanceapplication.DietTipsViewPager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.dietbalanceapplication.R;

public class CustomViewPagerAdapter extends FragmentStateAdapter {

    public CustomViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        position = position % 10;

        switch (position){
            case 0:
                return HealthyTipsFragment.newInstance("Drink Lots of Water", " \t\t\t\tDrinking enough water throughout the day is good for overall health and can even help you maintain a healthy weight. Drink a glass of water before you dive into a snack. People sometimes confuse thirst with hunger, so you can end up eating extra calories when an ice-cold glass of water is really all you needed. ", R.drawable.water);

            case 1:
                return HealthyTipsFragment.newInstance("Eat fruits and Vegetables everyday", "\t\t\t\tPick out a new fruit or vegetable in the grocery store each week, and figure out together how to cook or prepare it in a healthy way. Vegetables are loaded with fiber and the nutrients your body craves.", R.drawable.fruitsveggies);

            case 2:
                return HealthyTipsFragment.newInstance("Never Skip Breakfast", "\t\t\t\tBreakfast is the most important meal of the day! Opt for something that will release energy slowly — porridge and a handful of blueberries are a great option!. Not eating breakfast can make you hungry later, leading to too much nibbling and binge eating at lunch and dinner.", R.drawable.breakfast);

            case 3:
                return HealthyTipsFragment.newInstance("Eat protein at every Meal", "\t\t\t\tProtein is the ultimate fill-me-up food -- it's more satisfying than carbs or fats and keeps you feeling full for longer. So be sure to incorporate healthy proteins like seafood, lean meat, egg whites, yogurt, cheese, soy, nuts, or beans into your meals and snacks.", R.drawable.protein);

            case 4:
                return HealthyTipsFragment.newInstance("Include Fibre in your Diet", "\t\t\t\tFiber aids digestion, prevents constipation, and lowers cholesterol -- and can help with weight loss. Increasing your intake is as easy as adding beans to your salad, eating oats for breakfast or snacking on fiber-rich nuts and seeds.",R.drawable.fibre);

            case 5:
                return HealthyTipsFragment.newInstance("Get Enough sleep", " \t\t\t\tGetting enough sleep may make you feel rested and full and keep you from doing unnecessary snacking.",R.drawable.sleep);

            case 6:
                return HealthyTipsFragment.newInstance("Ditch Added Sugar", "\t\t\t\tAdded sugar, especially from sugary drinks, is a major reason for unhealthy weight gain and health problems like diabetes and heart disease. Cutting out foods high in added sugars is a great way to lose excess weight.",R.drawable.sugar);

            case 7:
                return HealthyTipsFragment.newInstance("Walk your way to health", "\t\t\t\tMany people believe they must adopt a rigorous exercise routine to jumpstart weight loss.While different types of activity are important when you’re attempting to get in shape, walking is an excellent and easy way to burn calories.",R.drawable.walk);

            default:
                return HealthyTipsFragment.newInstance("Fragment Not Found", "404 Error",0);

        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
