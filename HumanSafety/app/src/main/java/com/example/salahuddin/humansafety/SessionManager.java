package com.example.salahuddin.humansafety;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Salahuddin on 10/1/2018.
 */

public class SessionManager {
    Context context;

    public void removeUser(){

        sharedPreferences.edit().clear().commit();
    }
///set Gatter and Setter method
    public String getEmail() {
       email = sharedPreferences.getString("userdata","");
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        sharedPreferences.edit().putString("userdata",email).commit();
    }


    public String getPhone() {

        phone = sharedPreferences.getString("userdata","");
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        sharedPreferences.edit().putString("userdata",phone).commit();
    }
    ///end
 ////declare
    private String email;
    private String phone;
    SharedPreferences sharedPreferences;
////end

    ///set context in session manager
    public SessionManager(Context context){

        this.context = context;
        sharedPreferences = context.getSharedPreferences("userinfo",context.MODE_PRIVATE);
    }
    ///end

}
