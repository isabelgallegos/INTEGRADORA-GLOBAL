package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.afdroid.mi.prueba_menu.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    private Button btnCancel;
    private FirebaseAuth mAuth;
    private EditText email;
    private EditText pass;
    private Button btnSingUp;
    private String userEmail, userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.txtEmailSingUp);
        pass = findViewById(R.id.txtPassSingUp);



        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        btnSingUp= findViewById(R.id.btnSignUp);

        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userEmail = email.getText().toString().trim();
                userPass = pass.getText().toString().trim();
                if(validate(userEmail, userPass)){
                    singUp(userEmail, userPass);
                }

            }

        });

    }
    private void startPrincipalActivity(){
        Intent intentPrincipal = new Intent(Register.this,MainActivity.class);
        startActivity(intentPrincipal);
        finish();
    }

    private void singUp(String userEmail, String userPass){
        mAuth.createUserWithEmailAndPassword(userEmail, userPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startPrincipalActivity();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Register.this, getString(R.string.failed_register), Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }

    private boolean validate(String eml, String pwd){
        boolean b1, b2;
        b1 = TextUtils.isEmpty(eml);
        b2 = TextUtils.isEmpty(pwd);
        if(b1 && b2){
            email.setError(getString(R.string.field_validation));
            pass.setError(getString(R.string.field_validation));
            return false;
        }else if (b1) {
            email.setError(getString(R.string.field_validation));
            return false;
        }else if (b2){
            pass.setError(getString(R.string.field_validation));
            return false;
        }else {
            return true;
        }

    }

    private void canceld() {
        Intent intentLogin = new Intent(Register.this, Login.class);
        startActivity(intentLogin);
    }
}
