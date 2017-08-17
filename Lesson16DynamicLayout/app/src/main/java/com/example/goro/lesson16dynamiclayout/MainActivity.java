package com.example.goro.lesson16dynamiclayout;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams linLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        TextView tv = new TextView(this);
        tv.setText("TextView");
        tv.setLayoutParams(linLayoutParams);
        linearLayout.addView(tv);

        Button btn = new Button(this);
        btn.setText("Button");
        linearLayout.addView(btn,linLayoutParams);

        setContentView(linearLayout,linLayoutParams);
    }
}
