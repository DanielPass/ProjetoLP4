package com.steplab.projetolpiv.projetolpiv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RecoverPasswordActivity extends AppCompatActivity {
    private EditText password_EditText;
    private EditText confirmPassword_EditText;
    private Button  changePassword_btn;
    TextView alreadyHaveAccount_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        password_EditText = (EditText) findViewById(R.id.password);
        confirmPassword_EditText = (EditText) findViewById(R.id.confirm_password);
        changePassword_btn = (Button) findViewById(R.id.change_password_btn);

        changePassword_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        alreadyHaveAccount_TextView = (TextView) findViewById(R.id.already_have_account);

        alreadyHaveAccount_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
