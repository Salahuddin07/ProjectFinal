package com.example.salahuddin.humansafety;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Salahuddin on 7/23/2018.
 */

public class UserDetails {

    private String name,email,phone,password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
