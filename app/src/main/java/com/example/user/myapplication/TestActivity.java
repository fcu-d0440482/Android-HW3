package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class TestActivity extends AppCompatActivity {

    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button backbtn = (Button)findViewById(R.id.btn_back);
        backbtn.setOnClickListener(back);
        result = (TextView)findViewById(R.id.et_hello);

        Intent intent = getIntent();
        /*
                 String name = intent.getStringExtra(
                MainActivity.KEY_NAME);

                 result.setText("HELLO "+name);
                */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private OnClickListener back = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String input_str = result.getText().toString();
            Intent intent = new Intent();
            intent.putExtra("KEY_NAME", input_str);
            setResult(RESULT_OK, intent);
            finish();
        }
    };


}
