package com.example.user;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mateuspalhares on 24/03/15.
 */
public class DisplayImageActivity extends Activity {
    Button btnDelete;
    ImageView imageDetail;
    int imageId;
    Bitmap theImage;
    TextView place;
    TextView desc;
    String lat,lon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        imageDetail = (ImageView) findViewById(R.id.imageView1);
        place = (TextView) findViewById(R.id.txtPlace);
        desc = (TextView) findViewById(R.id.txtDescription);
        /**
         * getting intent data from search and previous screen
         */
        Intent intnt = getIntent();

        place.setText(intnt.getStringExtra("imageplace"));
        desc.setText(intnt.getStringExtra("imagedesc"));
        theImage = (Bitmap) intnt.getParcelableExtra("imagename");
        imageId = intnt.getIntExtra("imageid", 20);
        lat = intnt.getStringExtra("imagelat");
        lon = intnt.getStringExtra("imagelon");
        Log.d("Image ID:****", String.valueOf(imageId));
        imageDetail.setImageBitmap(theImage);
        btnDelete.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                /**
                 * create DatabaseHandler object
                 */
                DataBaseHandler db = new DataBaseHandler(
                        DisplayImageActivity.this);
                /**
                 * Deleting records from database
                 */
                Log.d("Delete Image: ", "Deleting.....");
                db.deleteContact(new Contact(imageId));
                // /after deleting data go to main page
                Intent i = new Intent(DisplayImageActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        place.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayImageActivity.this,
                        MapsActivity.class);
                lat = "53.3292";
                lon = "-6.2661";
                i.putExtra("latitude",lat);
                i.putExtra("longitude",lon);
                startActivity(i);
            }
        });

    }
}