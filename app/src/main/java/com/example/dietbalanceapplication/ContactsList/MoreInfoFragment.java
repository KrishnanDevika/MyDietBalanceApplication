package com.example.dietbalanceapplication.ContactsList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dietbalanceapplication.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MoreInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MoreInfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MoreInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MoreInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MoreInfoFragment newInstance(String param1, String param2) {
        MoreInfoFragment fragment = new MoreInfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_more_info, container, false);
        ListView contactList = view.findViewById(R.id.contactList);

        //List to add all the list items
        ArrayList<Contacts> contacts = new ArrayList<>();
        contacts.add(new Contacts(R.drawable.ic_baseline_location_on_24, "Location", "Diet Center Nearby"));
        contacts.add(new Contacts(R.drawable.ic_baseline_email_24, "Email", "aaradietcare@adc.com"));
        contacts.add(new Contacts(R.drawable.ic_baseline_call_24, "Call", "+1 229(246)4536"));
        contacts.add(new Contacts(R.drawable.ic_baseline_message_24, "SMS", "+1 229(246)4536"));
        contacts.add(new Contacts(R.drawable.ic_baseline_facebook_24, "Follow us", "https://www.facebook.com/"));

        contactList.setAdapter(new CustomContactListAdapter(getContext(), contacts));
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){
                    case 0:
                        //Map Intents
                        Uri location = Uri.parse("geo:42.30615797210299, -82.97915163928572?&q=Diet+Center");
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                        try{
                            startActivity(mapIntent);

                        }catch(Exception e){
                            Toast.makeText(getContext(),"Cannot Open Maps",Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 1:
                        //Email Intent
                        String EmailAddress[] = {"aaramvarma@gmail.com"};
                        Intent emailIntent = new Intent(Intent.ACTION_SEND);
                        emailIntent.setData(Uri.parse("mailto:"));
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, EmailAddress);
                        try{
                            startActivity(emailIntent);

                        }catch(Exception e){
                            Toast.makeText(getContext(),"No Apps found",Toast.LENGTH_LONG).show();
                        }

                        break;
                    case 2:
                        //Phone Intent
                        Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:2292464536"));
                        try{
                            startActivity(phoneIntent);

                        }catch(Exception e){
                            Toast.makeText(getContext(),"No Apps found",Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 3:
                        //SMS Intent
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO,
                                Uri.parse("smsto:2292464536"));
                        try{
                            startActivity(smsIntent);

                        }catch(Exception e){
                            Toast.makeText(getContext(),"No Apps found",Toast.LENGTH_LONG).show();
                        }
                        break;
                    case 4:
                        //Web Intent
                        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.facebook.com/Diet-Center-77735372982/"));
                        try{
                            startActivity(webIntent);

                        }catch(Exception e){
                            Toast.makeText(getContext(),"No Apps found",Toast.LENGTH_LONG).show();
                        }
                        break;
                }

            }
        });
        return view;
    }
}