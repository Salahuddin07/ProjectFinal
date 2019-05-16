package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class ChittagongAllThanaContact extends AppCompatActivity{

        private TextView chittagongAllThanaContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chittagong_all_thana_contact);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        chittagongAllThanaContract = (TextView) findViewById(R.id.chittagongThanaContract);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            String chittagongThanaContractList = bundle.getString("chittagong");
            showAllContract(chittagongThanaContractList);
        }
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(ChittagongAllThanaContact.this, ChittagongDivisionDistrict.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    void showAllContract(String chittagongThanaName){

        if (chittagongThanaName.equals("Brahmanbaria")){

            chittagongAllThanaContract.setText(R.string.brahmanbariaThanaContract);

        }else if (chittagongThanaName.equals("Comilla")){

            chittagongAllThanaContract.setText(R.string.comillaThanaContract);

        }else if (chittagongThanaName.equals("Chandpur")){

            chittagongAllThanaContract.setText(R.string.chandpurThanaContract);

        }else if (chittagongThanaName.equals("Lakshmipur")){

            chittagongAllThanaContract.setText(R.string.lakshmipurThanaContract);

        }else if (chittagongThanaName.equals("Noakhali")){

            chittagongAllThanaContract.setText(R.string.noakhaliThanaContract);

        }else if (chittagongThanaName.equals("Feni")){

            chittagongAllThanaContract.setText(R.string.feniThanaContract);

        }else if (chittagongThanaName.equals("Khagrachari")){

            chittagongAllThanaContract.setText(R.string.khagracchariThanaContract);

        }else if (chittagongThanaName.equals("Rangamati")){

            chittagongAllThanaContract.setText(R.string.rangpurThanaContract);

        }else if (chittagongThanaName.equals("Bandarban")){

            chittagongAllThanaContract.setText(R.string.gaibandhaThanaContract);

        }else if (chittagongThanaName.equals("Chittagong")){

            chittagongAllThanaContract.setText(R.string.chittagongThanaContract);

        }else if (chittagongThanaName.equals("CoxBazar")){

            chittagongAllThanaContract.setText(R.string.coxsBazarThanaContract);

        }else{
            ///do nothing
        }
    }
}
