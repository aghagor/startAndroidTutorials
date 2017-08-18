package com.example.goro.lesson30activityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

public class AlignActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLeft;
    private Button btnCenter;
    private Button btnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        btnLeft = (Button) findViewById(R.id.btn_left);
        btnCenter = (Button) findViewById(R.id.btn_center);
        btnRight = (Button) findViewById(R.id.btn_right);

        btnLeft.setOnClickListener(this);
        btnCenter.setOnClickListener(this);
        btnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_left:
                intent.putExtra("alignment", Gravity.LEFT);
                break;
            case R.id.btn_center:
                intent.putExtra("alignment", Gravity.CENTER);
                break;
            case R.id.btn_right:
                intent.putExtra("alignment", Gravity.RIGHT);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
