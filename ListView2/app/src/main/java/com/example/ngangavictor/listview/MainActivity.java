package com.example.ngangavictor.listview;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends ListActivity {
//AppCompatActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter(
                this,android.R.layout.simple_list_item_1,
                this.populate()));
    }
    private ArrayList populate(){
        ArrayList items = new ArrayList();

        try{
            URL url = new URL("http://www.ece301.com/food.php");
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String next;
            while ((next = bufferedReader.readLine())!=null){
                JSONArray ja = new JSONArray(next);
                for (int i=0;i < ja.length();i++){
                    JSONObject o = (JSONObject)ja.get(i);
                    items.add(o.getString("arrayName"));
                }
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }
}
