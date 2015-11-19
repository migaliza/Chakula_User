package com.example.migaliza.chakula_user;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public String username;
    public String passord;
    public int user_id;
    //private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    //private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView username_area = (TextView)findViewById(R.id.username_area);

        Intent intent = getIntent();
        if(intent.hasExtra("username") && intent.hasExtra("passwird") && intent.hasExtra("user_id")){
            this.username = intent.getExtras().getString("username");
            this.passord = intent.getExtras().getString("password");
            this.user_id = Integer.parseInt(intent.getExtras().getString("user_id"));
            username_area.setText(this.username);
        }
    }

    /**
     * Takes user to previous screen
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    /**
     *
     * @param meal
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem meal) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = meal.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(meal);
    }

    /**
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment myfrag = null;
        int id = item.getItemId();

        if (id == R.id.view_menu) {
            // Handle the camera action
            myfrag = new MenuFragment();
            getSupportActionBar().setTitle("Menu");
        } else if (id == R.id.current_orders) {
            getSupportActionBar().setTitle("Current Orders");
        } else if (id == R.id.order_history) {
            myfrag = new orderHistoryFragment();
            getSupportActionBar().setTitle("Order History");
        } else if (id == R.id.sign_out) {
            Intent intent = getIntent();
            intent.removeExtra("name");
            intent.removeExtra("password");
            intent = new Intent(this, FullscreenActivity.class);
            startActivity(intent);
            return false;
        }

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, myfrag).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
