package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Re_setPassword extends AppCompatActivity {

    private EditText emailInUpdateEditText,newUpdatePasswordEditText,confirmNewUpdatePasswordEditText;
    private Button updateRe_password;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_set_password);

            //find and supportAction Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //END

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        emailInUpdateEditText = (EditText) findViewById(R.id.newUpdateMailEditTextId);
        newUpdatePasswordEditText = (EditText) findViewById(R.id.newUpdatePasswordEditTextId);
        confirmNewUpdatePasswordEditText = (EditText) findViewById(R.id.confirmNewUpdatePasswordEditTextId);
        updateRe_password = (Button) findViewById(R.id.updatePasswordSubmitButtonId);


        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();
        UpdateData();

    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(Re_setPassword.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }
    //end

    public void UpdateData(){

        updateRe_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GET VALUE
                String email = emailInUpdateEditText.getText().toString();
                String password = newUpdatePasswordEditText.getText().toString();
                String confirm_password = confirmNewUpdatePasswordEditText.getText().toString();
                ///END

                //validation goes here
                if ((password.isEmpty()) || (password.length() < 6)) {

                    newUpdatePasswordEditText.setError("Enter a valid Password at least 6 character");

                } else if (confirm_password.isEmpty() || !confirm_password.equals(password)) {

                    confirmNewUpdatePasswordEditText.setError("Password did't match");
                }else {
                    //VALODA END

                    boolean isUpdate = databaseHelper.updateData(email, password);



                        if (isUpdate == true) {
                            Toast.makeText(getApplicationContext(), "Password Re-set successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(Re_setPassword.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Password not update", Toast.LENGTH_SHORT).show();
                        }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}