package com.example.ngangavictor.youtubemysql;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextFname,editTextLname,editTextAge;
    private Button insert, show;
    TextView textView;
    RequestQueue requestQueue;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFname=(EditText)findViewById(R.id.editTextFname);
        editTextLname=(EditText)findViewById(R.id.editTextLname);
        editTextAge=(EditText)findViewById(R.id.editTextAge);
        insert=(Button)findViewById(R.id.buttonInsert);
        show=(Button)findViewById(R.id.buttonView);
        textView=(TextView)findViewById(R.id.textView);

        //requestQueue = Volley.newRequestQueue(getApplicationContext());

        progressDialog = new ProgressDialog(this);
        insert.setOnClickListener(this);
    }

    public void clearEditText(){
        editTextAge.getText().clear();
        editTextFname.getText().clear();
        editTextLname.getText().clear();
    }

    @Override
    public void onClick(View v) {
        if (v==insert){
            insertData();
        }
    }

    private void insertData() {
        final String firstname = editTextFname.getText().toString().trim();
        final String lastname = editTextLname.getText().toString().trim();
        final String age = editTextAge.getText().toString().trim();

        progressDialog.setMessage("Inserting data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.insertUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        clearEditText();
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                            //Toast.makeText(MainActivity.this,"Data inserted successfully",Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.hide();
                clearEditText();
                Toast.makeText(MainActivity.this,"An error occurred",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params =new HashMap<>();
                params.put("firstname",firstname);
                params.put("lastname",lastname);
                params.put("age",age);
                return params;
            }
        };

       // RequestQueue requestQueue =Volley.newRequestQueue(this);
        //requestQueue.add(stringRequest);

        RequestHandler.getmInstance(this).addToRequestQueue(stringRequest);

    }

    public void clickUpdate(View view){
        Intent intent = new Intent(MainActivity.this,UpdateActivity.class);
        startActivity(intent);
    }
}
