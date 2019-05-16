package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class DhakaDistrictAllThana extends AppCompatActivity {

    private TextView dhakaAllThanaContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dhaka_district_all_thana);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        dhakaAllThanaContract = (TextView) findViewById(R.id.dhakaAllThanaContract);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            String dhakaAllThanaContractList = bundle.getString("dhaka");
            showAllContract(dhakaAllThanaContractList);
        }
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(DhakaDistrictAllThana.this, DhakaDivisionDistrict.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    void showAllContract(String dhakaThanaName){

        if (dhakaThanaName.equals("Dhaka")){

            dhakaAllThanaContract.setText(R.string.DhakaThanaContract);

        }else if (dhakaThanaName.equals("Madaripur")){

            dhakaAllThanaContract.setText(R.string.MadaripurThanaContract);

        }else if (dhakaThanaName.equals("Faridpur")){

            dhakaAllThanaContract.setText(R.string.FaridpurThanaContract);

        }else if (dhakaThanaName.equals("Gazipur")){

            dhakaAllThanaContract.setText(R.string.GazipurThanaContract);

        }else if (dhakaThanaName.equals("Gopalganj")){

            dhakaAllThanaContract.setText(R.string.GopalgoanjThanaContract);

        }else if (dhakaThanaName.equals("Jamalpur")){

            dhakaAllThanaContract.setText(R.string.JamalpurThanaContract);

        }else if (dhakaThanaName.equals("Kishoreganj")){

            dhakaAllThanaContract.setText(R.string.KishoregonjThanaContract);

        }else if (dhakaThanaName.equals("Manikganj")){

            dhakaAllThanaContract.setText(R.string.ManikThanaContract);

        }else if (dhakaThanaName.equals("Munshiganj")){

            dhakaAllThanaContract.setText(R.string.munshiThanaContract);

        }else if (dhakaThanaName.equals("Narsingdi")){

            dhakaAllThanaContract.setText(R.string.narsingdiThanaContract);

        }else if (dhakaThanaName.equals("Rajbari")){

            dhakaAllThanaContract.setText(R.string.rajbariThanaContract);

        }else if (dhakaThanaName.equals("Shariatpur")){

            dhakaAllThanaContract.setText(R.string.shariatpurThanaContract);

        }else if (dhakaThanaName.equals("Tangail")){

            dhakaAllThanaContract.setText(R.string.tangailThanaContract);

        }else if (dhakaThanaName.equals("Narayanganj")){

            dhakaAllThanaContract.setText(R.string.narayanganjThanaContract);
        }else{
            ///do nothing
        }
    }
}
