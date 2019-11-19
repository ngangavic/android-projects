package com.example.ngangavictor.myschoolapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.List;
import java.util.Map;

//public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    TextView tvClassName;

    private List<ListItem> listItems;
    private List<ListItem> listItems2;
    //192.168.43.17
    private static final String URL_DATA = "http://192.168.43.17/www.android.com/mySchool/mySchoolAppGetResults.php";
    private static final String URL_DATA2 = "http://192.168.43.17/www.android.com/mySchool/mySchoolApp2.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final String s= getIntent().getStringExtra("code");
        Toast.makeText(HomeActivity.this,s,Toast.LENGTH_LONG).show();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        listItems2 = new ArrayList<>();
        //loadRecyclerViewData(s);

        tvClassName = (TextView)findViewById(R.id.textView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.nav_form1){
            final String grade = "1";
            listItems.clear();
            Toast.makeText(HomeActivity.this,s,Toast.LENGTH_LONG).show();
            loadRecyclerViewData(s,grade);
        }else if(id==R.id.nav_form2){
            String grade = "2";
            listItems.clear();
            Toast.makeText(HomeActivity.this,s,Toast.LENGTH_LONG).show();
            loadRecyclerViewData(s, grade);
        }else if (id==R.id.nav_form3){
            String grade = "3";
            listItems.clear();
            Toast.makeText(HomeActivity.this,s,Toast.LENGTH_LONG).show();
            loadRecyclerViewData(s, grade);
        }else if (id==R.id.nav_form4){
            String grade = "4";
            listItems.clear();
            Toast.makeText(HomeActivity.this,s,Toast.LENGTH_LONG).show();
            loadRecyclerViewData(s, grade);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
});


    }


    private void loadRecyclerViewData(final String adm,final String grade) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading data...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray array = jsonObject.getJSONArray("data");
                            JSONArray array1 = jsonObject.getJSONArray("data2");

                            if (array.length() == 1){
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject o = array.getJSONObject(i);
                                    ListItem item = new ListItem(
                                            o.getString("eng"),
                                            o.getString("kis"),
                                            o.getString("mat"),
                                            o.getString("chem"),
                                            o.getString("bio"),
                                            o.getString("phy"),
                                            o.getString("geo"),
                                            o.getString("his"),
                                            o.getString("cre"),
                                            o.getString("agri"),
                                            o.getString("bus"),
                                            o.getString("total")

                                    );
                                    listItems.add(item);
                                }
                                for (int i = 0; i < array1.length(); i++) {
                                    JSONObject o = array.getJSONObject(i);
                                    ListItem item1 = new ListItem(
                                            o.getString("eng"),
                                            o.getString("kis"),
                                            o.getString("mat"),
                                            o.getString("chem"),
                                            o.getString("bio"),
                                            o.getString("phy"),
                                            o.getString("geo"),
                                            o.getString("his"),
                                            o.getString("cre"),
                                            o.getString("agri"),
                                            o.getString("bus"),
                                            o.getString("total")

                                    );
                                    listItems2.add(item1);
                                }
                            adapter = new MyAdapter(listItems,listItems2, getApplicationContext());
                            recyclerView.setAdapter(adapter);
                        }else{
                                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(HomeActivity.this);
                                alertBuilder.setMessage("There was an error while fetching data.\nPlease trying again")
                                        .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                   dialog.cancel();
                                        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                                        drawer.openDrawer(GravityCompat.START);
                                        //return true;
                                    }
                                });
                                alertBuilder.create();
                                alertBuilder.setTitle("Error");
                                alertBuilder.show();

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
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String,String> getParams()throws AuthFailureError {
                Map<String,String>params = new HashMap<>();
                params.put("grade",grade);
                params.put("adm",adm);
                return params;
                //loadRecyclerViewData();
            }
        };
        //RequestHandler.getmInstance(this).addToRequestQueue(stringRequest);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   /* @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
