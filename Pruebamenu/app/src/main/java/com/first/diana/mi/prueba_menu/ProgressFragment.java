package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.afdroid.mi.prueba_menu.R;


public class ProgressFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_progress, container, false);
        /* Inflate the layout for this fragment */

        ImageView quiz = (ImageView) v.findViewById(R.id.imv_quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Quizz.class);
                startActivity(intent);
            }
        });


        ImageView agen = (ImageView) v.findViewById(R.id.imvagen);
        agen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ImagenGallery.class);
                startActivity(intent);
            }
        });


        ImageView video = (ImageView) v.findViewById(R.id.imv_video);
        video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), VideoActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
