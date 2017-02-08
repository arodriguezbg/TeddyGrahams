package com.example.arodr.databasecomm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity
{
    private String str_Name;
    private String str_Location;
    private String str_ID;

    private TextView lbl_Name;
    private TextView lbl_Location;
    private TextView txb_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.str_Name = "Name Set";
        this.str_Location = "Location Set";

        lbl_Name      = (TextView)findViewById(R.id.lbl_Name);
        lbl_Location  = (TextView)findViewById(R.id.lbl_Location);
        txb_ID        = (TextView)findViewById(R.id.txt_ID);
    }

    /*
    GUI Functions
     */

    public void btn_Query_OnClick(View view)
    {


        str_ID = txb_ID.getText().toString();

        try
        {
            getItemByID(1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }

    /*
    Query Functions
     */
    public void getItemByID(int ID) throws Exception
    {
        URL url = new URL("http://www.r2navita.com/android/insertGetEditDelete.php?ID=" + str_ID);
        new SQL(this,1,1).execute(url);
    }

    /*
    Get Set Functions
     */

    public String getName()
    {
        return this.str_Name;
    }

    public void setName(String str_Name)
    {
        this.str_Name = str_Name;
        lbl_Name.setText(this.str_Name);
    }

    public String getLocation()
    {
        return this.str_Location;
    }

    public void setLocation(String str_Location)
    {
        this.str_Location = str_Location;
        lbl_Location.setText(this.str_Location);
    }
}
