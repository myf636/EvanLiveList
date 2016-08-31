package com.EvanMao.LiveList.MainActivity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.EvanMao.LiveList.fragment.InCome_Fragment;
import com.EvanMao.LiveList.fragment.MemberGroup_Fragment;
import com.EvanMao.LiveList.fragment.Pandect_Fragment;
import com.EvanMao.LiveList.fragment.TimeManager_Fragment;
import com.EvanMao.LiveList.R;
import com.EvanMao.Tool.UIFragmentControl;
import com.zhy.autolayout.AutoLayoutActivity;

public class MainActivity extends AutoLayoutActivity
        implements NavigationView.OnNavigationItemSelectedListener, IMainView, UIFragmentControl
        .IDoSomething {
    private FrameLayout fragmentContainer;
    private IMainViewPresenter mainViewPresenter;
    private Pandect_Fragment pandect_fragment;
    private InCome_Fragment inCome_fragment;
    private MemberGroup_Fragment memberGroup_fragment;
    private TimeManager_Fragment timeManager_fragment;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string
                .navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mainViewPresenter = new MainViewPresenter(this);
        mainViewPresenter.ShowMainView();
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
    protected void onResume() {
        super.onResume();
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

        if (id == R.id.nav_camera) {
            HideView();
            if (pandect_fragment == null)
                pandect_fragment = Pandect_Fragment.newInstance(null, null);
            Turn2NextView(pandect_fragment);
            toolbar.setTitle(getString(R.string.app_name));
        } else if (id == R.id.nav_gallery) {
            HideView();
            if (inCome_fragment == null)
                inCome_fragment = InCome_Fragment.newInstance(null, null);
            Turn2NextView(inCome_fragment);
            toolbar.setTitle(getString(R.string.left_income));
        } else if (id == R.id.nav_slideshow) {
            HideView();
            if (timeManager_fragment == null)
                timeManager_fragment = TimeManager_Fragment.newInstance(null, null);
            Turn2NextView(timeManager_fragment);
            toolbar.setTitle(getString(R.string.left_time));
        } else if (id == R.id.nav_manage) {
            HideView();
            if (memberGroup_fragment == null)
                memberGroup_fragment = MemberGroup_Fragment.newInstance(null, null);
            Turn2NextView(memberGroup_fragment);
            toolbar.setTitle(getString(R.string.left_member));
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setDefaultView() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (pandect_fragment == null) {
            pandect_fragment = Pandect_Fragment.newInstance(null, null);
        }
        transaction.add(R.id.fragment_container, pandect_fragment);
        pandect_fragment.setDoSomethingListener(this);
        transaction.commit();
    }

    /**
     * 隐藏当前页
     */

    private void HideView() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (pandect_fragment != null && pandect_fragment.isVisible())
            transaction.hide(pandect_fragment);
        else if (inCome_fragment != null && inCome_fragment.isVisible())
            transaction.hide(inCome_fragment);
        else if (timeManager_fragment != null && timeManager_fragment.isVisible())
            transaction.hide(timeManager_fragment);
        else if (memberGroup_fragment != null && memberGroup_fragment.isVisible())
            transaction.hide(memberGroup_fragment);
        transaction.commit();
    }

    private void Turn2NextView(UIFragmentControl view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (view.isAdded()) {
            transaction.show(view);
        } else {
            transaction.add(R.id.fragment_container, view);
        }
        view.setDoSomethingListener(this);
        transaction.commit();
    }


    @Override
    public void do1(UIFragmentControl view, Object pamW, Object pamL) {

    }

    @Override
    public void do2(UIFragmentControl view, Object pamW, Object pamL) {

    }

    @Override
    public void do3(UIFragmentControl view, Object pamW, Object pamL) {

    }

    @Override
    public void do4(UIFragmentControl view, Object[] params, Object pamL) {

    }

    @Override
    public void do5(UIFragmentControl view, int[] params) {

    }

    @Override
    public void do6(UIFragmentControl view, Object pamW, Object pamL) {

    }
}
