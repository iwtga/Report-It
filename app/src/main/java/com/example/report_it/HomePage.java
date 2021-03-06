package com.example.report_it;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.report_it.Contact_and_feedback.ContactUs;
import com.example.report_it.Contact_and_feedback.Feedback;
import com.example.report_it.MissingPeopleClasses.MissingPeople;
import com.example.report_it.NearbyPlaceClasses.NearestEmergency;
import com.example.report_it.WantedCriminalClasses.WantedCriminal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ImageButton imgbtnNews,imgbtnEmergencyCall,imgbtnNearestLoc,imgbtnWantedCriminal,imgbtnMissingPeople;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        imgbtnEmergencyCall=(ImageButton)findViewById(R.id.imgBtnEmergency);
        imgbtnNearestLoc=(ImageButton)findViewById(R.id.imgBtnNearestLoc);
        imgbtnMissingPeople=(ImageButton)findViewById(R.id.imgBtnMissing);
        imgbtnWantedCriminal=(ImageButton)findViewById(R.id.imgBtnWanted);
        imgbtnNews=(ImageButton)findViewById(R.id.imgBtnNews);

        imgbtnEmergencyCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(getApplicationContext(), Emergency.class);
                startActivity(intent1);
            }
        });
        imgbtnNearestLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(getApplicationContext(), NearestEmergency.class);
                startActivity(intent1);
            }
        });
        imgbtnMissingPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(getApplicationContext(), MissingPeople.class);
                startActivity(intent1);
            }
        });
        imgbtnWantedCriminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 =new Intent(getApplicationContext(), WantedCriminal.class);
                startActivity(intent1);
            }
        });
        /*imgbtnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(getApplicationContext(), News.class);
                startActivity(intent1);
            }
        });*/



        //Navigation View
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent1;
        switch(item.getItemId())
        {
            case R.id.item_contactUs:
                intent1 =new Intent(getApplicationContext(), ContactUs.class);
                startActivity(intent1);
                break;
            case R.id.item_give_feedback:
                intent1 =new Intent(getApplicationContext(), Feedback.class);
                startActivity(intent1);
                break;
        }
        return true;
    }

}