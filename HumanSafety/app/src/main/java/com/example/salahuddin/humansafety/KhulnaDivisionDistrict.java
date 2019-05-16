package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class KhulnaDivisionDistrict extends AppCompatActivity implements View.OnClickListener {

    private Button bagerhat,chuadanga,jessore,jhenaida,khulna,kustia,magura,meherpur,narail,satkhira;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khulna_division_district);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        bagerhat = (Button) findViewById(R.id.bagerhatDistrictId);
        chuadanga = (Button) findViewById(R.id.chuadangaDistrictId);
        jessore = (Button) findViewById(R.id.jessoreDistrictId);
        jhenaida = (Button) findViewById(R.id.jhenaidahDistrictId);
        khulna = (Button) findViewById(R.id.khulnaDistrictId);
        kustia = (Button) findViewById(R.id.kushtiaDistrictId);
        magura = (Button) findViewById(R.id.maguraDistrictId);
        meherpur = (Button) findViewById(R.id.meherpurDistrictId);
        narail = (Button) findViewById(R.id.narailDistrictId);
        satkhira = (Button) findViewById(R.id.satkhiraDistrictId);

        bagerhat.setOnClickListener(this);
        chuadanga.setOnClickListener(this);
        jessore.setOnClickListener(this);
        jhenaida.setOnClickListener(this);
        khulna.setOnClickListener(this);
        kustia.setOnClickListener(this);
        magura.setOnClickListener(this);
        meherpur.setOnClickListener(this);
        narail.setOnClickListener(this);
        satkhira.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(KhulnaDivisionDistrict.this, DivisionName.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.bagerhatDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Bagerhat");
            startActivity(i);

        }else if (v.getId() == R.id.chuadangaDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Chuadanga");
            startActivity(i);

        }else if (v.getId() == R.id.jessoreDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Jessore");
            startActivity(i);

        }else if (v.getId() == R.id.jhenaidahDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Jhenaida");
            startActivity(i);

        }else if (v.getId() == R.id.khulnaDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Khulna");
            startActivity(i);

        }else if (v.getId() == R.id.kushtiaDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Kustia");
            startActivity(i);

        }else if (v.getId() == R.id.maguraDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Magura");
            startActivity(i);

        }else if (v.getId() == R.id.meherpurDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Meherpur");
            startActivity(i);

        }else if (v.getId() == R.id.narailDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Narail");
            startActivity(i);

        }else if (v.getId() == R.id.satkhiraDistrictId){

            Intent i = new Intent(KhulnaDivisionDistrict.this,KhulnaAllThanaContract.class);
            i.putExtra("khulna","Satkhira");
            startActivity(i);

        }else{
            ///do nothing
        }
    }
}
