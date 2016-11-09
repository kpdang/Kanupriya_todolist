package com.example.admin.todoapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by admin on 11/6/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<HolderClass> {
    Context ctx;

    public RecyclerAdapter(Context ctx, ArrayList<Item> items) {
        this.ctx = ctx;
        this.items = items;
    }

    ArrayList<Item> items;

    @Override
    public HolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        HolderClass hc = new HolderClass(view);
        return hc;
    }

    @Override
    public void onBindViewHolder(HolderClass holder, int position) {
       final  String title=items.get(position).getTitle();
        final  String desc=items.get(position).getDescription();
        holder.titleTxt.setText(title);
       holder.descTxt.setText(" ");
        holder.setItemClickInterface(new ItemClickInterface() {
            @Override
            public void onItemClick(int pos) {
             openDescription(title,desc,pos);
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    private void openDescription(String titile,String description,int pos)
    {
        Intent intent=new Intent(ctx,openDescription.class);
        intent.putExtra("Title_todolist",titile);
        intent.putExtra("Desc_todolist",description);
        intent.putExtra("Position_todolist",pos);
        ctx.startActivity(intent);

    }
}
