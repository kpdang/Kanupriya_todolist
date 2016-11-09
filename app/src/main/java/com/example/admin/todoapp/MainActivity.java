package com.example.admin.todoapp;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText titleEditTxt;
    EditText descEditTxt;
    Button sb;
    RecyclerView rv;
    RecyclerAdapter ra;
    Operation opr;
    FloatingActionButton b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        b = (FloatingActionButton)findViewById(R.id.fab1);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        opr = new Operation(ItemCollection.getItems());
        ra = new RecyclerAdapter(this, opr.getItems());
        if(b!=null)
        {
            System.out.println("helloooooooo b is not null");
        }
        else {
            System.out.println("helloooooooo b is  null");
        }

        assert b != null;}

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_additem,menu);
        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.action_addnote)
        {
           viewDialog();
        }
        return true;
    }

    public void add(View view)
    {
        viewDialog();
    }
        //b.setOnClickListener(v -> viewDialog());
    //}
    public  void viewDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Add New Item");
        d.setContentView(R.layout.dialog);
        titleEditTxt= (EditText) d.findViewById(R.id.titleEditTxt);
        descEditTxt= (EditText) d.findViewById(R.id.descEditTxt);
        sb=(Button) d.findViewById(R.id.button1);
        if(sb!=null)
        {
            System.out.println("helloooooooo sb is not null");
        }
        else
        {
            System.out.println("helloooooooo sb is  null");
        }




            sb.setOnClickListener(v -> {
            Item item = new Item();
            item.setTitle(titleEditTxt.getText().toString());
            item.setDescription(descEditTxt.getText().toString());
            if (opr.addItem(item)) {
                titleEditTxt.setText("");
                descEditTxt.setText("");
                rv.setAdapter(ra);
            }
        });
        d.show();
        }


}
