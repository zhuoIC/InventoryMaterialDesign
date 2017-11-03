package com.example.inventorymaterial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Pide los datos de usuario para acceder a la aplicación
 * @author Nicolás Hernández Jiménez
 */

public class LoginActivity extends AppCompatActivity {
    private TextView txvSignUp;
    private Button btnSignIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txvSignUp = (TextView) findViewById(R.id.txvSingUp);
        //txvSignUp.setPaintFlags(txvSignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });
    }
}
