package com.example.insta;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("OgCQh7WeQJqrYfamm6MwWIeq5i5D5xDiHN6k6bPs")
                .clientKey("xES55jiqUCTdtcBn73dGe3Q3dGQBACbUAUxrha55")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}