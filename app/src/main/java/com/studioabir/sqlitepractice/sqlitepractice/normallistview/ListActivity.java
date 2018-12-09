package com.studioabir.sqlitepractice.sqlitepractice.normallistview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.studioabir.sqlitepractice.sqlitepractice.R;
import com.studioabir.sqlitepractice.sqlitepractice.databasehelper.mydatabasehelper;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView lv;
    mydatabasehelper mydatabasehelper;
    ArrayList<String> listdata;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv = findViewById(R.id.listview);
        mydatabasehelper = new mydatabasehelper(this);
        showdatainlist();

    }

    //  normal list view methord
    private void showdatainlist() {

        listdata = new ArrayList<>();
        Cursor cursor = mydatabasehelper.displayAllData();
        if (cursor.getCount() == 0)
        {
            /// no data found
        }
        else
        {
            while (cursor.moveToNext())
            {
                listdata.add(cursor.getString(1)+"\n"+cursor.getString(2));

            }
        }

        adapter = new ArrayAdapter<String>(this,R.layout.custom_layout,R.id.mytextviews,listdata);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedvalue = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"You Clicked on: "+selectedvalue, Toast.LENGTH_LONG).show();

            }
        });

    }


}
