package com.example.news;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences login;
    SharedPreferences.Editor editor;
    Intent i;

//    boolean logged_in= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setTitle("Testing");

//        Button b = (Button)findViewById(R.id.button);
//        Button b2 = (Button)findViewById(R.id.button2);

        TextView welcome = (TextView)findViewById(R.id.textView3);

        login = getSharedPreferences("login", Context.MODE_PRIVATE);
//        final SharedPreferences.Editor editor = login.edit();

        String username = login.getString("username",null);


        if(username == null){
            welcome.setText("Welcome Guest!");
        }else{
//            logged_in=true;
            Intent i = new Intent(getApplicationContext(),MainActivity2.class);
            startActivity(i);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
//        login = getSharedPreferences("login",Context.MODE_PRIVATE);
//        if(logged_in == false){
//            menu.findItem(R.id.logout).setVisible(false);
//        }else{
//            menu.findItem(R.id.login_or_signup).setVisible(false);
//        }

        menu.findItem(R.id.logout).setVisible(false);
//        menu.findItem(R.id.login_or_signup).setVisible(false);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        login = getSharedPreferences("login", Context.MODE_PRIVATE);
        editor=login.edit();
        switch (item.getItemId()){
            case R.id.exit:
                Toast.makeText(getApplicationContext(),"See you soon!",Toast.LENGTH_LONG).show();
                finish();
                return true;
            case R.id.about_us:

                return true;
            case R.id.contact:

                return true;
            case R.id.login_or_signup:
                i = new Intent(getBaseContext(),com.example.news.login.class);
                startActivity(i);
                finish();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    public void to_login(View v) {
        Intent i = new Intent(getBaseContext(), login.class);
        startActivity(i);
        finish();
    }
}
