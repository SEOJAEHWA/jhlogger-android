package com.jhfactory.jlogger.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jhfactory.jhlogger.LogLevel;
import com.jhfactory.jhlogger.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            Logger.init()
                    .setTag("SEOJAEHWA")
                    .setLogLevel(LogLevel.DEBUG)
                    .setShowThreadInfo(true);
        }
        else {
            Logger.init()
                    .setLogLevel(LogLevel.RELEASE);
        }

        setContentView(R.layout.activity_main);
        Logger.v("onCreate -------------------------------");
        Logger.i("onCreate -------------------------------");
        Logger.d("onCreate -------------------------------");
        Logger.d("onCreate -------------------------------", false);
        Logger.w("onCreate -------------------------------");
        Logger.e("onCreate -------------------------------");

        final String json = "[{\n" +
                "\t\"type\": \"A\",\n" +
                "\t\"image_path\": \"https://a.jpg\"\n" +
                "}, {\n" +
                "\t\"type\": \"B\",\n" +
                "\t\"image_path\": \"https://b.jpg\"\n" +
                "}]";
//        Logger.json(json);
        Logger.json("Result is...", json);

        try {
            String str = null;
            str.toString();
        }
        catch (NullPointerException e) {
            Logger.printStackTrace(e);
        }
    }

    // TODO: 2017-09-12 Intent logger 
    // TODO: 2017-09-12  
}
