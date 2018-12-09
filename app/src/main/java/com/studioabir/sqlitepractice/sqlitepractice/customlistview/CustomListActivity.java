package com.studioabir.sqlitepractice.sqlitepractice.customlistview;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.studioabir.sqlitepractice.sqlitepractice.R;
import com.studioabir.sqlitepractice.sqlitepractice.databasehelper.mydatabasehelper;
import com.studioabir.sqlitepractice.sqlitepractice.modelforall.model;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {

    ListView lv;
    mydatabasehelper mydatabasehelper;
    Adapter myadapter;
    ArrayList<model> listdata1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        lv = findViewById(R.id.listview);
        mydatabasehelper = new mydatabasehelper(this);
        customlistcall();
    }

    // custom list view method
    private void customlistcall() {

        listdata1 = new ArrayList<>();
        final Cursor cursor = mydatabasehelper.displayAllData();
        if (cursor.getCount() == 0)
        {
            /// no data found
        }
        else
        {
            while (cursor.moveToNext())
            {
                listdata1.add(new model(

                        cursor.getString(1),
                        cursor.getString(2)

                ));

            }
        }

        myadapter = new Adapter(this,listdata1);
        lv.setAdapter(myadapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(),"You Clicked on: "+position, Toast.LENGTH_LONG).show();

            }
        });



    }
}
