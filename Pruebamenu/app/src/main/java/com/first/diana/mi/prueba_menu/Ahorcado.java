package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afdroid.mi.prueba_menu.R;

public class Ahorcado extends AppCompatActivity {
    private LinearLayout layout;
    static String palabra = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle(R.string.hanged);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Obtencion de las vistas:
        layout = (LinearLayout) findViewById(R.id.activityGameAh);

        // Modificacion de la fuente para las vistas:
//		Typeface tf = Typeface.createFromAsset(getAssets(), "tiza.ttf");

        for (int i = 0; i < layout.getChildCount(); i++) {
            View vista = layout.getChildAt(i);
            if (vista.getClass() == TextView.class
                    || vista.getClass() == Button.class) {
//				((TextView) vista).setTypeface(tf, Typeface.BOLD);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_insertar:
                lanzarInsercion(null);
                break;
            case R.id.action_jugar:
                lanzarJuego(null);
                break;
            case R.id.action_salir:
                finish();
                //salir(null);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void lanzarInsercion(View view) {
        Intent intent = new Intent(this, InsertWordAho.class);
        startActivity(intent);
    }

    public void lanzarJuego(View view) {
        if (palabra != null) {
            Intent intent = new Intent(this, JuegoAho.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.error_fatal_word,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void salir(View view) {
        finish();
    }



}
