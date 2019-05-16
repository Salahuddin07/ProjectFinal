package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class RajshahiDivisionDistrict extends AppCompatActivity implements View.OnClickListener {

    private Button bogura,chapainawabganj,joypurhat,naogaon,natore,pabna,rajshahi,sirajganj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajshahi_division_district);


        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        bogura = (Button) findViewById(R.id.boguraDistrictId);
        chapainawabganj = (Button) findViewById(R.id.chapainawabganjDistrictId);
        joypurhat = (Button) findViewById(R.id.joypurhatDistrictId);
        naogaon = (Button) findViewById(R.id.naogaonDistrictId);
        natore = (Button) findViewById(R.id.natoreDistrictId);
        pabna = (Button) findViewById(R.id.pabnakushtiaDistrictId);
        rajshahi = (Button) findViewById(R.id.rajshahiDistrictId);
        sirajganj = (Button) findViewById(R.id.sirajganjDistrictId);

        bogura.setOnClickListener(this);
        chapainawabganj.setOnClickListener(this);
        joypurhat.setOnClickListener(this);
        naogaon.setOnClickListener(this);
        natore.setOnClickListener(this);
        pabna.setOnClickListener(this);
        rajshahi.setOnClickListener(this);
        sirajganj.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(RajshahiDivisionDistrict.this, DivisionName.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.boguraDistrictId){

            Intent i = new Intent(RajshahiDivisionDistrict.this,RajshahiAllThanaContact.class);
            i.putExtra("rajshahi","Bogura");
            startActivity(i);

        }else if (v.getId() == R.id.chapainawabganjDistrictId){

            Intent i = new Intent(RajshahiDivisionDistrict.this,RajshahiAllThanaContact.class);
            i.putExtra("rajshahi","Chapainawabganj");
            startActivity(i);

        }else if (v.getId() == R.id.joypurhatDistrictId){

            Intent i = new Intent(RajshahiDivisionDistrict.this,RajshahiAllThanaContact.class);
            i.putExtra("rajshahi","Joypurhat");
            startActivity(i);

        }else if (v.getId() == R.id.naogaonDistrictId){

            Intent i = new Intent(RajshahiDivisionDistrict.this,RajshahiAllThanaContact.class);
            i.putExtra("rajshahi","Naogaon");
            startActivity(i);

        }else if (v.getId() == R.id.natoreDistrictId){

            Intent i = new Intent(RajshahiDivisionDistrict.this,RajshahiAllThanaContact.class);
            i.putExtra("rajshahi","Natore");
            startActivity(i);

        }else if (v.getId() == R.id.pabnakushtiaDistrictId){

            Intent i = new Intent(RajshahiDivisionDistrict.this,RajshahiAllThanaContact.class);
            i.putExtra("rajshahi","Pabna");
            startActivity(i);

        }else if (v.getId() == R.id.rajshahiDistrictId){

            Intent i = new Intent(RajshahiDivisionDistrict.this,RajshahiAllThanaContact.class);
            i.putExtra("rajshahi","Rajshahi");
            startActivity(i);

        }else if (v.getId() == R.id.sirajganjDistrictId){

            Intent i = new Intent(RajshahiDivisionDistrict.this,RajshahiAllThanaContact.class);
            i.putExtra("rajshahi","Sirajganj");
            startActivity(i);

        }else{
            ///do nothing
        }

    }
}
