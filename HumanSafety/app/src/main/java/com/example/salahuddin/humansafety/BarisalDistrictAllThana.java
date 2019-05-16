package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class BarisalDistrictAllThana extends AppCompatActivity {

    private TextView barisalAllThanaContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barisal_district_all_thana);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        barisalAllThanaContract = (TextView) findViewById(R.id.barisalThanaContract);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            String barisalThanaContractList = bundle.getString("barisal");
            showAllContract(barisalThanaContractList);
        }
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(BarisalDistrictAllThana.this, BarisalDivisionDistrict.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    void showAllContract(String barisalThanaName){

        if (barisalThanaName.equals("Barisal")){

            barisalAllThanaContract.setText(R.string.barisalThanaContract);

        }else if (barisalThanaName.equals("Barguna")){

            barisalAllThanaContract.setText(R.string.bargunaThanaContract);

        }else if (barisalThanaName.equals("Bhola")){

            barisalAllThanaContract.setText(R.string.bholaThanaContract);

        }else if (barisalThanaName.equals("Jhalokati")){

            barisalAllThanaContract.setText(R.string.jhalokathiThanaContract);

        }else if (barisalThanaName.equals("Patuakhali")){

            barisalAllThanaContract.setText(R.string.patuakhaliThanaContract);

        }else if ((barisalThanaName.equals("Pirojpur"))){

            barisalAllThanaContract.setText(R.string.pirojpurThanaContract);

        }else{
            ///do nothing
        }
    }
}
