package com.example.goro.lesson26intentfilter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnTime;
    private Button btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDate = (Button) findViewById(R.id.btn_show_date);
        btnTime = (Button) findViewById(R.id.btn_show_time);

        btnDate.setOnClickListener(this);
        btnDate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_show_time:
                intent = new Intent("com.example.goro.lesson26intentfilter.intent.showtime");
                startActivity(intent);
                break;
            case R.id.btn_show_date:
                intent = new Intent("com.example.goro.lesson26intentfilter.action.showdate");
                startActivity(intent);

        }
    }
}
