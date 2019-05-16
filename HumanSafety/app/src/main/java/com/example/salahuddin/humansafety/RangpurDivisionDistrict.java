package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class RangpurDivisionDistrict extends AppCompatActivity implements View.OnClickListener {

    private Button thakurgaon,rangpur,panchagarh,nilphamari,lalmonirhat,kurigram,gaibandha,dinajpur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangpur_division_district);


        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        thakurgaon = (Button) findViewById(R.id.thakurgaonDistrictId);
        rangpur = (Button) findViewById(R.id.rangpurDistrictId);
        panchagarh = (Button) findViewById(R.id.panchagarhDistrictId);
        nilphamari = (Button) findViewById(R.id.nilphamariDistrictId);
        lalmonirhat = (Button) findViewById(R.id.lalmonirhatDistrictId);
        kurigram = (Button) findViewById(R.id.kurigramDistrictId);
        gaibandha = (Button) findViewById(R.id.gaibandhaDistrictId);
        dinajpur = (Button) findViewById(R.id.dinajpurDistrictId);

        thakurgaon.setOnClickListener(this);
        rangpur.setOnClickListener(this);
        panchagarh.setOnClickListener(this);
        nilphamari.setOnClickListener(this);
        lalmonirhat.setOnClickListener(this);
        kurigram.setOnClickListener(this);
        gaibandha.setOnClickListener(this);
        dinajpur.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(RangpurDivisionDistrict.this, DivisionName.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.thakurgaonDistrictId){

            Intent i = new Intent(RangpurDivisionDistrict.this,RangpurAllThanaContact.class);
            i.putExtra("rangpur","Thakurgaon");
            startActivity(i);

        }else if (v.getId() == R.id.rangpurDistrictId){

            Intent i = new Intent(RangpurDivisionDistrict.this,RangpurAllThanaContact.class);
            i.putExtra("rangpur","Rangpur");
            startActivity(i);

        }else if (v.getId() == R.id.panchagarhDistrictId){

            Intent i = new Intent(RangpurDivisionDistrict.this,RangpurAllThanaContact.class);
            i.putExtra("rangpur","Panchagarh");
            startActivity(i);

        }else if (v.getId() == R.id.nilphamariDistrictId){

            Intent i = new Intent(RangpurDivisionDistrict.this,RangpurAllThanaContact.class);
            i.putExtra("rangpur","Nilphamari");
            startActivity(i);

        }else if (v.getId() == R.id.lalmonirhatDistrictId){

            Intent i = new Intent(RangpurDivisionDistrict.this,RangpurAllThanaContact.class);
            i.putExtra("rangpur","Lalmonirhat");
            startActivity(i);

        }else if (v.getId() == R.id.kurigramDistrictId){

            Intent i = new Intent(RangpurDivisionDistrict.this,RangpurAllThanaContact.class);
            i.putExtra("rangpur","Kurigram");
            startActivity(i);

        }else if (v.getId() == R.id.gaibandhaDistrictId){

            Intent i = new Intent(RangpurDivisionDistrict.this,RangpurAllThanaContact.class);
            i.putExtra("rangpur","Gaibandha");
            startActivity(i);

        }else if (v.getId() == R.id.dinajpurDistrictId){

            Intent i = new Intent(RangpurDivisionDistrict.this,RangpurAllThanaContact.class);
            i.putExtra("rangpur","Dinajpur");
            startActivity(i);

        }else{
            ///do nothing
        }
    }
}
