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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private Button btnRegister;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private Button btnSignIn;
    private String userEmail, userPass;
    private EditText email;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        user = mAuth.getCurrentUser();

        email = findViewById(R.id.txtEmailSignIn);
        pass = findViewById(R.id.txtPassSignIn);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLogin = new Intent(Login.this,Register.class);
                startActivity(intentLogin);
            }
        });

        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userEmail = email.getText().toString().trim();
                userPass = pass.getText().toString().trim();
                if(validate(userEmail, userPass)){
                    signIn(userEmail,userPass);
                }
            }
        });

    }

    private void signIn(String eml, String pwd) {
        mAuth.signInWithEmailAndPassword(eml, pwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            goToMain();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Login.this, getString(R.string.faild_auth),
                                    Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onStart() {
        super.onStart();
        if(user!=null){
            goToMain();
        }

    }

    private void goToMain() {
        Intent intentMain = new Intent(Login.this, MainActivity.class);
        startActivity(intentMain);
    }
}
