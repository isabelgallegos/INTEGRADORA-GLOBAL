package com.first.diana.mi.prueba_menu;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.afdroid.mi.prueba_menu.R;

public class Quizz extends AppCompatActivity implements View.OnClickListener {
    //Declarando de que tipo son las variables

    private RadioButton rbQuestion1;
    private RadioButton rbQuestion2;
    private RadioButton rbQuestion3;
    private RadioButton rbQuestion4;
    private RadioButton rbQuestion5;
    private RadioButton rbQuestion6;
    private RadioButton rbQuestion7;
    private RadioButton rbQuestion8;
    private RadioButton rbQuestion9;
    private Button btnResultados, btnContinue, btnBack;

    private Dialog startDialog;
    private ImageView imvClose;
    private TextView txvTitle, txvMsg, txvPuntuation, txvName;

    public int scoreTest = 0;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle(R.string.quiz);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //haciendo referencia de la respuesta en el archivo xml con su id
        rbQuestion1 = (RadioButton) findViewById(R.id.rb_question_good1);
        rbQuestion1.setOnClickListener(this);

        rbQuestion2 = (RadioButton) findViewById(R.id.rb_question_good2);
        rbQuestion2.setOnClickListener(this);

        rbQuestion3 = (RadioButton) findViewById(R.id.rb_question_good3);
        rbQuestion3.setOnClickListener(this);

        rbQuestion4 = (RadioButton) findViewById(R.id.rb_question_good4);
        rbQuestion4.setOnClickListener(this);

        rbQuestion5 = (RadioButton) findViewById(R.id.rb_question_good5);
        rbQuestion5.setOnClickListener(this);

        rbQuestion6 = (RadioButton) findViewById(R.id.rb_question_good6);
        rbQuestion6.setOnClickListener(this);

        rbQuestion7 = (RadioButton) findViewById(R.id.rb_question_good7);
        rbQuestion7.setOnClickListener(this);

        rbQuestion8 = (RadioButton) findViewById(R.id.rb_question_good8);
        rbQuestion8.setOnClickListener(this);

        rbQuestion9 = (RadioButton) findViewById(R.id.rb_question_good9);
        rbQuestion9.setOnClickListener(this);




        btnResultados = (Button)findViewById(R.id.btn_resultado);
        btnBack = (Button)findViewById(R.id.btn_back);



        startDialog = new Dialog(this);



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


        btnResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTestDialog();

            }
        });

    }


    @Override
    public void onClick(View v) {

      /*  if(rbQuestion1.isChecked()){
            scoreTest = scoreTest + 1;
            Toast.makeText(Test.this,"puntos "+scoreTest,Toast.LENGTH_LONG).show();
        }*/

        switch (v.getId()) {
            case (R.id.rb_question_good1):
                scoreTest = scoreTest + 1;
                // Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;
            case (R.id.rb_question_good2):
                scoreTest = scoreTest + 1;
                //Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;
            case (R.id.rb_question_good3):
                scoreTest = scoreTest + 1;
                //Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;
            case (R.id.rb_question_good4):
                scoreTest = scoreTest + 1;
                // Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;
            case (R.id.rb_question_good5):
                scoreTest = scoreTest + 1;
                //Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;
            case (R.id.rb_question_good6):
                scoreTest = scoreTest + 1;
                //Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;
            case (R.id.rb_question_good7):
                scoreTest = scoreTest + 1;
                //Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;
            case (R.id.rb_question_good8):
                scoreTest = scoreTest + 1;
                //Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;
            case (R.id.rb_question_good9):
                scoreTest = scoreTest + 1;
                //Toast.makeText(Test.this, "puntos " + scoreTest, Toast.LENGTH_LONG).show();
                break;

        }

        // Toast.makeText(Test.this, " puntos " + scoreTest, Toast.LENGTH_LONG).show();

    }

    private void showTestDialog() {

        if(scoreTest >=7){

            startDialog.setContentView(R.layout.popup_resultados);
            imvClose = (ImageView)startDialog.findViewById(R.id.imv_close);
            txvTitle = (TextView)startDialog.findViewById(R.id.txv_title);
            txvPuntuation = (TextView)startDialog.findViewById(R.id.txv_puntuacion);
            btnBack = (Button)findViewById(R.id.btn_back);


            txvPuntuation.setText(scoreTest + " points. Muy Bien");



            imvClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startDialog.dismiss();
                }
            });






            startDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            startDialog.show();


        }
        if(scoreTest <=6){
            startDialog.setContentView(R.layout.popup_resultados);
            imvClose = (ImageView)startDialog.findViewById(R.id.imv_close);
            txvTitle = (TextView)startDialog.findViewById(R.id.txv_title);
            txvPuntuation = (TextView)startDialog.findViewById(R.id.txv_puntuacion);


            txvPuntuation.setText(scoreTest + " points. Sigue Así");

            imvClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startDialog.dismiss();
                }
            });

            startDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            startDialog.show();
        }
        if(scoreTest <3){
            startDialog.setContentView(R.layout.popup_resultados);
            imvClose = (ImageView)startDialog.findViewById(R.id.imv_close);
            txvTitle = (TextView)startDialog.findViewById(R.id.txv_title);
            txvPuntuation = (TextView)startDialog.findViewById(R.id.txv_puntuacion);

            txvPuntuation.setText(scoreTest + " points. Necesitas Mejorar :(");

            imvClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startDialog.dismiss();
                }
            });

            startDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            startDialog.show();
        }



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
