package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class RangpurAllThanaContact extends AppCompatActivity {

    private TextView rangpurAllThanaContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rangpur_all_thana_contact);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        rangpurAllThanaContract = (TextView) findViewById(R.id.rangpurThanaContract);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            String rangpurThanaContactList = bundle.getString("rangpur");
            showAllContract(rangpurThanaContactList);
        }
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(RangpurAllThanaContact.this, RangpurDivisionDistrict.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    void showAllContract(String rangpurThanaName){

        if (rangpurThanaName.equals("Thakurgaon")){

            rangpurAllThanaContract.setText(R.string.thakurgaonThanaContract);

        }else if (rangpurThanaName.equals("Rangpur")){

            rangpurAllThanaContract.setText(R.string.rangpurThanaContract);

        }else if (rangpurThanaName.equals("Panchagarh")){

            rangpurAllThanaContract.setText(R.string.panchagarThanaContract);

        }else if (rangpurThanaName.equals("Nilphamari")){

            rangpurAllThanaContract.setText(R.string.nilphamariThanaContract);

        }else if (rangpurThanaName.equals("Lalmonirhat")){

            rangpurAllThanaContract.setText(R.string.lalmonirhatThanaContract);

        }else if (rangpurThanaName.equals("Kurigram")){

            rangpurAllThanaContract.setText(R.string.kurigramThanaContract);

        }else if (rangpurThanaName.equals("Gaibandha")){

            rangpurAllThanaContract.setText(R.string.gaibandhaThanaContract);

        }else if (rangpurThanaName.equals("Dinajpur")){

            rangpurAllThanaContract.setText(R.string.dinajpurThanaContract);

        }else{
            ///do nothing
        }
    }
}
