package com.example.dietbalanceapplication.ContactsList;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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

        ArrayList<Contacts> contacts = new ArrayList<>();
        contacts.add(new Contacts(R.drawable.ic_baseline_location_on_24, "Location", "Diet Center Nearby"));
        contacts.add(new Contacts(R.drawable.ic_baseline_email_24, "Email", "aaradietcare@adc.com"));
        contacts.add(new Contacts(R.drawable.ic_baseline_call_24, "Call", "+1 219(246)4536"));
        contacts.add(new Contacts(R.drawable.ic_baseline_message_24, "SMS", "+1 219(246)4536"));
        contacts.add(new Contacts(R.drawable.ic_baseline_facebook_24, "Follow us", "sample"));

        contactList.setAdapter(new CustomContactListAdapter(getContext(), contacts));
        return view;
    }
}