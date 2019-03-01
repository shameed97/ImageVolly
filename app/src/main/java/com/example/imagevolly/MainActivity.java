package com.example.imagevolly;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    private ImageView image_view;
    private String url = "http://shameed.000webhostapp.com/Shagul.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_view = findViewById(R.id.img_data);


    }

    public void getImage(View view) {

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                image_view.setImageBitmap(response);


            }
        }, 0, 0, ImageView.ScaleType.CENTER, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error in Connection", Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        Mysingleton.getInstance(getApplicationContext()).addRequest(imageRequest);
    }
}
