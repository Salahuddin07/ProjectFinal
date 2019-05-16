package com.example.salahuddin.humansafety;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreInfo extends AppCompatActivity implements View.OnClickListener {

    private EditText userGmail, guardianName, guardianPhone, relationship;
    private Button saveButton;
    private Context context;

    DatabaseHelper databaseHelper;
    GuardianDetails guardianDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);

        ///adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        ///end

        userGmail = (EditText) findViewById(R.id.userEmailGuardianInfoEditTextId);
        guardianName = (EditText) findViewById(R.id.guardianNameEditTextId);
        guardianPhone = (EditText) findViewById(R.id.guardianPhoneEditTextId);
        relationship = (EditText) findViewById(R.id.relationshipEditTextId1);

        saveButton = (Button) findViewById(R.id.saveGuardianInfoButtonId);

        guardianDetails = new GuardianDetails();
        saveButton.setOnClickListener(this);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    ///MAIN CODE
    @Override
    public void onClick(View v) {

        // getting value
        String userEmail = userGmail.getText().toString();
        String guardian_name = guardianName.getText().toString();
        String guardian_phone = guardianPhone.getText().toString();
        String relation = relationship.getText().toString();
        ///END

        //SET VALUE TO USER DETAILS
        guardianDetails.setUserEmail(userEmail);
        guardianDetails.setGuardianName(guardian_name);
        guardianDetails.setGuardianPhone(guardian_phone);
        guardianDetails.setRelationship(relation);
        //END SET VALUE TO USER DETAILS

        if (v.getId() == R.id.saveGuardianInfoButtonId) {

            //VALIDATION GOES HERE
            if (guardian_name.isEmpty() || guardian_name.length() > 15) {

                guardianName.setError("Enter a valid name");

            } else if ((guardian_phone.isEmpty() || guardian_phone.length() != 11)) {

                guardianPhone.setError("Enter a valid phone Number");

            } else if ((relation.isEmpty()) || (relation.length() < 6)) {

                relationship.setError("Enter relationship with him/her");
                //VALIDATION END HERE
            } else {

                //IS DATA INSERTED CODE GOES HERE
                long rowId2 = databaseHelper.insertGuardianData(guardianDetails);

                    if (rowId2 > 0) {

                        Toast.makeText(getApplicationContext(), "Guardian info Successfully Saved", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "failed Guardian info Saved ", Toast.LENGTH_SHORT).show();
                    }
                //END HERE

            }

        }
    }

    @Override
    public void onBackPressed() {

        Toast.makeText(getApplicationContext(),"Without Filling all the field you can't leave",Toast.LENGTH_LONG).show();
        Intent moreInfo = new Intent(this,MoreInfo.class);
        startActivity(moreInfo);
    }
}
