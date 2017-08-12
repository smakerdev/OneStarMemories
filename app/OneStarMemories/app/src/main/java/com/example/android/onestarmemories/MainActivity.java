package com.example.android.onestarmemories;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tsengvn.typekit.TypekitContextWrapper;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.main_button).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        Intent intent = new Intent(MainActivity.this, EntryActivity.class);
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

    @Override
    public void onMapReady(final GoogleMap map) {

        LatLng SEOUL = new LatLng(37.56, 126.97);
        map.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        map.animateCamera(CameraUpdateFactory.zoomTo(10));

        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions markerOptions = new MarkerOptions();
                // TODO: 마커 옵션 (아이콘 변경) 별로
//                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_3g));
                markerOptions.position(point); // 마커위치설정
                // TODO: point.longitude, point.latitude
                map.animateCamera(CameraUpdateFactory.newLatLng(point   ));   // 마커생성위치로 이동
                map.addMarker(markerOptions); //마커 생성
            }
        });
    }
}
