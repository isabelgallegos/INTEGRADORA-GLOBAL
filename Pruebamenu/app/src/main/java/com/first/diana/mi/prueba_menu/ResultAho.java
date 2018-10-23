package com.first.diana.mi.prueba_menu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.afdroid.mi.prueba_menu.R;

public class ResultAho extends Activity {
    private LinearLayout layout;
    private TextView vistaResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_aho);

        // Obtencion de las vistas:
        layout = (LinearLayout) findViewById(R.id.LinearLayout4);
        vistaResultado = (TextView) findViewById(R.id.resultado);

        // Obtencion del resultado
        Bundle extras = getIntent().getExtras();
        boolean resultado = extras.getBoolean("resultado");

        // Mostramos un texto u otro en funcion del resultado, con un color
        if (resultado) {
            vistaResultado.setText(R.string.resultado_ganar);
            vistaResultado.setTextColor(Color.GREEN);
        } else {
            vistaResultado.setText(R.string.resultado_perder);
            vistaResultado.setTextColor(Color.RED);
        }

        // Modificacion de la fuente:
        //Typeface tf = Typeface.createFromAsset(getAssets(), "tiza.ttf");

        for (int i = 0; i < layout.getChildCount(); i++) {
            View vista = layout.getChildAt(i);
            if (vista.getClass() == TextView.class
                    || vista.getClass() == Button.class) {
                //		((TextView) vista).setTypeface(tf, Typeface.BOLD);
            }
        }
    }

    public void lanzarMenu(View view) {
        Intent intent = new Intent(this, Ahorcado.class);
        startActivity(intent);
    }

}
