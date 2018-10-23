package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.afdroid.mi.prueba_menu.R;


public class AboutFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        // Inflate the layout for this fragment


            ImageView face = (ImageView) v.findViewById(R.id.imv_fa);
            face.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Uri uriUrl2 = Uri.parse("https://www.facebook.com");
                 Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl2);

                 startActivity(intent);
             }

             });

        ImageView you = (ImageView) v.findViewById(R.id.imv_yo);
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl2 = Uri.parse("https://www.youtube.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl2);

                startActivity(intent);
            }

        });

        ImageView whatss = (ImageView) v.findViewById(R.id.imv_wha);
        whatss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl2 = Uri.parse("https://www.twitter.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uriUrl2);

                startActivity(intent);
            }

        });


        return v;
    }


}
