package com.example.salahuddin.humansafety;

import android.content.Context;
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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainSignUpButton,alreadyLoginButton;
    private EditText nameEditText,emailEditText,phoneEditText,passwordEditText,confirm_password_EditText;
    private Context context;
    String emailPattern = "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,64}" +
                    "(" +
                    "." +
                    "[a-zA-Z0-9][a-zA-Z0-9-]{0,25}" +
                    ")+";
    DatabaseHelper databaseHelper;
    UserDetails userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

      ///adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        nameEditText = (EditText) findViewById(R.id.nameSignUpEditTextId);
        emailEditText = (EditText) findViewById(R.id.emailSignUpEditTextId);
        phoneEditText = (EditText) findViewById(R.id.phoneSignUpEditTextId);
        passwordEditText = (EditText) findViewById(R.id.passwordSignUpEditTextId);
        confirm_password_EditText = (EditText) findViewById(R.id.confirm_passwordSignUpEditTextId);

        alreadyLoginButton = (Button) findViewById(R.id.alreadyLoginButtonId);
        mainSignUpButton = (Button) findViewById(R.id.mainSignUpButtonId);

        userDetails =new UserDetails();
        alreadyLoginButton.setOnClickListener(this);
        mainSignUpButton.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }
    //end

    @Override
    public void onClick(View v) {

        //GET VALUE FROM FIELD
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirm_password = confirm_password_EditText.getText().toString();
        // END OF GETTING VALUE

        //SET VALUE TO USER DETAILS
        userDetails.setName(name);
        userDetails.setEmail(email);
        userDetails.setPhone(phone);
        userDetails.setPassword(password);
        //END SET VALUE TO USER DETAILS
        if (v.getId() == R.id.mainSignUpButtonId){

            //VALIDATION GOES HERE

            Matcher matcher = Pattern.compile(emailPattern).matcher(email);

            if(name.isEmpty() || name.length()>15){

                nameEditText.setError("Enter a valid name");

            }else if (!matcher.matches()){

                Toast.makeText(getApplicationContext(),"Enter a valid email",Toast.LENGTH_LONG).show();

            }else if ((phone.isEmpty() || phone.length() != 11)){

                phoneEditText.setError("Enter a valid phone Number");

            }else if ((password.isEmpty()) || (password.length()<6 )){

                passwordEditText.setError("Enter a valid Password at least 6 character");

            }else if (confirm_password.isEmpty() || !confirm_password.equals(password)) {

                confirm_password_EditText.setError("Password did't match");
            }else {

                //VALIDATION END HERE

                //DATA INSERTED CODE GOES HERE
                long rowId = databaseHelper.insertData(userDetails);

                    if (rowId > 0) {

                        Toast.makeText(getApplicationContext(), "SignUp Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, MoreInfo.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "SignUp failed", Toast.LENGTH_SHORT).show();
                    }

                //END HERE
            }

        }
        if (v.getId() == R.id.alreadyLoginButtonId){

            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }
}
