package com.m00061016.gamenews.Activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.m00061016.gamenews.Fragments.Favorites_Fragment;
import com.m00061016.gamenews.Fragments.Game_Info_Fragment;
import com.m00061016.gamenews.Fragments.News_Fragments;
import com.m00061016.gamenews.Fragments.Settgins_Fragment;
import com.m00061016.gamenews.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static boolean flagoverwatch=false, flaglol=false,flagcsgo = false;
    private Fragment actual_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.news_nav);
        changeFragment(new News_Fragments());
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
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragmentNews = new Fragment();
        if (id == R.id.news_nav) {
            changeFragment(new News_Fragments());

        } else if (id == R.id.league_of_legends) {
            changeFragment(new Game_Info_Fragment());
            flaglol=true;
            flagcsgo=false;
            flagoverwatch=false;
        } else if (id == R.id.counter_strike) {
            changeFragment(new Game_Info_Fragment());
            flaglol=false;
            flagcsgo=true;
            flagoverwatch=false;
        } else if (id == R.id.overwatch) {
            changeFragment(new Game_Info_Fragment());
            flaglol=false;
            flagcsgo=false;
            flagoverwatch=true;

        } else if (id == R.id.favorites_nav) {
            changeFragment(new Favorites_Fragment());

        } else if (id == R.id.nav_settings) {
            changeFragment(new Settgins_Fragment());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void changeFragment(Fragment fragment){
        if(actual_fragment == null || !fragment.getClass().getName().equals(actual_fragment.getClass().getName())){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_fr,fragment).commit();
            actual_fragment= fragment;
        }else if(fragment.getClass().getName().equals(actual_fragment.getClass().getName())){
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_fr,fragment).commit();
            actual_fragment= fragment;
        }

    }

}
