package com.example.girish.shopy;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.girish.shopy.fragment.ClothFragment;
import com.example.girish.shopy.fragment.ElectronicFragment;
import com.example.girish.shopy.fragment.OthersFragment;
import com.example.girish.shopy.models.User;

public class ProductActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        User user = SharedPrefManger.getInstance(this).getUser();

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigation);
        navigationView.setOnNavigationItemSelectedListener(this);

        displayFragment(new ClothFragment());
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.home_nav:
                fragment= new ClothFragment();
                break;
            case R.id.user_nav:
                fragment= new ElectronicFragment();
                break;
            case R.id.setting_nav:
                fragment= new OthersFragment();
                break;
        }
        if (fragment!= null){
            displayFragment(fragment);
        }
        return false;
    }

    private void displayFragment(Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction().replace(R.id.main_container,fragment)
                .commit();
    }
}
