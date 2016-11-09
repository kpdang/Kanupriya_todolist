package com.example.admin.todoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


/**
 * Created by admin on 11/5/2016.
 */
public class HolderClass extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView titleTxt,descTxt;
    ItemClickInterface ici;


    public HolderClass(View itemView) {
        super(itemView);
        titleTxt=(TextView)itemView.findViewById(R.id.titleTxt);
        descTxt=(TextView)itemView.findViewById(R.id.dsceTxt);
        itemView.setOnClickListener(this);
    }

    public void setItemClickInterface(ItemClickInterface ici)
    {
        this.ici=ici;
    }

    @Override
    public void onClick(View v) {
        this.ici.onItemClick(getLayoutPosition());
    }
}
