package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    SharedPreferences login;
    SharedPreferences.Editor editor;
    Intent i;

    boolean logged_in = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView welcome = (TextView) findViewById(R.id.textView);

        login = getSharedPreferences("login", Context.MODE_PRIVATE);
//        final SharedPreferences.Editor editor = login.edit();

        String username = login.getString("username", null);

        if (username == null) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
            finish();
        } else {
            logged_in = true;
            welcome.setText("Welcome " + username);
        }

        displayHomeFragment();
    }

    public void displayHomeFragment(){
        Fragment frag = new TopHeadlinesFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment,frag).commit();
    }

    public void changeFrag(View v){
        Log.d("ChangeFRag","Clicked");
        Fragment f = null;
        if (v==findViewById(R.id.top_headlines)){
            Log.d("ChangeFRag","Top Head");
            f= new TopHeadlinesFragment();

        }
        if (v==findViewById(R.id.business)){
            Log.d("ChangeFRag","Business");
            f= new BusinessFragment();

        }
        if (v==findViewById(R.id.entertainment)){
            f= new EntertainmentFragment();

        }
        if (v==findViewById(R.id.science)){
            f= new ScienceFragment();

        }
        if (v==findViewById(R.id.health)){
            f= new HealthFragment();

        }
        if (v==findViewById(R.id.sports)){
            f= new SportsFragment();

        }
        if (v==findViewById(R.id.technology)){
            f= new TechnologyFragment();

        }
        if (f!=null){
            FragmentManager fm= getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment,f);
            ft.commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        login = getSharedPreferences("login",Context.MODE_PRIVATE);
        menu.findItem(R.id.login_or_signup).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        login = getSharedPreferences("login", Context.MODE_PRIVATE);
        editor = login.edit();
        switch (item.getItemId()) {
            case R.id.exit:
                Toast.makeText(getApplicationContext(), "See you soon!", Toast.LENGTH_LONG).show();
                finish();
                return true;
            case R.id.about_us:

                return true;
            case R.id.logout:
                editor.clear();
                editor.apply();
                i = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
                finish();
                return true;
//                this.recreate();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

