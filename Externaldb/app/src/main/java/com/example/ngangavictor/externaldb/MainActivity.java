package com.example.ngangavictor.externaldb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    EditText fname,lname,age;
   Button insert, show;
    TextView textView;
    RequestQueue requestQueue;
    String insertUrl="http://192.168.43.17/www.android.com/insertStudents.php";
    private final String showUrl="http://192.168.43.17/www.android.com/showStudents.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname=(EditText)findViewById(R.id.editTextFname);
        lname=(EditText)findViewById(R.id.editTextLname);
        age=(EditText)findViewById(R.id.editTextAge);
        insert=(Button)findViewById(R.id.buttonInsert);
        show=(Button)findViewById(R.id.buttonView);
        textView=(TextView)findViewById(R.id.textView);

        requestQueue = Volley.newRequestQueue(getApplicationContext());

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                        showUrl, new Response.Listener<JSONObject>() {
                   // @Override
                  //  public void onResponse(String response) {

                  //  }

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray students = response.getJSONArray("students");
                            for (int i=0;i<students.length();i++){
                                JSONObject student = students.getJSONObject(i);

                                String firstname = student.getString("firstname");
                                String lastname = student.getString("lastname");
                                String age = student.getString("age");

                                textView.append(firstname+" "+lastname+" "+age+"\n");
                            }
                            textView.append("===\n");

                        } catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }

}

