package com.example.ngangavictor.sschool;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

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

    /*public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }*/

    public <T> void addToRequestQueue(StringRequest req){
        getRequestQueue().add(req);
    }

}