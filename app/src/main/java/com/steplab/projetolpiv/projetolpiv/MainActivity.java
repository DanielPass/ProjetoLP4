package com.steplab.projetolpiv.projetolpiv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Utils.Database;

public class MainActivity extends AppCompatActivity {

    Database db = new Database(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(db.recoverToken() == null || db.recoverToken().equals(""))) {
            setContentView(R.layout.activity_initial);
        }else{
            setContentView(R.layout.activity_initial);
        }
    }
}
