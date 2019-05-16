package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DhakaDivisionDistrict extends AppCompatActivity implements View.OnClickListener {

    private Button dhakaDistrict,madaripurDistrict,faridpurDistrict,gazipurDistrict,gopalganjDistrict,
                    jamalpurDistrict,kishoreganjDistrict,manikganjDistrict,munshiganjDistrict,narayanganjDistrict,
                    rajbariDistrict,shariatpurDistrict,tangailDistrict,narsingdiDistrict;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_division_district);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        dhakaDistrict = (Button) findViewById(R.id.dhakaDistrictId);
        madaripurDistrict = (Button) findViewById(R.id.madaripurDistrictId);
        faridpurDistrict = (Button) findViewById(R.id.faridpurDistrictId);
        gazipurDistrict = (Button) findViewById(R.id.gazipurDistrictId);
        gopalganjDistrict = (Button) findViewById(R.id.gopalganjDistrictId);
        jamalpurDistrict = (Button) findViewById(R.id.jamalpurDistrictId);
        kishoreganjDistrict = (Button) findViewById(R.id.kishoreganjDistrictId);
        manikganjDistrict = (Button) findViewById(R.id.manikganjDistrictId);
        munshiganjDistrict = (Button) findViewById(R.id.munshiganjDistrictId);
        narayanganjDistrict = (Button) findViewById(R.id.narayanganjDistrictId);
        rajbariDistrict = (Button) findViewById(R.id.rajbariDistrictId);
        shariatpurDistrict = (Button) findViewById(R.id.shariatpurDistrictId);
        tangailDistrict = (Button) findViewById(R.id.tangailDistrictId);
        narsingdiDistrict = (Button) findViewById(R.id.narsingdiDistrictId);

        dhakaDistrict.setOnClickListener(this);
        madaripurDistrict.setOnClickListener(this);
        faridpurDistrict.setOnClickListener(this);
        gazipurDistrict.setOnClickListener(this);
        gopalganjDistrict.setOnClickListener(this);
        jamalpurDistrict.setOnClickListener(this);
        kishoreganjDistrict.setOnClickListener(this);
        manikganjDistrict.setOnClickListener(this);
        munshiganjDistrict.setOnClickListener(this);
        narayanganjDistrict.setOnClickListener(this);
        rajbariDistrict.setOnClickListener(this);
        shariatpurDistrict.setOnClickListener(this);
        tangailDistrict.setOnClickListener(this);
        narsingdiDistrict.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(DhakaDivisionDistrict.this, DivisionName.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.dhakaDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Dhaka");
            startActivity(i);

        }else if (v.getId() == R.id.madaripurDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Madaripur");
            startActivity(i);

        }else if (v.getId() == R.id.faridpurDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Faridpur");
            startActivity(i);

        }else if (v.getId() == R.id.gazipurDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Gazipur");
            startActivity(i);

        }else if (v.getId() == R.id.gopalganjDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Gopalganj");
            startActivity(i);

        }else if (v.getId() == R.id.jamalpurDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Jamalpur");
            startActivity(i);

        }else if (v.getId() == R.id.kishoreganjDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Kishoreganj");
            startActivity(i);

        }else if (v.getId() == R.id.manikganjDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Manikganj");
            startActivity(i);

        }else if (v.getId() == R.id.munshiganjDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Munshiganj");
            startActivity(i);

        }else if (v.getId() == R.id.narsingdiDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Narsingdi");
            startActivity(i);

        }else if (v.getId() == R.id.rajbariDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Rajbari");
            startActivity(i);

        }else if (v.getId() == R.id.shariatpurDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Shariatpur");
            startActivity(i);

        }else if (v.getId() == R.id.tangailDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Tangail");
            startActivity(i);

        }else if (v.getId() == R.id.narayanganjDistrictId){

            Intent i = new Intent(DhakaDivisionDistrict.this,DhakaDistrictAllThana.class);
            i.putExtra("dhaka","Narayanganj");
            startActivity(i);

        }else{
            ///do nothing
        }
    }
}
