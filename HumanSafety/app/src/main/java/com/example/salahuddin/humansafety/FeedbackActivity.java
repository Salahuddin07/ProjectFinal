package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendButton,clearutton;
    private EditText nameEditText,emailEditText,feedbackEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        //find and supportAction Bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //END

        //adding back button into toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //end

        nameEditText = (EditText) findViewById(R.id.feedbacknameEditTextId);
        emailEditText = (EditText) findViewById(R.id.feedbackMailEditTextId);
        feedbackEditText = (EditText) findViewById(R.id.feedbackEditTextId);

        sendButton = (Button) findViewById(R.id.feedbackSendButtonId);
        clearutton = (Button) findViewById(R.id.feedbackClearButtonId);

        sendButton.setOnClickListener(this);
        clearutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String feedbackMessage = feedbackEditText.getText().toString();

        if (name.isEmpty()){
            nameEditText.setError("Name can't be Empty");

        }else if(email.isEmpty()){

            emailEditText.setError("Email can't be Empty");
        }else if (feedbackMessage.isEmpty()){

            feedbackEditText.setError("Feedback Message box can't be Empty");
        }
        else {

            try {
                if (v.getId() == R.id.feedbackSendButtonId) {

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/email");

                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"salah15-4670@diu.edu.bd"});

                    intent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack from app");
                    intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\nEmail: " + email + "\nFeedback: " + feedbackMessage);
                    startActivity(Intent.createChooser(intent, "Feedback With"));

                } else if (v.getId() == R.id.feedbackClearButtonId) {

                    nameEditText.setText("");
                    emailEditText.setText("");
                    feedbackEditText.setText("");
                }
            } catch (Exception e) {

                Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
            }


        }
    }

    ////set onclicklistener into backbutton
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(FeedbackActivity.this, MainActivity2.class);
            startActivity(intent);
            finish();
        }
        //end
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
    }
}
