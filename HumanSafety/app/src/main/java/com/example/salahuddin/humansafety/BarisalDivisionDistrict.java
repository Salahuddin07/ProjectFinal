package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BarisalDivisionDistrict extends AppCompatActivity implements View.OnClickListener {

    private Button barisal,Barguna,Bhola,Jhalokati,Patuakhali,Pirojpur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barisal_division_district);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        Barguna = (Button) findViewById(R.id.bargunaDistrictId);
        Bhola = (Button) findViewById(R.id.bholaDistrictId);
        Jhalokati = (Button) findViewById(R.id.jhalokatiDistrictId);
        Patuakhali = (Button) findViewById(R.id.patuakhaliDistrictId);
        Pirojpur = (Button) findViewById(R.id.pirojpurDistrictId);
        barisal = (Button) findViewById(R.id.barisalDistrictId);

        Barguna.setOnClickListener(this);
        Bhola.setOnClickListener(this);
        Jhalokati.setOnClickListener(this);
        Patuakhali.setOnClickListener(this);
        Pirojpur.setOnClickListener(this);
        barisal.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }


    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(BarisalDivisionDistrict.this, DivisionName.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.barisalDistrictId){

            Intent i = new Intent(BarisalDivisionDistrict.this,BarisalDistrictAllThana.class);
            i.putExtra("barisal","Barisal");
            startActivity(i);

        }else if (v.getId() == R.id.bargunaDistrictId){

            Intent i = new Intent(BarisalDivisionDistrict.this,BarisalDistrictAllThana.class);
            i.putExtra("barisal","Barguna");
            startActivity(i);

        }else if (v.getId() == R.id.bholaDistrictId){

            Intent i = new Intent(BarisalDivisionDistrict.this,BarisalDistrictAllThana.class);
            i.putExtra("barisal","Bhola");
            startActivity(i);

        }else if (v.getId() == R.id.jhalokatiDistrictId){

            Intent i = new Intent(BarisalDivisionDistrict.this,BarisalDistrictAllThana.class);
            i.putExtra("barisal","Jhalokati");
            startActivity(i);

        }else if (v.getId() == R.id.patuakhaliDistrictId){

            Intent i = new Intent(BarisalDivisionDistrict.this,BarisalDistrictAllThana.class);
            i.putExtra("barisal","Patuakhali");
            startActivity(i);

        }else if (v.getId() == R.id.pirojpurDistrictId){

            Intent i = new Intent(BarisalDivisionDistrict.this,BarisalDistrictAllThana.class);
            i.putExtra("barisal","Pirojpur");
            startActivity(i);

        }else{
            ///do nothing
        }
    }
}
