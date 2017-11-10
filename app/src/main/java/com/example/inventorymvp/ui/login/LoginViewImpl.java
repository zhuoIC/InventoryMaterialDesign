package com.example.inventorymvp.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inventorymvp.DashboardActivity;
import com.example.inventorymvp.R;

/**
 * Pide los datos de usuario para acceder a la aplicación
 * @author Nicolás Hernández Jiménez
 */

public class LoginViewImpl extends AppCompatActivity {
    private TextView txvSignUp;
    private Button btnSignIn;
    private EditText edtPassword;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txvSignUp = findViewById(R.id.txvSingUp);
        edtPassword = findViewById(R.id.edtPassword);
        //txvSignUp.setPaintFlags(txvSignUp.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            loginPresenter.validateCredentials(txvSignUp.getText().toString(), edtPassword.getText().toString());
            }
        });
    }

    /*Intent intent = new Intent(LoginViewImpl.this, DashboardActivity.class);
    startActivity(intent);*/
}
