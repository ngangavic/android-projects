package com.example.ngangavictor.youtubemysql;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UpdateActivity extends AppCompatActivity {
    EditText id,fname,lname,age;
    Button update;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        id = (EditText)findViewById(R.id.editTextId);
        fname = (EditText)findViewById(R.id.editTextFname);
        lname = (EditText)findViewById(R.id.editTextLname);
        age = (EditText)findViewById(R.id.editTextAge);
        update = (Button)findViewById(R.id.btn_update);

        progressDialog = new ProgressDialog(this);
        //update.setOnClickListener(this);
    }

    public void clearEditText(){
        id.getText().clear();
        fname.getText().clear();
        lname.getText().clear();
        age.getText().clear();
    }

    public void clickUpdate(View view){
        final String ID = id.getText().toString().trim();
        final String FIRSTNAME = fname.getText().toString().trim();
        final String LASTNAME = lname.getText().toString().trim();
        final String AGE = age.getText().toString().trim();

        progressDialog.setMessage("Updating...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constants.updateUrl, new Response.Listener<String>() {
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
                Toast.makeText(UpdateActivity.this,"An error occurred",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
        protected Map<String,String> getParams()throws AuthFailureError{
                Map<String,String>params = new HashMap<>();
                params.put("id",ID);
                params.put("firstname",FIRSTNAME);
                params.put("lastname",LASTNAME);
                params.put("age",AGE);
                return params;
            }
        };
        RequestHandler.getmInstance(this).addToRequestQueue(stringRequest);
    }
}
