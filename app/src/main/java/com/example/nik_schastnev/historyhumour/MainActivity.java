package com.example.nik_schastnev.historyhumour;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import android.widget.ImageView;

import com.example.nik_schastnev.historyhumour.antiquity.AntiquityActivity;
import com.example.nik_schastnev.historyhumour.fragments.BestFragment;
import com.example.nik_schastnev.historyhumour.fragments.NewsFragment;
import com.example.nik_schastnev.historyhumour.fragments.ProfileFragment;
import com.example.nik_schastnev.historyhumour.fragments.RubricsFragment;
import com.example.nik_schastnev.historyhumour.fragments.SendFragment;
import com.example.nik_schastnev.historyhumour.middle_ages.MiddleAgesActivity;
import com.example.nik_schastnev.historyhumour.new_time.NewTimeActivity;
import com.example.nik_schastnev.historyhumour.others.OthersActivity;
import com.example.nik_schastnev.historyhumour.twentieth.TwentiethActivity;
import com.example.nik_schastnev.historyhumour.twenty_first.TwentyFirstActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new RubricsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_rubrics);
        }
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        ImageView imageAntiquity = new ImageView(this);
        imageAntiquity.setImageResource(R.drawable.ic_antiquity);
        setContentView(imageAntiquity);

        ImageView imageMiddleAge = new ImageView(this);
        imageMiddleAge.setImageResource(R.drawable.ic_middle_ages);
        setContentView(imageMiddleAge);

        ImageView imageNewTime = new ImageView(this);
        imageNewTime.setImageResource(R.drawable.ic_new_time);
        setContentView(imageNewTime);

        ImageView imageTwentieth = new ImageView(this);
        imageTwentieth.setImageResource(R.drawable.ic_twentieth);
        setContentView(imageTwentieth);

        ImageView imageTwentyFirst = new ImageView(this);
        imageTwentyFirst.setImageResource(R.drawable.ic_twenty_first);
        setContentView(imageTwentyFirst);

        ImageView imageOthers = new ImageView(this);
        imageOthers.setImageResource(R.drawable.ic_others);
        setContentView(imageOthers);

        return super.onOptionsItemSelected(item);
    }

    public void toAntiquityActivity(View view) {
        Intent intent = new Intent(this, AntiquityActivity.class);
        startActivity(intent);
    }

    public void toMiddleAgesActivity(View view) {
        Intent intent = new Intent(this, MiddleAgesActivity.class);
        startActivity(intent);
    }

    public void toNewTimeActivity(View view) {
        Intent intent = new Intent(this, NewTimeActivity.class);
        startActivity(intent);
    }

    public void toTwentiethActivity(View view) {
        Intent intent = new Intent (this, TwentiethActivity.class);
        startActivity(intent);
    }

    public void toTwentyFirstActivity(View view) {
        Intent intent = new Intent (this, TwentyFirstActivity.class);
        startActivity(intent);
    }

    public void toOthersActivity(View view) {
        Intent intent = new Intent(this, OthersActivity.class);
        startActivity(intent);
    }

    public void btnSendPost(View view) {
        Snackbar.make(view,
                "Спасибо за отправление. Вашу запись мы рассмотрим в ближайшее время",
                Snackbar.LENGTH_LONG).show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_rubrics:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RubricsFragment()).commit();
                break;
            case R.id.nav_news:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NewsFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_best:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BestFragment()).commit();
                break;
            case R.id.nav_send:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SendFragment()).commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}