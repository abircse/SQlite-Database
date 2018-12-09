package com.studioabir.sqlitepractice.sqlitepractice.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.studioabir.sqlitepractice.sqlitepractice.R;
import com.studioabir.sqlitepractice.sqlitepractice.modelforall.model;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<model> {


    private Context context;
    private ArrayList<model> person;

    public Adapter(Context context, ArrayList<model> person)  {
        super(context, R.layout.custom_layout_custom, person);
        this.context = context;
        this.person = person;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.custom_layout_custom,parent,false);
        TextView t1 = convertView.findViewById(R.id.mytextviews1);
        TextView t2 = convertView.findViewById(R.id.mytextviews2);

        t1.setText(person.get(position).getName());
        t2.setText(person.get(position).getAge());

        return convertView;
    }
}
