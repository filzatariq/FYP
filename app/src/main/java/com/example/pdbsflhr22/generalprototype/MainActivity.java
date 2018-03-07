package com.example.pdbsflhr22.generalprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    TextView tv_register;
    Button btn_post;
    Toolbar toolbar;
    FloatingActionButton fab;
    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        btn_post=(Button) findViewById(R.id.btn_post);
        btn_post.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
         drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent account =new Intent(MainActivity.this,MainActivity.class);
            startActivity(account);
        } else if (id == R.id.nav_rides) {
            Intent myrides =new Intent(MainActivity.this,RideActivity.class);
            startActivity(myrides);
        } else if (id == R.id.nav_help) {
            Intent help =new Intent(MainActivity.this,AboutUs.class);
            startActivity(help);
        }  else if (id == R.id.nav_setting) {
            Intent setting =new Intent(MainActivity.this,SettingActivity.class);
            startActivity(setting);
        } else if (id == R.id.nav_invite) {
            Intent invite =new Intent(MainActivity.this,MainActivity.class);
            startActivity(invite);

        } else if (id == R.id.nav_rate) {
            Intent rate =new Intent(MainActivity.this,MainActivity.class);
            startActivity(rate);

        }
        else if (id == R.id.captain) {
            Intent driver =new Intent(MainActivity.this,SignupActivity.class);
            startActivity(driver);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_post:
                startActivity(new Intent(MainActivity.this,MapsActivity.class));
            break;
            case R.id.btn_find:
                startActivity(new Intent(MainActivity.this,RideActivity.class));
                break;
                default:break;
        }
    }
}