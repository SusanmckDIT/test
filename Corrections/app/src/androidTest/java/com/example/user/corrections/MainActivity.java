package com.example.user.corrections;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createList(View v){
        Intent intnt = new Intent(MainActivity.this, CreateListActivity.class);;
        startActivity(intnt);
    }

    public void viewLists(View v){
        Intent intnt = new Intent(MainActivity.this, EditListsActivity.class);
        startActivity(intnt);
    }

}
