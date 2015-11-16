package com.example.utkarsh.mess.app;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ExpandableListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends ActionBarActivity {

    MyCustomExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;

    private ExpandableListView expandableListView;
    private Object error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // get the listview
        // expListView = (ExpandableListView) findViewById(R.id.lvExp);
        expandableListView = (ExpandableListView) findViewById(R.id.lvExp);
        // expandableListView.setIndicatorBounds(display.getWidth()-GetDipsFromPixel(40), display.getWidth()-5);
        // preparing list data
        prepareListData();

        listAdapter = new MyCustomExpandableListAdapter(this, listDataHeader, expandableListView);

        // setting list adapter
        expandableListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://www.google.com";
        // Request a string response from the provided URL.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
for(int i=0;i<jsonArray.length();i++)
{
    //if today
    /*for (int i = 0; i < recs.length(); ++i) {
    JSONObject rec = recs.getJSONObject(i);
    int id = rec.getInt("id");
    String loc = rec.getString("loc");
    // ...
}*/
}
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                }
        );
        // Adding child data
        queue.add(jsonArrayRequest);
    }

}


