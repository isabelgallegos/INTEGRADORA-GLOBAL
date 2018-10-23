package com.first.diana.mi.prueba_menu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.afdroid.mi.prueba_menu.R;

public class ImagenGallery extends AppCompatActivity {
    ImageView selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle(R.string.gallery);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        Gallery gallery =(Gallery) findViewById(R.id.gallery);
        selectedImage=(ImageView)findViewById(R.id.imageView);
        gallery.setSpacing(1);
        final GalleryImageAdapter galleryImageAdapter= new GalleryImageAdapter(this);
        gallery.setAdapter(galleryImageAdapter);


        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // show the selected Image
                selectedImage.setImageResource(galleryImageAdapter.mImageIds[position]);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
