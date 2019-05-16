package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ChittagongDivisionDistrict extends AppCompatActivity implements View.OnClickListener {

    private Button brahmanbaria,comilla,chandpur,lakshmipur,noakhali,feni,khagrachari,rangamati,bandarban,chittagong,coxBazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagong_division_district);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        brahmanbaria = (Button) findViewById(R.id.brahmanbariaDistrictId);
        comilla = (Button) findViewById(R.id.comillaDistrictId);
        chandpur = (Button) findViewById(R.id.chandpurDistrictId);
        lakshmipur = (Button) findViewById(R.id.lakshmipurDistrictId);
        noakhali = (Button) findViewById(R.id.noakhaliDistrictId);
        feni = (Button) findViewById(R.id.feniDistrictId);
        khagrachari = (Button) findViewById(R.id.khagrachhariDistrictId);
        rangamati = (Button) findViewById(R.id.rangamatiDistrictId);
        bandarban = (Button) findViewById(R.id.bandarbanDistrictId);
        chittagong = (Button) findViewById(R.id.chittagongDistrictId);
        coxBazar = (Button) findViewById(R.id.coxBazarDistrictId);

        brahmanbaria.setOnClickListener(this);
        comilla.setOnClickListener(this);
        chandpur.setOnClickListener(this);
        lakshmipur.setOnClickListener(this);
        noakhali.setOnClickListener(this);
        feni.setOnClickListener(this);
        khagrachari.setOnClickListener(this);
        rangamati.setOnClickListener(this);
        bandarban.setOnClickListener(this);
        chittagong.setOnClickListener(this);
        coxBazar.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(ChittagongDivisionDistrict.this, DivisionName.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.brahmanbariaDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Brahmanbaria");
            startActivity(i);

        }else if (v.getId() == R.id.comillaDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Comilla");
            startActivity(i);

        }else if (v.getId() == R.id.chandpurDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Chandpur");
            startActivity(i);

        }else if (v.getId() == R.id.lakshmipurDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Lakshmipur");
            startActivity(i);

        }else if (v.getId() == R.id.noakhaliDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Noakhali");
            startActivity(i);

        }else if (v.getId() == R.id.feniDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Feni");
            startActivity(i);

        }else if (v.getId() == R.id.khagrachhariDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Khagrachari");
            startActivity(i);

        }else if (v.getId() == R.id.rangamatiDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Rangamati");
            startActivity(i);

        }else if (v.getId() == R.id.bandarbanDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Bandarban");
            startActivity(i);

        }else if (v.getId() == R.id.chittagongDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","Chittagong");
            startActivity(i);

        }else if (v.getId() == R.id.coxBazarDistrictId){

            Intent i = new Intent(ChittagongDivisionDistrict.this,ChittagongAllThanaContact.class);
            i.putExtra("chittagong","CoxBazar");
            startActivity(i);

        }else{
            ///do nothing
        }
    }
}
