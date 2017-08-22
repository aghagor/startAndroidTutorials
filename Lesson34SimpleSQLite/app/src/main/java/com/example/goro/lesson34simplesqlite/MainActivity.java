package com.example.goro.lesson34simplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String LOG_TAG = "myLogs";

    private Button btnAdd;
    private Button btnRead;
    private Button btnClear;
    private EditText etName;
    private EditText etEmail;

    private DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.et_name);
        etEmail = (EditText) findViewById(R.id.et_email);

        btnAdd = (Button) findViewById(R.id.btn_add);
        btnRead = (Button) findViewById(R.id.btn_read);
        btnClear = (Button) findViewById(R.id.btn_clear);

        btnAdd.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        helper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        ContentValues values = new ContentValues();
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();

        SQLiteDatabase db = helper.getWritableDatabase();

        switch (view.getId()) {
            case R.id.btn_add:
                Log.d(LOG_TAG, "--- Insert in mytable: ---");
                values.put("name", name);
                values.put("email", email);

                long rowID = db.insert("mytable", null, values);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
            case R.id.btn_read:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");
                Cursor c = db.query("mytable", null, null, null, null, null, null);
                if (c.moveToFirst()) {
                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int emailColIndex = c.getColumnIndex("email");

                    do {
                        Log.d(LOG_TAG, "ID = " + c.getInt(idColIndex) +
                                "name = " + c.getInt(nameColIndex) +
                                "email = " + c.getInt(emailColIndex));
                    } while (c.moveToNext());

                } else Log.d(LOG_TAG, "0 rows");
                c.close();
                break;
            case R.id.btn_clear:
                Log.d(LOG_TAG, "--- Clear mytable: ---");
                int clearCount = db.delete("mytable", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
        }
        helper.close();
    }

    class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            sqLiteDatabase.execSQL("create table mytable ( " +
                    "id integer primary key autoincrement, " +
                    "name text, " + "email text" + "):");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}
