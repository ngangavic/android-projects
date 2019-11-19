package com.example.ngangavictor.preparedstatement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.text);
        loadData();
    }

    public void loadData(){

        String sql = "SELECT * FROM tbl_students";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //192.168.72.254
            //Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.43.17/android", "root", "");
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.72.254/android", "root", "");
            //Connection connection = DBConnect.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while(set.next()) {
                textView.setText(set.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
