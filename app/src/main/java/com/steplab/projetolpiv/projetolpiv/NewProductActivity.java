package com.steplab.projetolpiv.projetolpiv;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.*;

import Model.LoginAnswer;
import Model.NewItemAnswer;
import Utils.WebServiceUtil;
import WebService.IWebService;
import retrofit2.Call;

/**
 * Created by Alexsander on 08/10/2017.
 */

public class NewProductActivity extends AppCompatActivity {

    Bitmap bitmap;
    ImageView img;
    NewItemAnswer answer;
    WebServiceUtil web;
    static final int REQUEST_LOCATION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        web = new WebServiceUtil();

        img = (ImageView) findViewById(R.id.photo);
    }

    public void TirarFoto(View v) {
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(it, 0);
    }

    public void SalvarProduto(View v) {
        Bitmap photo = null;
        img = (ImageView) findViewById(R.id.photo);
        EditText nome = (EditText) findViewById(R.id.item_name);
        EditText descricao = (EditText) findViewById(R.id.description_item);
        RadioButton fruta = (RadioButton) findViewById(R.id.Fruit);
        RadioButton tree = (RadioButton) findViewById(R.id.Tree);


        String photos;
        String name = nome.getText().toString();
        String description = descricao.getText().toString();
        String latitude;
        String longitude;
        int type;

        if (fruta.isChecked()) {
            type = 0;
        } else {
            type = 1;
        }

        photos = ConverterToBase64(photo);

        latitude = getLatitude();
        longitude = getLongitude();



    }


    private String getLatitude() {

        LocationManager loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }

        Location location = loc.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        Double latitude = location.getLatitude();

        return latitude.toString();

    }

    private String getLongitude() {
        LocationManager loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        loc = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }

        Location location = loc.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        Double longitude = location.getLongitude();

        return longitude.toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        InputStream stream = null;

        if (requestCode == 0 && resultCode == RESULT_OK){

            try {
                if (bitmap != null)
                    bitmap.recycle();

                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);
                img.setImageBitmap(bitmap);
            }catch (FileNotFoundException ex){
                Toast.makeText(this, ex.getMessage(),Toast.LENGTH_SHORT);
            }finally {
                if (stream != null){
                    try {
                        stream.close();
                    }catch (IOException ex){
                        Toast.makeText(this, ex.getMessage(),Toast.LENGTH_SHORT);
                    }
                }
            }

        }
    }

    public String ConverterToBase64(Bitmap photo){
        String TAG = "GG";
        try {
            BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
            photo = drawable.getBitmap();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG,100,bos);
            byte[] bb = bos.toByteArray();
            return Base64.encodeToString(bb,0);
        }catch (Exception ex){
            Log.e(TAG, "ConverterToBase64: " + ex.getMessage());
        }
        return "";
    }
}
