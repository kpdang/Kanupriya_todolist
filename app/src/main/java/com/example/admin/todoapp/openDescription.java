package com.example.admin.todoapp;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class openDescription extends AppCompatActivity {
    String title, desc;
    int position;
    TextView titleTxt, descTxt;
    EditText titleEditTxt;
    EditText descEditTxt;
    Button sb;
    RecyclerView rv;
    RecyclerAdapter ra;
    Operation opr;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    //FloatingActionButton b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_detail);
        setContentView(R.layout.activity_open_description);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(myToolbar);
        //  b1=(FloatingActionButton)findViewById(R.id.fab2);
        opr = new Operation(ItemCollection.getItems());
        //titleTxt=(TextView)findViewById(R.id.titleTxt);
        titleTxt = (TextView) findViewById(R.id.title1);
        descTxt = (TextView) findViewById(R.id.desc1);
        Intent intent = this.getIntent();
        title = intent.getExtras().getString("Title_todolist");
        desc = intent.getExtras().getString("Desc_todolist");
        position = intent.getExtras().getInt("Position_todolist");
        System.out.println("111111111111");
        titleTxt.setText(title);
        System.out.println("22222222222");
        descTxt.setText(desc);
        System.out.println("33333333333");
       ActionBar bar=getSupportActionBar();
        //bar.setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    

    /**
     * if(b1!=null)
     * {
     * System.out.print("Hiiiii b1 is not null");
     * }
     * else
     * {
     * System.out.print("Hiiiii b1 is  null");
     * }
     * <p>
     * assert b1 != null;
     * b1.setOnClickListener((view) -> {
     * Snackbar.make(view,"Replace with your own action",Snackbar.LENGTH_SHORT).setAction("Action",new View.OnClickListener(){
     *
     * @Override public void onClick(View v) {
     * <p>
     * }
     * <p>
     * <p>
     * <p>
     * }).show();
     * });
     * }
     **/
    public void viewDialog() {
        Dialog d = new Dialog(this);
        d.setTitle("Add New Item");
        d.setContentView(R.layout.dialog);
        titleEditTxt = (EditText) d.findViewById(R.id.titleEditTxt);
        descEditTxt = (EditText) d.findViewById(R.id.descEditTxt);
        sb = (Button) d.findViewById(R.id.button1);
        titleEditTxt.setText(title);
        descEditTxt.setText(desc);
        if (sb != null) {
            System.out.print("Hiiiii sb is not null");
        } else {
            System.out.print("Hiiiii sb is  null");
        }
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item();
                title = titleEditTxt.getText().toString();
                desc = descEditTxt.getText().toString();
                item.setTitle(title);
                item.setDescription(desc);
                if (opr.update(position, item)) {
                    titleEditTxt.setText(title);
                    descEditTxt.setText(desc);
                    titleTxt.setText(title);
                    descTxt.setText(desc);
                    rv.setAdapter(ra);
                }
            }
        });
        d.show();

    }

   /** @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "openDescription Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.admin.todoapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "openDescription Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.admin.todoapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }*/
}
