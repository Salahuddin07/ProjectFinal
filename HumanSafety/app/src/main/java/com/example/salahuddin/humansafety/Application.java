package com.example.salahuddin.humansafety;

import com.facebook.stetho.Stetho;

public class Application extends android.app.Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
