package com.example.salahuddin.humansafety;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mainLogInButton,signUpNowButton,forgetPasswordButton,adminButton;
    private EditText uEmailEditText,passwordEditText;
    DatabaseHelper databaseHelper;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

///adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        ///end

        uEmailEditText = (EditText) findViewById(R.id.loginMailEditTextId);
        passwordEditText = (EditText) findViewById(R.id.loginEditTextPasswordId);

        mainLogInButton = (Button) findViewById(R.id.mainLoginButtonId);
        signUpNowButton = (Button) findViewById(R.id.signUpfromLoginPageButtonId);
        forgetPasswordButton = (Button) findViewById(R.id.forgetPasswordButtonId);

        mainLogInButton.setOnClickListener(this);
        signUpNowButton.setOnClickListener(this);
        forgetPasswordButton.setOnClickListener(this);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();



    }
    @Override
    public void onClick(View v) {
            //for log in (USER data)
        String uMail = uEmailEditText.getText().toString();
        String uPassword = passwordEditText.getText().toString();
          //end

        if(v.getId() == R.id.mainLoginButtonId){

            Boolean result = databaseHelper.findPassword(uMail,uPassword);

            if (result == true){

                SessionManager sessionManager = new SessionManager(LoginActivity.this);
                sessionManager.setEmail(uMail);                 //set Email into session manager
                               //set Email into session manager
                saveUserEmailInSharedPreference(uMail);
                sendToHomeActivity();

            }else {
                Toast.makeText(getApplicationContext(),"Email and Password did't match",Toast.LENGTH_LONG).show();
            }

        }

        if(v.getId() == R.id.signUpfromLoginPageButtonId){
            Intent intent= new Intent(this,SignUpActivity.class);
            startActivity(intent);
            finish();
        }

        if(v.getId() == R.id.forgetPasswordButtonId){
            Intent intent= new Intent(this,Re_setPassword.class);
            startActivity(intent);
            finish();

        }

    }

    private void sendToHomeActivity() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
        finish();
    }

    private void saveUserEmailInSharedPreference(String uMail) {
        SharedPreferences.Editor editor = getSharedPreferences(Constant.MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString(Constant.EMAIL, uMail);
        editor.apply();
    }

    //set alert dialog
    @Override
    public void onBackPressed() {
        Log.e("BackPress", "OnBackPressedCalled: ");

        alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);
        alertDialogBuilder.setTitle(R.string.dialogTitle);
        alertDialogBuilder.setMessage(R.string.dialogMessage);
        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}