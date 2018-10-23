package com.first.diana.mi.prueba_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.afdroid.mi.prueba_menu.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private CircleImageView imageUser;
    private TextView lblName;
    private TextView lblEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setTitle(getString(R.string.my_profile));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        imageUser = findViewById(R.id.imgUserProfile);
        lblName = findViewById(R.id.lblNameProfile);
        lblEmail = findViewById(R.id.lblEmailProfile);

        lblEmail.setText(user.getEmail());

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