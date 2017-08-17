package com.example.goro.lesson28intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etFirstName;
    private EditText etLastName;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = (EditText) findViewById(R.id.et_table_row_1);
        etLastName = (EditText) findViewById(R.id.et_table_row_2);
        btnSubmit = (Button) findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("fname", etFirstName.getText().toString());
        intent.putExtra("lname", etLastName.getText().toString());
        startActivity(intent);
    }
}
