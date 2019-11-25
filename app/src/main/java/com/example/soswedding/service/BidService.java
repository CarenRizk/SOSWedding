package com.example.soswedding.service;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.soswedding.Interface.VolleyCallback;
import com.example.soswedding.model.Singleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class BidService {
    public static void postBid(Context context, final String amount, final long requestID, final VolleyCallback callback) {
        String url = "https://soswedding.herokuapp.com/request/"+ requestID+"/bid";
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("amount", Double.parseDouble(amount));
            jsonBody.put("Message", "Hello WORLD REMIND HAMPIC TO CHANG THIS");
            jsonBody.put("status", "PENDING");
            jsonBody.put("userId", Singleton.getInstance().getId());
            jsonBody.put("requestId", requestID);

            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url,jsonBody, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.e("VOLLEY", response.toString());
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String,String> headers = new HashMap<String,String>();
                    headers.put("Content-Type", "application/json");
                    return headers;
                }


            };

            requestQueue.add(stringRequest);
        }
     catch( JSONException e)
    {
        e.printStackTrace();
    }

}
}