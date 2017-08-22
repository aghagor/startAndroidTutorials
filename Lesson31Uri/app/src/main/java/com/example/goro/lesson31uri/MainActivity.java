package com.example.goro.lesson31uri;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnWeb;
    private Button btnMap;
    private Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWeb = (Button) findViewById(R.id.btn_web);
        btnMap = (Button) findViewById(R.id.btn_Map);
        btnCall = (Button) findViewById(R.id.btn_Call);

        btnWeb.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_web:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
                startActivity(intent);
                break;
            case R.id.btn_Map:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:40.822292, 44.476280"));
                startActivity(intent);
                break;
            case R.id.btn_Call:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+37455446643"));
                startActivity(intent);
                break;
        }
    }
}
