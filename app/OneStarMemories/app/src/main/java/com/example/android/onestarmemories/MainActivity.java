package com.example.android.onestarmemories;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tsengvn.typekit.TypekitContextWrapper;

public class MainActivity extends AppCompatActivity {

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
    }

    @Override
    protected void attachBaseContext(Context newBase) {

        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));

    }

}
