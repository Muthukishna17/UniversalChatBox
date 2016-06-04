package com.universal.chat.box;

/**
 * Created by Muthukrishna on 04-06-2016.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class PreferenceActivity extends Activity {
    public String def = "User0000";
    public boolean firstRun;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings=getSharedPreferences("prefs", 0);
        SharedPreferences.Editor editor=settings.edit();
        firstRun=settings.getBoolean("firstRun", false);
        if(!firstRun)
        {
            Intent i=new Intent(PreferenceActivity.this,RegisterActivity.class);
            startActivity(i);
            editor.putBoolean("firstRun", true);
            editor.commit();
            finish();
        }
        else
        {
            Intent a=new Intent(PreferenceActivity.this,MainActivity.class);
            startActivity(a);
            editor.commit();
            finish();
        }
    }
}