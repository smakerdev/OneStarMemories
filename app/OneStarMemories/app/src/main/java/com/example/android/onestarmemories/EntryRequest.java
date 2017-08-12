package com.example.android.onestarmemories;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by unidev on 2017. 8. 13..
 */

public class EntryRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://esplay.xyz:21214/api/entry";
    private Map<String, String> params;

    public EntryRequest(String title, String content, String nickname, double lng, double lat, Response.Listener<String> listener){
        super(Request.Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("title", title);
        params.put("content", content);
        params.put("nickname", nickname);
        params.put("lng", String.valueOf(lng));
        params.put("lat", String.valueOf(lat));
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
