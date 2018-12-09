package com.studioabir.sqlitepractice.sqlitepractice.recyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.studioabir.sqlitepractice.sqlitepractice.R;
import com.studioabir.sqlitepractice.sqlitepractice.modelforall.model;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.Holder> {


    private List<model> employeeList;
    private Context context;

    public EmployeeAdapter(List<model> employeeList, Context context) {
        this.employeeList = employeeList;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout_custom, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, final int position) {



        holder.name.setText(employeeList.get(position).getName());
        holder.age.setText(employeeList.get(position).getAge());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // get positon hold data to represent
                String name = employeeList.get(position).getName();
                String age = employeeList.get(position).getAge();

                Toast.makeText(context, "CLICKED ON NAME: "+ name+ " AGE IS: " + age, Toast.LENGTH_SHORT).show();


            }

        });
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }



    class Holder extends RecyclerView.ViewHolder
    {

        TextView name;
        TextView age;


        Holder(View fview)
        {
            super(fview);
            name = fview.findViewById(R.id.mytextviews1);
            age = fview.findViewById(R.id.mytextviews2);


        }


    }
}