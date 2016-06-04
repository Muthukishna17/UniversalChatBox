package com.universal.chat.box;

/**
 * Created by Muthukrishna on 04-06-2016.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
    EditText chatName;
    public String f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        chatName = (EditText) findViewById(R.id.editText);
        Button Okay = (Button) findViewById(R.id.button);
        Okay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                    f = chatName.getText().toString();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("Username", chatName.getText().toString());
                setDefaults("tag",f,RegisterActivity.this);
                if (chatName!=null) {
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(RegisterActivity.this, getString(R.string.noUsernameEntered), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public static void setDefaults(String key, String value, Context context) {
        SharedPreferences sets = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sets.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
