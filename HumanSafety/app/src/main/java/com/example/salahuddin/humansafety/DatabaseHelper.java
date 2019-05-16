package com.example.salahuddin.humansafety;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Salahuddin on 7/12/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //DataBase Name
    private static final String DATABASE_NAME = "HumanSafety.db";

    //User Details table
    private static final String TABLE_NAME = "User_Details";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String PHONE = "Phone";
    private static final String PASSWORD = "Password";

    //Guardian table
    private static final String GUARDIAN_TABLE_NAME = "Guardian_info";
    private static final String GUARDIAN_ID = " Guardian_Id";
    private static final String USER_EMAIL = EMAIL;
    private static final String GUARDIAN_NAME = "Guardian_Name";
    private static final String GUARDIAN_PHONE = "Guardian_Phone";
    private static final String GUARDIAN_RELATIONSHIP = "Relation";

    ///Version
    private static final int VERSION = 42;

    //for create context
    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            ///create  User_Details table
            db.execSQL(
                    "create table User_Details " +
                            "(Id integer, Name text,email text primary key,phone text,Password text)"
            );
            ///create Guardian_info table
            db.execSQL(
                    "create table Guardian_info " +
                            "(Guardian_Id integer, email text primary key,Guardian_Name text,Guardian_Phone text,Relation text)"
            );
            Toast.makeText(context, "ON Create is called", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context,"Error 1"+e,Toast.LENGTH_LONG).show();
        }
        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context, "ON Upgrade is called", Toast.LENGTH_LONG).show();

            //drop User_Details table
            db.execSQL("DROP TABLE IF EXISTS User_Details");

            ///drop Guardian_info table
            db.execSQL("DROP TABLE IF EXISTS Guardian_info");

            ///create db again
            onCreate(db);

        }catch (Exception e){
            Toast.makeText(context,"Error 2",Toast.LENGTH_LONG).show();
        }
    }

    /// INSERt USER DAtA FROM SIGN UP PAGE
    public long insertData(UserDetails userDetails){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME,userDetails.getName());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(PHONE,userDetails.getPhone());
        contentValues.put(PASSWORD,userDetails.getPassword());

       long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }
    ///END

    ///insert Guardian Data
    public long insertGuardianData(GuardianDetails guardianDetails){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();

        contentValues1.put(USER_EMAIL,guardianDetails.getUserEmail());
        contentValues1.put(GUARDIAN_NAME,guardianDetails.getGuardianName());
        contentValues1.put(GUARDIAN_PHONE,guardianDetails.getGuardianPhone());
        contentValues1.put(GUARDIAN_RELATIONSHIP,guardianDetails.getRelationship());

        long rowId2 = sqLiteDatabase.insert(GUARDIAN_TABLE_NAME,null,contentValues1);
        return rowId2;
    }
    // END

    ////FIND PASSWORD AND EMAIL FOR LOGIN
    public Boolean findPassword(String uMail,String uPassword){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);

        Boolean result = false;

        if (cursor.getCount() == 0){

            Toast.makeText(context,"No data is found",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){

                String Email = cursor.getString(2);
                String password = cursor.getString(4);

                if (Email.equals(uMail) && password.equals(uPassword) ){

                    result = true;
                    break;
                }
            }
        }
        return result;

    }

            //UPDAtE PASSWORD GOES HERE
    public Boolean updateData(String email, String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);

        sqLiteDatabase.update(TABLE_NAME,contentValues, "EMAIL = ?",new String[] { email });
        return true;
    }
    // END

public Cursor getInformation(SQLiteDatabase databaseHelper){

    Cursor cr = databaseHelper.query(GUARDIAN_TABLE_NAME, new String[]{GUARDIAN_PHONE},null,null,null,null,null);
    return cr;
}


}
