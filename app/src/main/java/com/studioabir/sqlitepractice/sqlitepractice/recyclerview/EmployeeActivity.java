package com.studioabir.sqlitepractice.sqlitepractice.recyclerview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.studioabir.sqlitepractice.sqlitepractice.R;
import com.studioabir.sqlitepractice.sqlitepractice.databasehelper.mydatabasehelper;
import com.studioabir.sqlitepractice.sqlitepractice.modelforall.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<model> employeesalllist;
    EmployeeAdapter aadapter;
    mydatabasehelper mydatabasehelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        recyclerView = findViewById(R.id.myrecylerview);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        mydatabasehelper = new mydatabasehelper(this);

        recyclecall();

    }

    private void recyclecall() {

        employeesalllist = new ArrayList<>();
        final Cursor cursor = mydatabasehelper.displayAllData();
        if (cursor.getCount() == 0)
        {
            /// no data found
        }
        else
        {
            while (cursor.moveToNext())
            {
                employeesalllist.add(new model(

                        // here column index 1 meance two column & 2 meance three column
                        cursor.getString(1),
                        cursor.getString(2)

                ));

            }
        }

        aadapter = new EmployeeAdapter(employeesalllist,EmployeeActivity.this);
        recyclerView.setAdapter(aadapter);


    }
}
