package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MymensinghDivisionDistrict extends AppCompatActivity implements View.OnClickListener {

    private Button jamalpur,mymensing,netrokona,sherpur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymensingh_division_district);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        jamalpur = (Button) findViewById(R.id.jamalpurDistrictId);
        mymensing = (Button) findViewById(R.id.mymensinghDistrictId);
        netrokona = (Button) findViewById(R.id.netrokonaDistrictId);
        sherpur = (Button) findViewById(R.id.sherpurDistrictId);

        jamalpur.setOnClickListener(this);
        mymensing.setOnClickListener(this);
        netrokona.setOnClickListener(this);
        sherpur.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }


    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(MymensinghDivisionDistrict.this, DivisionName.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.jamalpurDistrictId){

            Intent i = new Intent(MymensinghDivisionDistrict.this,MymensingAllThanaContact.class);
            i.putExtra("mymensing","Jamalpur");
            startActivity(i);

        }else if (v.getId() == R.id.mymensinghDistrictId){

            Intent i = new Intent(MymensinghDivisionDistrict.this,MymensingAllThanaContact.class);
            i.putExtra("mymensing","Mymensing");
            startActivity(i);

        }else if (v.getId() == R.id.netrokonaDistrictId){

            Intent i = new Intent(MymensinghDivisionDistrict.this,MymensingAllThanaContact.class);
            i.putExtra("mymensing","Netrokona");
            startActivity(i);

        }else if (v.getId() == R.id.sherpurDistrictId){

            Intent i = new Intent(MymensinghDivisionDistrict.this,MymensingAllThanaContact.class);
            i.putExtra("mymensing","Sherpur");
            startActivity(i);

        }else{
            ///do nothing
        }
    }
}
