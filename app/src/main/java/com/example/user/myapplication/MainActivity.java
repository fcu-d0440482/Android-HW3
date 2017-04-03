package com.example.user.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {


   // public static final String KEY_NAME = "KEY_NAME";
    Button submit;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        submit = (Button) findViewById(R.id.btn_sh);
        submit.setOnClickListener(calcResult);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private static final int ACTIVITY_SET_TEST = 1;

    private OnClickListener calcResult = new OnClickListener() {

        @Override
        public void onClick(View v) {

            //String input_str = input.getText().toString();

            Intent intent = new Intent();
            intent.setClass(MainActivity.this,
                    TestActivity.class);
            startActivityForResult(intent,ACTIVITY_SET_TEST);
        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

        String name;
        if( intent == null ){
            return;
        }

        super.onActivityResult(requestCode,  resultCode, intent);

        if( requestCode == ACTIVITY_SET_TEST ){
            name = intent.getStringExtra("KEY_NAME");
            Toast.makeText(MainActivity.this,
                    name,
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        if (id == R.id.action_web) {
            Uri uri = Uri.parse("https://www.google.com.tw");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(uri);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

}

