package com.example.ngangavictor.downloadimage;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    String path= "https://style.pk/wp-content/uploads/2015/07/omer-Shahzad-performed-umrah-600x548.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadImageFromPath(path);
            }
        });

        Button download_image = (Button)findViewById(R.id.button);
        download_image.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                ContextWrapper cw = new ContextWrapper(MainActivity.this);
                // path to /data/data/yourapp/app_data/imageDir
                File directory = cw.getDir("files", Context.MODE_PRIVATE);

                File myDir = new File(directory,"myApp");
                //boolean success = (new File("/sdcard/dirname")).mkdir();
                boolean success = (new File("/myApp")).mkdir();
                //if (!success)
                if (!myDir.exists())
                {
                    myDir.mkdir();
                    Log.w("directory not created", "directory not created");
                    Toast.makeText(MainActivity.this,"Directory not created",Toast.LENGTH_LONG).show();
                }

                try
                {
                    //URL url = new URL("YOUR_URL");
                    //URL url = new URL("https://style.pk/wp-content/uploads/2015/07/omer-Shahzad-performed-umrah-600x548.jpg");
                    URL url = new URL("http://192.168.43.17/www.android.com/greenApp/gallery/1.jpg");
                    //URLConnection url = new URLConnection("http://192.168.43.17/www.android.com/greenApp/gallery/1.jpg");
                    //HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(15000);
                    connection.setConnectTimeout(15000);
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.getPermission();
                    //connection.connect();
                    InputStream input = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    Bitmap myBitmap = BitmapFactory.decodeStream(input);
                    //Bitmap myBitmap = BitmapFactory.decodeStream(bufferedReader);

                    //String data1 = String.valueOf(String.format("/sdcard/dirname/%d.jpg",System.currentTimeMillis()));
                    String data1 = String.valueOf(String.format("/myApp/%d.jpg",System.currentTimeMillis()));

                    FileOutputStream stream = new FileOutputStream(data1);

                    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
                    myBitmap.compress(Bitmap.CompressFormat.JPEG, 85, outstream);
                    byte[] byteArray = outstream.toByteArray();

                    stream.write(byteArray);
                    stream.close();

                    Toast.makeText(getApplicationContext(), "Downloading Completed", Toast.LENGTH_SHORT).show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }

    public void DownloadImageFromPath(String path){
        InputStream in =null;
        Bitmap bmp=null;
        //ImageView iv = (ImageView)findViewById(R.id.);
        int responseCode = -1;
        try{

            URL url = new URL(path);//"http://192.xx.xx.xx/mypath/img1.jpg
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setDoInput(true);
            con.connect();
            responseCode = con.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK)
            {
                //download
                in = con.getInputStream();
                bmp = BitmapFactory.decodeStream(in);
                in.close();
              //  iv.setImageBitmap(bmp);
            }

        }
        catch(Exception ex){
            Log.e("Exception",ex.toString());
        }
    }

    /*public void DownloadImage(){

        try {

            URL url;

            // String Builder object to store the message retrieved from the server
            StringBuilder sb = new StringBuilder();
            url = new URL(requestURL);

            // Creating an httmlurl connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Configuring connection properties
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            // Creating an output stream
            OutputStream os = conn.getOutputStream();

            //Bitmap myBitmap = BitmapFactory.decodeStream(input);
            // Writing parameters to the request
            // We are using a method get Post Data String which is defined below
           // BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            //writer.write(getPostDataString(postDataParams));

            //writer.flush();
           //writer.close();
            os.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }*/
}
