package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.afdroid.mi.prueba_menu.R;


public class GamesFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_games, container, false);
        /* Inflate the layout for this fragment */

        ImageView puzz = (ImageView) v.findViewById(R.id.imv_puzz);
       puzz.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
               Intent intent = new Intent(getActivity(),PlayPuzzle.class);
                startActivity(intent);
            }
        });


        ImageView orca = (ImageView) v.findViewById(R.id.imvorca);
        orca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Ahorcado.class);
                startActivity(intent);
            }
        });

        ImageView cat = (ImageView) v.findViewById(R.id.imv_gato);
        cat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TicTac.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
