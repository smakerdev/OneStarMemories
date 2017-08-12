package com.example.android.onestarmemories;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tsengvn.typekit.TypekitContextWrapper;

/**
 * Created by 10102김동규 on 2017-08-13.
 */

public class EntryActivity extends AppCompatActivity {

    EditText title;
    EditText content;
    Button button;
    Double lng;
    Double lat;

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
                String result_title = title.getText().toString();
                String result_content = content.getText().toString();

            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));

    }
}
