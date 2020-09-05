package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
    LayoutInflater inflat;
    List<note> nt;
    public adapter( Context context ,List<note> nt) {
      this.inflat=LayoutInflater.from(context);
      this.nt=nt;

    }

    @NonNull
    @Override
    public adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflat.inflate(R.layout.imagn,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.viewholder holder, int i) {
        String tlt=nt.get(i).getTitle();
        String ddt=nt.get(i).getDate();
        holder.ntitl.setText(tlt);
        holder.ndate.setText(ddt);
        holder.iv.setImageResource(R.drawable.sticky_note_png18899);


    }



    @Override
    public int getItemCount() {
        return nt.size();
    }

    public class viewholder extends  RecyclerView.ViewHolder{
        TextView ntitl,ndate;
        ImageView iv;
        public viewholder(@NonNull View itemView) {

            super(itemView);
            ntitl=itemView.findViewById(R.id.ntitle);
            ndate=itemView.findViewById(R.id.dated);
            iv=itemView.findViewById(R.id.ivv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(v.getContext(),edittest.class);
                    i.putExtra("ID",nt.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
