package com.example.ngangavictor.loadimages;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements Runnable,OnClickListener{
    private Handler handler = new Handler();
    public Bitmap downloadedBitmap;
    private Button btn_download;
    private ImageView img_downloaded;
    private ProgressDialog dialog;
    private String[] filepath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setTitle("Downloading Image");
        dialog.setCancelable(false);
        dialog.setIndeterminate(true);

        btn_download = (Button) findViewById(R.id.btn_download);
        img_downloaded = (ImageView) findViewById(R.id.img_downloaded);

        btn_download.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        dialog.show();
        new Thread(this).start();
    }

    //This method is responsible for downloading the image from a remote location
    private Bitmap DownloadBMP(String url) throws IOException {
        URL location = new URL(url);
        filepath = location.getFile().split("\u002F");
        dialog.setMessage("Downloading " + filepath[filepath.length-1]);
        InputStream input_s = location.openStream();
        Bitmap returnedBMP = BitmapFactory.decodeStream(input_s);
        input_s.close();
        return returnedBMP;
    }


    //this method must be overridden, as we are implementing the Runnable interface
    @Override
    public void run() {
        try
        {
            downloadedBitmap = DownloadBMP("https://imageshack.com/a/img291/426/bricks.gif ");
        }
        catch (IOException e)
        {
            downloadedBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.imagenotfound);
        }
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                img_downloaded.setImageBitmap(downloadedBitmap);
                dialog.dismiss();
            }
        });
    }


}
