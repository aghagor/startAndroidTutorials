package com.example.goro.lesson13menu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
      /*  if (id == R.id.action_settings) {
            Toast.makeText(this, getString(R.string.action_settings), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_item1) {
            Toast.makeText(this, getString(R.string.action_item1), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_item2) {
            Toast.makeText(this, getString(R.string.action_item2), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_item3) {
            Toast.makeText(this, getString(R.string.action_item3), Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_item4) {
            Toast.makeText(this, getString(R.string.action_item4), Toast.LENGTH_SHORT).show();
        }
*/
// item selecting witch switch/case operator
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, getString(R.string.action_settings), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item1:
                Toast.makeText(this, getString(R.string.action_item1), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item2:
                Toast.makeText(this, getString(R.string.action_item2), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item3:
                Toast.makeText(this, getString(R.string.action_item3), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_item4:
                Toast.makeText(this, getString(R.string.action_item4), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
