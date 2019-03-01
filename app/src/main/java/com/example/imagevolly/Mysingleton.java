package com.example.imagevolly;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class Mysingleton {

    private static Mysingleton mysingleton;
    private RequestQueue requestQueue;
    private Context mtx;

    public Mysingleton(Context context) {
        this.mtx = context;
        requestQueue = getRequestQueue();
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mtx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized Mysingleton getInstance(Context context) {
        if (mysingleton == null) {
            mysingleton = new Mysingleton(context);
        }
        return mysingleton;
    }

    public <T> void addRequest(Request<T> request) {

        requestQueue.add(request);
    }
}
