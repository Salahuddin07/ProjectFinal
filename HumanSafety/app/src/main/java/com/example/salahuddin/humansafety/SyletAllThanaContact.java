package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class SyletAllThanaContact extends AppCompatActivity {

    private TextView sylhetThanaContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sylet_all_thana_contact);


        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        sylhetThanaContract = (TextView) findViewById(R.id.sylhetThanaContract);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            String sylhetThanaContractList = bundle.getString("sylhet");
            showAllContract(sylhetThanaContractList);
        }
    }


    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(SyletAllThanaContact.this, SyletDivisionDistrict.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    void showAllContract(String sylhetThanaName){

        if (sylhetThanaName.equals("Habiganj")){

            sylhetThanaContract.setText(R.string.habiganjThanaContract);

        }else if (sylhetThanaName.equals("Moulivibazar")){

            sylhetThanaContract.setText(R.string.moulvibazarThanaContract);

        }else if (sylhetThanaName.equals("Sunamganj")){

            sylhetThanaContract.setText(R.string.sunamganjThanaContract);

        }else if (sylhetThanaName.equals("Sylhet")){

            sylhetThanaContract.setText(R.string.sylhetThanaContract);

        }else{
            ///do nothing
        }
    }
}
