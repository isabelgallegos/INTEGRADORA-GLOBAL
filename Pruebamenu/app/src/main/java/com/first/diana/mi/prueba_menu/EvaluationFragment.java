package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.afdroid.mi.prueba_menu.R;


public class EvaluationFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_evaluation, container, false);
        // Inflate the layout for this fragment


        Button intro = (Button) v.findViewById(R.id.btnIntro);
        intro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TemaIntroduction.class);
                startActivity(intent);
            }
        });


        Button temaUno = (Button) v.findViewById(R.id.btnI);
        temaUno.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),OneTema.class);
                startActivity(intent);
            }
        });

        Button temaDos = (Button) v.findViewById(R.id.btnII);
        temaDos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TwoTema.class);
                startActivity(intent);
            }
        });

        Button temaTres = (Button) v.findViewById(R.id.btnIII);
        temaTres.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ThreeTema.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
