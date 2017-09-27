package com.steplab.projetolpiv.projetolpiv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewAccountActivity extends AppCompatActivity {

    EditText login_EditText;
    EditText password_EditText;
    EditText confirmPassword_EditText;
    EditText email_EditText;
    EditText confirmEmail_EditText;
    EditText phoneNumber_EditText;
    EditText birthDate_EditText;
    Button   registry_Button;
    TextView alreadyHaveAccount_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        login_EditText = (EditText) findViewById(R.id.login);
        password_EditText = (EditText) findViewById(R.id.password);
        confirmPassword_EditText = (EditText) findViewById(R.id.confirm_password);
        email_EditText = (EditText) findViewById(R.id.email);
        confirmEmail_EditText = (EditText) findViewById(R.id.confirm_password);
        phoneNumber_EditText = (EditText) findViewById(R.id.phone_number);
        birthDate_EditText = (EditText) findViewById(R.id.birth_date);
        registry_Button = (Button) findViewById(R.id.registry_btn);
        alreadyHaveAccount_TextView = (TextView) findViewById(R.id.already_have_account);

        registry_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        alreadyHaveAccount_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
