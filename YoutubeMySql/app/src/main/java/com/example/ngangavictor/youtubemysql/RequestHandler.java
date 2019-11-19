package com.example.ngangavictor.youtubemysql;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestHandler {

    private static RequestHandler mInstance;
    private RequestQueue mrequestQueue;
    private static Context mcontext;

    private RequestHandler(Context context){
        mcontext = context;
        mrequestQueue = getRequestQueue();
    }

    public static synchronized RequestHandler getmInstance(Context context){
        if (mInstance ==null){
            mInstance = new RequestHandler(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if (mrequestQueue ==null){
            mrequestQueue = Volley.newRequestQueue(mcontext.getApplicationContext());
        }
        return mrequestQueue;
    }

    public <T> void addToRequestQueue(Request<T>req){
        getRequestQueue().add(req);
    }

}
