package com.studioabir.sqlitepractice.sqlitepractice;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.studioabir.sqlitepractice.sqlitepractice.customlistview.CustomListActivity;
import com.studioabir.sqlitepractice.sqlitepractice.databasehelper.mydatabasehelper;
import com.studioabir.sqlitepractice.sqlitepractice.normallistview.ListActivity;
import com.studioabir.sqlitepractice.sqlitepractice.recyclerview.EmployeeActivity;

public class MainActivity extends AppCompatActivity {


    mydatabasehelper mydbhelper;
    private EditText NAME,AGE,ID;
    private Button SAVE,SHOWDATA, UPDATEDATE, DELETEDATA, LISTVIEWSHOW, CUSTOMLISTDATA, RECYCLEDATA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydbhelper = new mydatabasehelper(this);
        SQLiteDatabase sqLiteDatabase = mydbhelper.getWritableDatabase();

        SAVE = findViewById(R.id.save);
        SHOWDATA = findViewById(R.id.display);
        UPDATEDATE = findViewById(R.id.updatedata);
        DELETEDATA = findViewById(R.id.deletedata);
        LISTVIEWSHOW = findViewById(R.id.listdata);
        CUSTOMLISTDATA = findViewById(R.id.clistdata);
        RECYCLEDATA = findViewById(R.id.rlistdata);



        NAME = findViewById(R.id.name);
        AGE = findViewById(R.id.age);
        ID = findViewById(R.id.id);

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

        SHOWDATA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = mydbhelper.displayAllData();

                if (cursor.getCount() == 0)
                {
                     showdata("Error","There is no data");

                }
                else
                {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (cursor.moveToNext())
                    {
                        stringBuffer.append("ID:  "+cursor.getString(0)+"\n");
                        stringBuffer.append("NAME:  "+cursor.getString(1)+"\n");
                        stringBuffer.append("AGE:  "+cursor.getString(2)+"\n");
                    }

                    showdata("Result Set",stringBuffer.toString());
                }

            }
        });


        UPDATEDATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = NAME.getText().toString();
                String age = AGE.getText().toString();
                String id = ID.getText().toString();
                Boolean isUpdated = mydbhelper.UpdateData(id,name,age);
                if (isUpdated == true)
                {
                    showdata("UPDATE ALART", "DATA UPDATED SUCCEFULLY");
                }
                else
                {
                    showdata("UPDATE ALART", "DATA NOT UPDATED SUCCEFULLY");

                }



            }
        });


        DELETEDATA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = ID.getText().toString();
                int result = mydbhelper.deleteData(id);

                if (result > 0)
                {
                    showdata("UPDATE ALART", "DATA SUCCEFULLY DELETED");
                }

                else
                {
                    showdata("UPDATE ALART", "DATA DELETED FAILED");
                }


            }
        });


        LISTVIEWSHOW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,ListActivity.class));

            }
        });

        CUSTOMLISTDATA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,CustomListActivity.class));

            }
        });


        RECYCLEDATA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,EmployeeActivity.class));

            }
        });





    }

    private void showdata(String Title, String data) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();

    }
}
