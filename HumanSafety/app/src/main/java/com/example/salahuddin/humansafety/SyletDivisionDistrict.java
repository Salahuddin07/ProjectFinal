package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SyletDivisionDistrict extends AppCompatActivity implements View.OnClickListener {

    private Button habiganj,moulivibazar,sunamganj,sylhet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylet_division_district);


        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        habiganj = (Button) findViewById(R.id.habiganjDistrictId);
        moulivibazar = (Button) findViewById(R.id.moulvibazarDistrictId);
        sunamganj = (Button) findViewById(R.id.sunamganjDistrictId);
        sylhet = (Button) findViewById(R.id.sylhetDistrictId);

        habiganj.setOnClickListener(this);
        moulivibazar.setOnClickListener(this);
        sunamganj.setOnClickListener(this);
        sylhet.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(SyletDivisionDistrict.this, DivisionName.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.habiganjDistrictId){

            Intent i = new Intent(SyletDivisionDistrict.this,SyletAllThanaContact.class);
            i.putExtra("sylhet","Habiganj");
            startActivity(i);

        }else if (v.getId() == R.id.moulvibazarDistrictId){

            Intent i = new Intent(SyletDivisionDistrict.this,SyletAllThanaContact.class);
            i.putExtra("sylhet","Moulivibazar");
            startActivity(i);

        }else if (v.getId() == R.id.sunamganjDistrictId){

            Intent i = new Intent(SyletDivisionDistrict.this,SyletAllThanaContact.class);
            i.putExtra("sylhet","Sunamganj");
            startActivity(i);

        }else if (v.getId() == R.id.sylhetDistrictId){

            Intent i = new Intent(SyletDivisionDistrict.this,SyletAllThanaContact.class);
            i.putExtra("sylhet","Sylhet");
            startActivity(i);

        }else{
            ///do nothing
        }
    }
}