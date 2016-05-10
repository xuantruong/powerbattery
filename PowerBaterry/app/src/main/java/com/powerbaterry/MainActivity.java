package com.powerbaterry;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.powerbaterry.base.BaseManager;
import com.powerbaterry.config.Rconfig;
import com.powerbaterry.menutop.fragment.MenuTopFragment;
import com.powerbaterry.slidemenu.fragment.SlideMenuFragment;

public class MainActivity extends FragmentActivity {


    private SlideMenuFragment mNavigationDrawerFragment;

    public static Activity context;
    public static MainActivity instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseManager.getIntance().setCurrentActivity(this);
        BaseManager.getIntance().setCurrentContext(getApplicationContext());
        context = this;
        setContentView(R.layout.core_main_activity);


        mNavigationDrawerFragment = (SlideMenuFragment) getSupportFragmentManager()
                .findFragmentById(Rconfig.getInstance().id("navigation_drawer"));
        mNavigationDrawerFragment.setup(
                Rconfig.getInstance().id("navigation_drawer"),
                (DrawerLayout) findViewById(Rconfig.getInstance().id(
                        "drawer_layout")));


        FragmentTransaction mFragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        MenuTopFragment fragmentMenuTop = MenuTopFragment
                .newInstance(mNavigationDrawerFragment);
        mFragmentTransaction.replace(Rconfig.getInstance().id("menu_top"),
                fragmentMenuTop);
    }


}
