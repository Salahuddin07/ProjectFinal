package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class DivisionName extends AppCompatActivity implements View.OnClickListener {

    private Button dhakaButton,barisalButton,khulnaButton,mymensinghButton,
            sylhetButton,rajshahiButton,rangpurButton,chittagongButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division_name);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        dhakaButton = (Button) findViewById(R.id.dhakaDivisionId);
        rajshahiButton = (Button) findViewById(R.id.rajshahiDivisionId);
        khulnaButton = (Button) findViewById(R.id.khulnaDivisionId);
        sylhetButton = (Button) findViewById(R.id.sylhetDivisionId);
        rangpurButton = (Button) findViewById(R.id.rangpurDivisionId);
        barisalButton = (Button) findViewById(R.id.barisaDivisionId);
        mymensinghButton = (Button) findViewById(R.id.mymensinghDivisionId);
        chittagongButton = (Button) findViewById(R.id.chittagongDivisionId);

        dhakaButton.setOnClickListener(this);
        rajshahiButton.setOnClickListener(this);
        khulnaButton.setOnClickListener(this);
        sylhetButton.setOnClickListener(this);
        rangpurButton.setOnClickListener(this);
        barisalButton.setOnClickListener(this);
        mymensinghButton.setOnClickListener(this);
        chittagongButton.setOnClickListener(this);

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(DivisionName.this, MainActivity2.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.dhakaDivisionId){

            Intent dhaka = new Intent(DivisionName.this,DhakaDivisionDistrict.class);
            startActivity(dhaka);

        }else if (v.getId() == R.id.barisaDivisionId){

            Intent barisal = new Intent(DivisionName.this,BarisalDivisionDistrict.class);
            startActivity(barisal);

        }else if (v.getId() == R.id.khulnaDivisionId){

            Intent khulna = new Intent(DivisionName.this,KhulnaDivisionDistrict.class);
            startActivity(khulna);

        }else if (v.getId() == R.id.rajshahiDivisionId){

            Intent rajshahi = new Intent(DivisionName.this,RajshahiDivisionDistrict.class);
            startActivity(rajshahi);

        }else if (v.getId() == R.id.rangpurDivisionId){

            Intent rangpur = new Intent(DivisionName.this,RangpurDivisionDistrict.class);
            startActivity(rangpur);

        }else if (v.getId() == R.id.sylhetDivisionId){

            Intent sylet = new Intent(DivisionName.this,SyletDivisionDistrict.class);
            startActivity(sylet);

        }else if (v.getId() == R.id.mymensinghDivisionId){

            Intent mymensingh = new Intent(DivisionName.this,MymensinghDivisionDistrict.class);
            startActivity(mymensingh);

        }else if(v.getId() == R.id.chittagongDivisionId){

            Intent chittagong = new Intent(DivisionName.this, ChittagongDivisionDistrict.class);
            startActivity(chittagong);

        }else{
            //do nothing
        }

    }
}