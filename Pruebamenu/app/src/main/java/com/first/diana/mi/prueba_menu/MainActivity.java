package com.first.diana.mi.prueba_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.afdroid.mi.prueba_menu.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.progrees);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedor, new ProgressFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.myProfile) {
            goToProfile();
        }else if (id==R.id.signOut){
            signOut();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();

        if (id == R.id.games) {
            actionBar.setTitle(R.string.games);
            fragmentManager.beginTransaction().replace(R.id.contenedor, new GamesFragment()).commit();
        } else if (id == R.id.evaluation) {
            actionBar.setTitle(R.string.evaluation);
            fragmentManager.beginTransaction().replace(R.id.contenedor, new EvaluationFragment()).commit();
        } else if (id == R.id.forum) {
            actionBar.setTitle(R.string.forum);
            fragmentManager.beginTransaction().replace(R.id.contenedor, new ForumFragment()).commit();
        } else if (id == R.id.progress) {
            actionBar.setTitle(R.string.progrees);
            fragmentManager.beginTransaction().replace(R.id.contenedor, new ProgressFragment()).commit();
        } else if (id == R.id.about) {
            actionBar.setTitle(R.string.about);
            fragmentManager.beginTransaction().replace(R.id.contenedor, new AboutFragment()).commit();

        }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;

    }

    private void goToProfile() {
        Intent intentLogin = new Intent(MainActivity.this, ProfileActivity.class);
        startActivity(intentLogin);
    }

    private void signOut() {
        mAuth.signOut();
            Intent intentLogin = new Intent(MainActivity.this, Login.class);
            startActivity(intentLogin);
            finish();
        }

    }




