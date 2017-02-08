package com.example.arodr.databasecomm;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by arodr on 2017-02-04.
 */

public class SQL extends AsyncTask<URL, Integer, String>
{
    public MainActivity activity;

    public SQL(MainActivity a, int Action, int ID)
    {
        this.activity = a;
    }

    @Override
    protected String doInBackground(URL... urls)
    {
        System.out.println("Running");
        StringBuilder result = new StringBuilder();

        try
        {
            HttpURLConnection urlConnection = (HttpURLConnection) urls[0].openConnection();
            try
            {
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = reader.readLine()) != null)
                {
                    result.append(line);
                }
            }
            catch (IOException e)
            {

            }
            finally
            {
                urlConnection.disconnect();
            }
        }
        catch (IOException e)
        {

        }
        return result.toString();
    }

    @Override
    protected void onPreExecute()
    {
        System.out.println("Pre running");
    }

    @Override
    protected void onPostExecute(String result)
    {
        try
        {
            JSONObject parser = new JSONObject(result);
            activity.setName(parser.getString("Name"));
            activity.setLocation(parser.getString("Location"));
        }
        catch(JSONException e)
        {

        }
        System.out.println("Finished running");
        System.out.println(result);
    }
}
