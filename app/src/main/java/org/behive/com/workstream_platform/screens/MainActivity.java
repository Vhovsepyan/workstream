package org.behive.com.workstream_platform.screens;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.behive.com.workstream_platform.R;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements ActivityView {

    private NavController navController;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navController = Navigation.findNavController(this, R.id.main_nav_host_fragment);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        View navigationHeaderView = navigationView.getHeaderView(0);
        navigationHeaderView.setOnClickListener(view -> {
            drawer.closeDrawer(GravityCompat.START);
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);


        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(toolbar, navController, drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, drawer);

    }

    @Override
    public NavController getNavController() {
        return navController;
    }

    @Override
    public void setNavigationVisible(boolean visible) {
        bottomNavigationView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }
}
