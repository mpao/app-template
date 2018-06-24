package io.github.mpao.template;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import io.github.mpao.template.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme); // splash_screen
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbarLayout.toolbar);

        // drawer stuff
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                binding.drawer,
                binding.toolbarLayout.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        binding.drawer.addDrawerListener(toggle);
        toggle.syncState();
        binding.navView.setNavigationItemSelectedListener(this);

        // bottom navigation menu
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) binding.navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());
        binding.navigation.setOnNavigationItemSelectedListener( item ->{
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        });

    }

    @Override
    public void onBackPressed() {
        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_camera: break;
            case R.id.nav_slideshow: break;
            case R.id.nav_manage: break;
            case R.id.nav_share: break;
            case R.id.nav_send: break;
            case R.id.nav_gallery: break;
        }

        binding.drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
