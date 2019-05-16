package com.example.salahuddin.humansafety;

        import android.Manifest;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.content.IntentFilter;
        import android.content.pm.PackageManager;
        import android.os.Bundle;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.content.ContextCompat;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.CompoundButton;
        import android.widget.Switch;
        import android.support.v7.widget.Toolbar;
        import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    private Switch aSwitch;
    private Button bdPoliceContactButton;
    private AlertDialog.Builder alertDialogBuilder;
    private MyBroadCastReceiver myBroadCastReceiver;
    private IntentFilter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //adding toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        //end

        aSwitch = (Switch) findViewById(R.id.switchId);
        bdPoliceContactButton = (Button) findViewById(R.id.bdPoliceContactId);
        bdPoliceContactButton.setOnClickListener(this);

        requirePermission();

        aSwitch.setChecked(true);

        if(aSwitch.isChecked()){
            //...broadcas
            filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
            //filter.addAction(Intent.ACTION_SCREEN_OFF);
            filter.addAction(Intent.ACTION_USER_PRESENT);

            myBroadCastReceiver = new MyBroadCastReceiver(MainActivity2.this);

            registerReceiver(myBroadCastReceiver, filter);

            Intent serviceIntent = new Intent(MainActivity2.this, ExampleService.class);
            startService(serviceIntent);

        }

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_LONG).show();

                    Intent serviceIntent = new Intent(MainActivity2.this, ExampleService.class);
                    startService(serviceIntent);

                } else {
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_LONG).show();

                    Intent serviceIntent = new Intent(MainActivity2.this, ExampleService.class);
                    stopService(serviceIntent);
                }
            }
        });

    }

    private void requirePermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            ///if permission has not been granted then check if the user denied the permission
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity2.this, Manifest.permission.SEND_SMS)) {
                ///do nothing
                Toast.makeText(getApplicationContext(), "User denied permission", Toast.LENGTH_LONG).show();
                //// Asking for requesting permission
                ActivityCompat.requestPermissions(MainActivity2.this,
                                                  new String[]{Manifest.permission.SEND_SMS},
                                                  MY_PERMISSIONS_REQUEST_SEND_SMS);
            } else {
                //// Asking for requesting permission
                ActivityCompat.requestPermissions(MainActivity2.this,
                                                  new String[]{Manifest.permission.SEND_SMS, Manifest.permission.ACCESS_FINE_LOCATION},
                                                  MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }else{
            // Toast.makeText(getApplicationContext(), "permissions are okay", Toast.LENGTH_LONG).show();
        }
    }

    ///adding menu items
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);
        return true;
    }
    //end

    public boolean onOptionsItemSelected(MenuItem item) {

        //share button task
        if (item.getItemId() == R.id.shareId) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");

            String subject = "Human Safety app";
            String body = "This app is very helpful for your emmergency moment.\n com.example.salahuddin.humansafety";

            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, body);

            startActivity(Intent.createChooser(intent, "Share With"));

        } else if (item.getItemId() == R.id.FeedBackId) {

            Intent intent = new Intent(MainActivity2.this, FeedbackActivity.class);
            startActivity(intent);
            finish();

        } else if (item.getItemId() == R.id.aboutId) {

            Intent intent = new Intent(MainActivity2.this, About.class);
            startActivity(intent);
            finish();

        }else if (item.getItemId() == R.id.logOut){
            new SessionManager(MainActivity2.this).removeUser();
            unregisterReceiver(myBroadCastReceiver);
            Intent intent = new Intent(MainActivity2.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }else if (item.getItemId()== R.id.helpId){

            Intent intent = new Intent(MainActivity2.this, Help.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void phone() {
        Intent i = new Intent(MainActivity2.this, MyBroadCastReceiver.class);
        startActivity(i);
    }

    @Override
    public void onClick(View v) {

        Intent DmpPoliceContract = new Intent(MainActivity2.this,DivisionName.class);
        startActivity(DmpPoliceContract);
    }
//set alert dialog
    @Override
    public void onBackPressed() {
        Log.e("BackPress", "OnBackPressedCalled: ");

        alertDialogBuilder = new AlertDialog.Builder(MainActivity2.this);
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
