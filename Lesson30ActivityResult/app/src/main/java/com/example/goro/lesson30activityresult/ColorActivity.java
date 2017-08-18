package com.example.goro.lesson30activityresult;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnRed;
    private Button btnGreen;
    private Button btnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        btnRed = (Button) findViewById(R.id.btn_red);
        btnGreen = (Button) findViewById(R.id.btn_green);
        btnBlue = (Button) findViewById(R.id.btn_blue);

        btnRed.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_red:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.btn_green:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.btn_blue:
                intent.putExtra("color", Color.BLUE);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
