package com.first.diana.mi.prueba_menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.afdroid.mi.prueba_menu.R;


public class ForumFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_forum, container, false);
        // Inflate the layout for this fragment


        return vista;
    }
}
