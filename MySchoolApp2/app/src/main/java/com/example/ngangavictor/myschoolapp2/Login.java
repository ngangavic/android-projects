package com.example.ngangavictor.myschoolapp2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Login extends AppCompatActivity {
    EditText adm,password;
    Button btLogin,btRegister;
    String URL = "http://192.168.43.17/www.android.com/mySchool/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        adm = (EditText)findViewById(R.id.editTextAdm);
        password = (EditText)findViewById(R.id.editTextPassword);
        btLogin = (Button)findViewById(R.id.buttonLogin);
        btRegister = (Button)findViewById(R.id.buttonReg);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login(){
        final String admission = adm.getText().toString();
        final String passcode = password.getText().toString();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String info = jsonObject.getString("report");
                            if (info.equals("1")){
                                clearEditText();
                                Intent myintent=new Intent(Login.this, MainActivity.class).putExtra("code", info.toString());
                                startActivity(myintent);
                            }else{
                                Toast.makeText(Login.this, "You entered wrong credentials", Toast.LENGTH_LONG).show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String,String> getParams()throws AuthFailureError {
                Map<String,String>params = new HashMap<>();
                params.put("adm",admission);
                params.put("pass",passcode);
                return params;
            }
        };
        // RequestHandler.getmInstance(this).addToRequestQueue(stringRequest);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void clearEditText(){
        adm.getText().clear();
        password.getText().clear();
    }
}
