package com.example.ngangavictor.myschoolapp;

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

public class RegisterActivity extends AppCompatActivity {
    EditText EtEmail,EtPhone,EtAdm,EtPassword;
    Button btnLogin,btnReg;
    String URL = "http://192.168.43.17/www.android.com/mySchool/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EtEmail = (EditText)findViewById(R.id.editTextEmail);
        EtPhone = (EditText)findViewById(R.id.editTextPhone);
        EtAdm = (EditText)findViewById(R.id.editTextAdm);
        EtPassword = (EditText)findViewById(R.id.editTextPassword);
        btnLogin = (Button)findViewById(R.id.buttonLogin);
        btnReg = (Button)findViewById(R.id.buttonReg);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void login(){
        clearEditText();
        Intent intentLogin = new Intent(RegisterActivity.this,MainActivity.class);
        startActivity(intentLogin);
    }

    private void clearEditText(){
        EtEmail.getText().clear();
        EtPhone.getText().clear();
        EtAdm.getText().clear();
        EtPassword.getText().clear();
    }

    private void register(){
        final String email = EtEmail.getText().toString().trim();
        final String phone = EtPhone.getText().toString().trim();
        final String adm = EtAdm.getText().toString().trim();
        final String password = EtPassword.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                clearEditText();
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    String info = jsonObject.getString("report");
                    Toast.makeText(RegisterActivity.this,info,Toast.LENGTH_LONG).show();
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                error.printStackTrace();
                Toast.makeText(RegisterActivity.this,"Connection lost",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
        protected Map<String,String> getParams()throws AuthFailureError{
                Map<String,String>params = new HashMap<>();
                params.put("email",email);
                params.put("phone",phone);
                params.put("adm",adm);
                params.put("password", password);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        //RequestHandler.getmInstance(this).addToRequestQueue(stringRequest);
    }
}
