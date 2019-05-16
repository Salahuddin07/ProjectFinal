package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class KhulnaAllThanaContract extends AppCompatActivity {

    private TextView khulnaAllThanaContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khulna_all_thana_contract);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        khulnaAllThanaContract = (TextView) findViewById(R.id.khulnaThanaContract);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){

            String khulnaThanaContractList = bundle.getString("khulna");
            showAllContract(khulnaThanaContractList);
        }
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(KhulnaAllThanaContract.this, KhulnaDivisionDistrict.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    void showAllContract(String khulnaThanaName){

        if (khulnaThanaName.equals("Bagerhat")){

            khulnaAllThanaContract.setText(R.string.bagerhatThanaContract);

        }else if (khulnaThanaName.equals("Chuadanga")){

            khulnaAllThanaContract.setText(R.string.chuadangaThanaContract);

        }else if (khulnaThanaName.equals("Jessore")){

            khulnaAllThanaContract.setText(R.string.jessoreThanaContract);

        }else if (khulnaThanaName.equals("Jhenaida")){

            khulnaAllThanaContract.setText(R.string.jhenaidaThanaContract);

        }else if (khulnaThanaName.equals("Khulna")){

            khulnaAllThanaContract.setText(R.string.khulnaThanaContract);

        }else if (khulnaThanaName.equals("Kustia")){

            khulnaAllThanaContract.setText(R.string.kustiaThanaContract);

        }else if (khulnaThanaName.equals("Magura")){

            khulnaAllThanaContract.setText(R.string.maguraThanaContract);

        }else if (khulnaThanaName.equals("Meherpur")){

            khulnaAllThanaContract.setText(R.string.meherpurThanaContract);

        }else if (khulnaThanaName.equals("Narail")){

            khulnaAllThanaContract.setText(R.string.narailThanaContract);

        }else if (khulnaThanaName.equals("Satkhira")){

            khulnaAllThanaContract.setText(R.string.satkhiraThanaContract);

        }else{
            ///do nothing
        }
    }
}
