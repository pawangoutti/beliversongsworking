package com.pawan.beliverssongs;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myviewholder>
{
    ArrayList<Model> datalist;
    public MyAdapter(ArrayList<Model> datalist) {
        this.datalist = datalist;
    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

        holder.t1.setText(datalist.get(position).getTitle());
        holder.ppp.setText(""+(String.valueOf(position+1))+".");



        holder.t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.t1.getContext(), Details.class);
                intent.putExtra("utitle",datalist.get(position).getTitle());
                intent.putExtra("usong",datalist.get(position).getSong());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.t1.getContext().startActivity(intent);
              //  Log.d("pvn","position="+position);

            }
        });


    }

    @Override
    public int getItemCount() {
        return datalist.size();    }

    class Myviewholder extends RecyclerView.ViewHolder
    {
        TextView t1,ppp;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.t1);
            ppp=itemView.findViewById(R.id.poz);
        }
    }
}
