package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.afdroid.mi.prueba_menu.R;

public class TicTac extends AppCompatActivity implements View.OnClickListener {
    private Button vsMaquina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setTitle(R.string.tictac);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        vsMaquina =(Button) findViewById(R.id.maquinaBtn);
        vsMaquina.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.maquinaBtn:
                Intent activityMachine = new Intent(TicTac.this, MachineTicTac.class);
                startActivity(activityMachine);
                break;
            case R.id.personaBtn:
                Intent activityPersona = new Intent(TicTac.this, PersonTicTac.class);
                startActivity(activityPersona);
                break;
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
