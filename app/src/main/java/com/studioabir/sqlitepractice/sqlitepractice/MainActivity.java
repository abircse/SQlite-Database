package com.studioabir.sqlitepractice.sqlitepractice;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.studioabir.sqlitepractice.sqlitepractice.databasehelper.mydatabasehelper;

public class MainActivity extends AppCompatActivity {


    mydatabasehelper mydbhelper;
    private EditText NAME,AGE;
    private Button SAVE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydbhelper = new mydatabasehelper(this);
        SQLiteDatabase sqLiteDatabase = mydbhelper.getWritableDatabase();

        SAVE = findViewById(R.id.save);
        NAME = findViewById(R.id.name);
        AGE = findViewById(R.id.age);

        SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = NAME.getText().toString();
                String age = AGE.getText().toString();
                long rowid = mydbhelper.insertdata(name,age);

                if (rowid == -1)
                {
                    Toast.makeText(getApplicationContext(),"ROW INSERTED UNSUCCEFULLY",Toast.LENGTH_LONG).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"ROW THAT IS "+rowid +" INSERTED SUCCEFULLY",Toast.LENGTH_LONG).show();

                }


            }
        });




    }
}
