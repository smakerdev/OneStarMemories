package com.example.android.onestarmemories;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.tsengvn.typekit.TypekitContextWrapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;


/**
 * Created by 10102김동규 on 2017-08-13.
 */

public class EntryActivity extends AppCompatActivity {

    EditText title;
    EditText content;
    Button button;

    Double lng;
    Double lat;
    String result_title;
    String result_content;


//    public static final Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://esplay.xyz:21214/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();

//    NetworkService service = retrofit.create(NetworkService.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);

        title = (EditText) findViewById(R.id.title);
        content = (EditText) findViewById(R.id.content);
        button = (Button) findViewById(R.id.entry_button);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.entry_button).setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        //여기에 이벤트를 적어주세요
                        finish();
                    }
                }
        );

        Intent intent = getIntent();
        lng = intent.getExtras().getDouble("lng");
        lat = intent.getExtras().getDouble("lat");


        System.out.println(lng + " " + lat);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                result_title = title.getText().toString();
                result_content = content.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
//                        try{
////                            JSONObject jsonResponse = new JSONObject(response);
////                            boolean success = jsonResponse.getBoolean("success");
////                            String reason = jsonResponse.getString("reason");
//                        } catch(JSONException e){
//                            e.printStackTrace();
//                        }
                    }
                };

                EntryRequest entryRequest = new EntryRequest(result_title, result_content, "작성자", lng, lat, responseListener);
                RequestQueue queue = Volley.newRequestQueue(EntryActivity.this);
                queue.add(entryRequest);

//                String result = null;
//
//                try {
//                     result = call.execute().body().toString();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(result);
            }
        });
    }


    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));

    }
}
