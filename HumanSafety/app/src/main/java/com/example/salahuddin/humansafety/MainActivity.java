package com.example.salahuddin.humansafety;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    DatabaseHelper databaseHelper;
    UserDetails userDetails;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        textView = (TextView) findViewById(R.id.slahTextViewId);
        imageView = (ImageView) findViewById(R.id.slashScreenLogoId);
        sessionManager = new SessionManager(MainActivity.this);//session manager er object MainActivity te


        Animation myAnimation = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        textView.setAnimation(myAnimation);
        imageView.setAnimation(myAnimation);

        Thread timer = new Thread(){

            public void run(){
                try{
                    sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    //if login then go MainActivity
                    if(sessionManager.getEmail() != "") {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        intent.putExtra("email",sessionManager.getEmail());
                        intent.putExtra("phone",sessionManager.getPhone());
                        startActivity(intent);
                        finish();//end
                    }else { ///or go login Activity
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }//end
                }
            }
        };
        timer.start();
}
}
