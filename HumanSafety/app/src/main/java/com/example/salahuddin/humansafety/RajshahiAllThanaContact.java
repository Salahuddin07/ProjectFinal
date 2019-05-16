package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class RajshahiAllThanaContact extends AppCompatActivity {

    private TextView rajshahiAllThanaContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajshahi_all_thana_contact);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        rajshahiAllThanaContract = (TextView) findViewById(R.id.rajshahiThanaContract);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            String rajshahiThanaContractList = bundle.getString("rajshahi");
            showAllContract(rajshahiThanaContractList);
        }
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(RajshahiAllThanaContact.this, RajshahiDivisionDistrict.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    void showAllContract(String rajshahiThanaName){

        if (rajshahiThanaName.equals("Bogura")){

            rajshahiAllThanaContract.setText(R.string.boguraThanaContract);

        }else if (rajshahiThanaName.equals("Chapainawabganj")){

            rajshahiAllThanaContract.setText(R.string.chapainawabganjThanaContract);

        }else if (rajshahiThanaName.equals("Joypurhat")){

            rajshahiAllThanaContract.setText(R.string.joypurhatThanaContract);

        }else if (rajshahiThanaName.equals("Naogaon")){

            rajshahiAllThanaContract.setText(R.string.neogaThanaContract);

        }else if (rajshahiThanaName.equals("Natore")){

            rajshahiAllThanaContract.setText(R.string.natoreThanaContract);

        }else if (rajshahiThanaName.equals("Pabna")){

            rajshahiAllThanaContract.setText(R.string.pabnaThanaContract);

        }else if (rajshahiThanaName.equals("Rajshahi")){

            rajshahiAllThanaContract.setText(R.string.rajshahiThanaContract);

        }else if (rajshahiThanaName.equals("Sirajganj")){

            rajshahiAllThanaContract.setText(R.string.sirajganjThanaContract);

        }else{
            ///do nothing
        }
    }
}
