package com.example.android.onestarmemories;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.main_button).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(intent);
                    }
                }
        );


        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));

    }

    public void makeMarker(GoogleMap map, LatLng pos, String title, String content) {
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(pos);
        markerOptions2.title(title);
        markerOptions2.snippet(content);
        map.addMarker(markerOptions2);
    }

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng SEOUL = new LatLng(37.56, 126.97);
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));

        final String url = "http://esplay.xyz:21214/api/list/entry";
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response
                        Log.d("Response", response.toString());
                        JSONObject result;
                        String title[] = new String[response.length()];
                        String content[] = new String[response.length()];
                        String nickname[] = new String[response.length()];
                        double lng[] = new double[response.length()];
                        double lat[] = new double[response.length()];

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                result = response.getJSONArray("result").getJSONObject(i);
                                title[i] = result.getString("title");
                                content[i] = result.getString("content");
                                nickname[i] = result.getString("nickname");
                                lng[i] = result.getDouble("lng");
                                lat[i] = result.getDouble("lat");
                            }

                            for (int i = 0; i < response.length(); i++) {
                                LatLng pos = new LatLng(lng[i], lat[i]);
                                makeMarker(map, pos, title[i], content[i]);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

        queue.add(getRequest);



        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions markerOptions = new MarkerOptions();
                // TODO: 마커 옵션 (아이콘 변경) 별로
//                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_3g));
                markerOptions.position(point); // 마커위치설정
                System.out.println(point.latitude + " " + point.longitude);

                intent = new Intent(getApplicationContext(), EntryActivity.class);
                intent.putExtra("lng", point.longitude);
                intent.putExtra("lat", point.latitude);



                // TODO: point.longitude, point.latitude
                map.animateCamera(CameraUpdateFactory.newLatLng(point));   // 마커생성위치로 이동
                map.addMarker(markerOptions); //마커 생성
            }
        });
    }
}
