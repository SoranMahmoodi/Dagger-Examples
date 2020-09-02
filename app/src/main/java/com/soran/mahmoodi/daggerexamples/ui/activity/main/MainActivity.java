package com.soran.mahmoodi.daggerexamples.ui.activity.main;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.soran.mahmoodi.daggerexamples.R;
import com.soran.mahmoodi.daggerexamples.ui.base.BaseActivity;
import com.soran.mahmoodi.daggerexamples.ui.fargment.post.PostsFragment;
import com.soran.mahmoodi.daggerexamples.ui.fargment.profile.ProfileFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testFragment();
    }

    private void testFragment(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PostsFragment()).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      switch (item.getItemId()){
          case R.id.item_logout:
              sessionManger.logout();
              break;
      }
        return super.onOptionsItemSelected(item);
    }
}