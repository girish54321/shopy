package com.example.girish.shopy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.girish.shopy.LoginActivity;
import com.example.girish.shopy.R;
import com.example.girish.shopy.SharedPrefManger;

/**
 * A simple {@link Fragment} subclass.
 */
public class OthersFragment extends Fragment {
    
    TextView textViewnamem, textViewEmail;
    FloatingActionButton logout;


    public OthersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_others, container, false);
        
        textViewnamem = view.findViewById(R.id.user_name);
        textViewEmail = view.findViewById(R.id.userEmail);
        logout = view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOut();
            }
        });

        textViewEmail.setText(SharedPrefManger.getInstance(getActivity()).getUser().getEmail());
        textViewnamem.setText(SharedPrefManger.getInstance(getActivity()).getUser().getName());

        return view;
    }

    private void logOut(){
        SharedPrefManger.getInstance(getActivity()).clear();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
