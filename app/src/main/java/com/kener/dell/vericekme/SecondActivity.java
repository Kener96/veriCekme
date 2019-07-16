package com.kener.dell.vericekme;
import android.os.AsyncTask;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    ListView listview1;
    String url="http://demo.avasistem.xyz:9122/api/Test";
    Text txt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);


        txt1 =(Text) findViewById(R.id.text);
        listview1=(ListView)findViewById(R.id.listview1);


        StringRequest request = new StringRequest(Request.Method.POST ,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                string=string.replace('"',' ').trim();
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();

            }
        });


        RequestQueue rQueue = Volley.newRequestQueue(SecondActivity.this);
        rQueue.add(request);
    }



    void parseJsonData(String jsonString){
        try{
            Gson gson=new Gson();
            jsonString=jsonString.replace('"',' ').trim();
            cities cities=gson.fromJson(jsonString, com.kener.dell.vericekme.cities.class);
            ArrayList<String>dizi=new ArrayList<String>();
            if (cities!=null)
            {
                for(int i=0;i<cities.getData().size()-1;i++){
                    dizi.add(cities.getData().get(i).getIdn()+"     "+cities.getData().get(i).getCity()+"       "+cities.getData().get(i).getTemp());

                    //JSONObject obj=citysArray.getJSONObject(i);
                    //dizi[i] =obj.getString(citysArray.getJSONObject());
                    //dizi[i] =obj.getString("idn");
                    //dizi[i] +="       "+obj.getString("city");
                }
            }

            //JSONObject object=new JSONObject(jsonString);
            //JSONArray citysArray=object.getJSONArray("citylist");


        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,dizi);
        listview1.setAdapter(adapter);
        }catch(Exception e){
        e.printStackTrace();
        }

    }
}









