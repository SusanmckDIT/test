package com.example.user;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;

/**
 * Created by mateuspalhares on 26/03/15.
 */
public class SetPhotoActivity extends Activity{
    Intent intent;
    EditText place;
    EditText description;
    Button save;
    Bitmap image;
    DataBaseHandler db;
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    LocationManager locationManager;
    LocationFinder locationFinder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_photo);
        place = (EditText) findViewById(R.id.editPlace);
        description = (EditText) findViewById(R.id.editDescription);
        save = (Button) findViewById(R.id.savePhoto);
        intent = getIntent();
        image = (Bitmap) intent.getParcelableExtra("image");
        image.compress(Bitmap.CompressFormat.PNG, 100, stream);

        db = new DataBaseHandler(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationFinder = new LocationFinder(locationManager);
        Log.i("Latitude",String.valueOf(locationFinder.getLatitude()));

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.addContact(new Contact(place.getText().toString(),stream.toByteArray(),
                              description.getText().toString(),locationFinder.getLatitude(),
                              locationFinder.getLongitude() ));

                Log.i("Place",place.getText().toString());
                db.close();
                Intent i = new Intent(SetPhotoActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}