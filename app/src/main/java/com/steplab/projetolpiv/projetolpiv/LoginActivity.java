package com.steplab.projetolpiv.projetolpiv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.util.ArrayList;
import java.util.List;

import Model.LoginAnswer;
import Utils.Database;
import Utils.WebServiceUtil;
import WebService.IWebService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private LoginAnswer answer;
    private static final String ERRO = "Erro: ";
    private static final String INFO = "INFO: ";
    public Database db = new Database(this);
    public WebServiceUtil web;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if ((db.recoverToken() == null && db.recoverToken().equals(""))){
            Intent it = new Intent(this, NewProductActivity.class);
            startActivity(it);
        }
        setContentView(R.layout.activity_login);
    }

    public void Login(View v){

        TextView textViewemail = (TextView) findViewById(R.id.email);
        TextView textViewpassword = (TextView) findViewById(R.id.password);
        web = new WebServiceUtil();

        String email = textViewemail.getText().toString();
        String password = textViewpassword.getText().toString();

        answer = new LoginAnswer();

        if(db.recoverToken() == null && db.recoverToken().equals("")){
            Intent it = new Intent(this, NewProductActivity.class);
            startActivity(it);
            return;
        }

        try{
            IWebService service = web.getiWebService();

            Call<LoginAnswer> requestLogin = service.login(email,password);

            requestLogin.enqueue(new Callback<LoginAnswer>() {
                @Override
                public void onResponse(Call<LoginAnswer> call, Response<LoginAnswer> response) {
                    if (!response.isSuccessful()){
                        answer = response.body();
                        Toast.makeText(LoginActivity.this, "Erro: " + answer.getMessage(), Toast.LENGTH_SHORT).show();
                    }else{
                        answer = response.body();

                        if (answer.getToken() == null)
                            Toast.makeText(LoginActivity.this,"An error has ocurred: " +answer.getMessage(), Toast.LENGTH_SHORT).show();
                        else
                            loginsucefull(answer);
                    }
                }
                @Override
                public void onFailure(Call<LoginAnswer> call, Throwable t) {
                    Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception ex){
            Toast.makeText(LoginActivity.this,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void loginsucefull(LoginAnswer answer) {
        try{
            db.saveToken(answer);
            Intent it = new Intent(this, NewProductActivity.class);
            startActivity(it);
        }catch (Exception ex){
            Toast.makeText(LoginActivity.this,ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

