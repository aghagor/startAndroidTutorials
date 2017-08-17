package com.example.goro.lesson19simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public final int MENU_RESET_ID = 1;
    public final int MENU_QUIT_ID = 2;

    private EditText etNum1;
    private EditText etNum2;

    private Button btnAdd;
    private Button btnSub;
    private Button btnMult;
    private Button btnDiv;

    private TextView tvResult;

    private String oper = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        tvResult = (TextView) findViewById(R.id.tv_Result);

    }

    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        String result = " ";

        if (TextUtils.isEmpty(etNum1.getText().toString()
        ) || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());


        switch (view.getId()) {
            case R.id.btnAdd:
                oper = "+";
                result = String.valueOf(num1 + num2);
                break;
            case R.id.btnSub:
                oper = "-";
                result = String.valueOf(num1 - num2);
                break;
            case R.id.btnMult:
                oper = "*";
                result = String.valueOf(num1 * num2);
                break;
            case R.id.btnDiv:
                oper = "/";
                if (num2 != 0) {
                    result = String.valueOf(num1 / num2);
                } else Toast.makeText(this, "Can't divide to 0", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_RESET_ID, 0, "Reset");
        menu.add(0, MENU_QUIT_ID, 0, "Quit");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_RESET_ID:
                etNum1.setText(" ");
                etNum2.setText(" ");
                tvResult.setText(" ");
                break;
            case MENU_QUIT_ID:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
