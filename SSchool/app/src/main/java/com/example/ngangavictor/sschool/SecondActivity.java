package com.example.ngangavictor.sschool;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;
    //192.168.43.17
    private static final String URL_DATA = "http://192.168.43.17/www.android.com/sschool/loadData.php";
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        //loadRecyclerViewData();
        String id = "1";
        loadRecyclerViewData(id);
        //filterData(id);
    }


    private void filterData(final String id){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                    //Toast.makeText(MainActivity.this,"Data inserted successfully",Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //progressDialog.hide();
                //clearEditText();
                Toast.makeText(SecondActivity.this,"An error occurred",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String,String> getParams()throws AuthFailureError {
                Map<String,String>params = new HashMap<>();
                params.put("id",id);
                return params;
                //loadRecyclerViewData();
            }
        };
        //loadRecyclerViewData();
        RequestHandler.getmInstance(this).addToRequestQueue(stringRequest);

    }

    private void loadRecyclerViewData(final String id) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            /*HashMap<String,String > params = new HashMap<>();
                            params.put("id", id);
                            PerformNetworkRequest request = new PerformNetworkRequest(URL_DATA, params,CODE_POST_REQUEST);
                            request.execute();*/
                            JSONObject jsonObject = new JSONObject(response);
                            //jsonObject.put("id",id);
                            JSONArray array = jsonObject.getJSONArray("data");

                            for (int i=0;i<array.length();i++){
                                JSONObject o = array.getJSONObject(i);
                                //o.put("id",id);
                                ListItem item = new ListItem(
                                        //o.put(id,"id"),
                                        o.getString("eng"),
                                        o.getString("kis"),
                                        o.getString("mat"),
                                        o.getString("sci"),
                                        o.getString("ssre")
                                );
                                listItems.add(item);
                            }
                            adapter = new MyAdapter(listItems,getApplicationContext());
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String,String> getParams()throws AuthFailureError{
                Map<String,String>params = new HashMap<>();
                params.put("id",id);
                return params;
                //loadRecyclerViewData();
            }
        };
       // RequestHandler.getmInstance(this).addToRequestQueue(stringRequest);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private class PerformNetworkRequest extends AsyncTask<Void , Void,String> {
        String url;
        HashMap<String ,String> params;
        int  requestCode;

        PerformNetworkRequest(String url, HashMap<String , String > params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }
        @ Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progressBar.setVisibility(View.VISIBLE);
        }
        @ Override
        protected void onPostExecute(String  s) {
            super.onPostExecute(s);
//            progressBar.setVisibility(GONE);
            /*try {
                JSONObject object = new  JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(context,object.getString("message"),Toast.LENGTH_LONG).show();
                    //refreshHeroList(object.getJSONArray("heroes"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
        }

        @ Override
        protected String doInBackground(Void ... voids) {
            RequestHandler2 requestHandler2 = new  RequestHandler2();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler2.sendPostRequest(url, params);

            if (requestCode == CODE_GET_REQUEST)
                return requestHandler2.sendGetRequest(url);

            return null;
        }
    }
}
