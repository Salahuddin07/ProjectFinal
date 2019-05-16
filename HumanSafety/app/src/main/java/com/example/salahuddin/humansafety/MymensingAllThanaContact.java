package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MymensingAllThanaContact extends AppCompatActivity {

    private TextView mymensingAllThanaContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymensing_all_thana_contact);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        mymensingAllThanaContract = (TextView) findViewById(R.id.mymensingThanaContract);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            String chittagongThanaContractList = bundle.getString("mymensing");
            showAllContract(chittagongThanaContractList);
        }
    }


    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(MymensingAllThanaContact.this, MymensinghDivisionDistrict.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    void showAllContract(String mymensingThanaName){

        if (mymensingThanaName.equals("Jamalpur")){

            mymensingAllThanaContract.setText(R.string.jamalThanaContract);

        }else if (mymensingThanaName.equals("Mymensing")){

            mymensingAllThanaContract.setText(R.string.mymensingThanaContract);

        }else if (mymensingThanaName.equals("Netrokona")){

            mymensingAllThanaContract.setText(R.string.netrokonaThanaContract);

        }else if (mymensingThanaName.equals("Sherpur")){

            mymensingAllThanaContract.setText(R.string.sherpurThanaContract);

        }else{
            ///do nothing
        }
    }
}
