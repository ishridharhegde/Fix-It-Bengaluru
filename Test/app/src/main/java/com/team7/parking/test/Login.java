package com.team7.parking.test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
    EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Link username and password variables with the view elements
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

    }


    public void login(View view)
    {
        if(username.getText().toString().equals("")||password.getText().toString().equals(""))
        {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage("Some fields are empty !")
                    .setCancelable(false)
                    .setNegativeButton("Ok.", null)
                    .show();
        }
        else
        {
            Intent intent = new Intent(Login.this, MainActivity.class);
            Toast.makeText(this, "Login successful !", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }
}
