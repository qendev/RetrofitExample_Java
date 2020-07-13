package com.example.retrofitexample_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TheAdapter extends RecyclerView.Adapter<TheAdapter.MyViewHolder> {

    private List<MyUsers>  dataList;

    public TheAdapter(List<MyUsers> dataList) {
        this.dataList = dataList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //Get a reference to the Views in the layout that respresents one row in the recyclerview
        public final View view;

        TextView NtextView,UtextView,EtextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view= itemView;

            NtextView = itemView.findViewById(R.id.textView_name);
            UtextView = itemView.findViewById(R.id.textView_username);
            EtextView = itemView.findViewById(R.id.textView_email);
        }
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.my_row_layout,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder. NtextView.setText(dataList.get(position).getThe_name());
        holder.UtextView.setText(dataList.get(position).getThe_username());
        holder.EtextView.setText(dataList.get(position).getThe_email());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


}
