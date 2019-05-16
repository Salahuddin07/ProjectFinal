package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class About extends AppCompatActivity{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //find and supportAction Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //END

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        textView = (TextView) findViewById(R.id.textViewId1);
        textView.setText(R.string.about_text);
    }
    ////set onclicklistener into backbutton

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {



            SessionManager sessionManager = new SessionManager(About.this);


            Intent intent = new Intent(About.this, MainActivity2.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
    }
}
