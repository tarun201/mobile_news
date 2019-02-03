package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    String[] headlines={"Headline 1","Headline 2", "Headline 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ListView lv = (ListView)findViewById(R.id.lv);
        final ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,headlines);
        final TextView t = (TextView)findViewById(R.id.textView);
        lv.setAdapter(aa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String res = aa.getItem(position);
                t.setText(res);
                Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1",Toast.LENGTH_SHORT);
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2",Toast.LENGTH_SHORT);
                return true;
                default:
                return super.onOptionsItemSelected(menuItem);
        }
    }
    public void logout(View view){
        finish();
    }
}
