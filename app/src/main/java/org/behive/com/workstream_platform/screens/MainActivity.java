package org.behive.com.workstream_platform.screens;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.behive.com.workstream_platform.MyApplication;
import org.behive.com.workstream_platform.R;
import org.behive.com.workstream_platform.model.BaseResponse;
import org.behive.com.workstream_platform.model.User;
import org.behive.com.workstream_platform.repo.UserRepository;
import org.behive.com.workstream_platform.utils.AppLog;
import org.behive.com.workstream_platform.utils.SharedPrefs;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements ActivityView {
    private static final String TAG = MainActivity.class.getSimpleName();
    private NavController navController;
    private DrawerLayout drawer;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navController = Navigation.findNavController(this, R.id.main_nav_host_fragment);

        drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        View navigationHeaderView = navigationView.getHeaderView(0);
        navigationHeaderView.setOnClickListener(view -> {
            drawer.closeDrawer(GravityCompat.START);
        });


        NavigationUI.setupWithNavController(toolbar, navController, drawer);
        NavigationUI.setupActionBarWithNavController(this, navController, drawer);

        String token = SharedPrefs.getInstance().getString(SharedPrefs.Constants.IS_USER_LOGGED_IN_KEY, "");
        if (!TextUtils.isEmpty(token)) {
            updateUserInfo();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public NavController getNavController() {
        return navController;
    }

    public void updateUserInfo(){
        userRepository = ((MyApplication)getApplication()).getUserRepository();
        userRepository.getCurrentUserInfo().observe(this, userBaseResponse -> {
            if (userBaseResponse != null && userBaseResponse.getData() != null){
                User user = userBaseResponse.getData();
                AppLog.i(TAG + " getCurrentUserInfo user = " + user);
            } else {
                AppLog.w(TAG + " getCurrentUserInfo FAIL = ");
            }
        });
    }

}
