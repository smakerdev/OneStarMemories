package com.example.android.onestarmemories;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by 10102김동규 on 2017-08-13.
 */

public class AreaListActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_list);

        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.area_list);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(
                "깔까리", "깔까리 따땃하네~") ;
        // 두 번째 아이템 추가.
        adapter.addItem(
                "날나리", "마 니 좀 자신있나?") ;
        // 세 번째 아이템 추가.
        adapter.addItem(
                "딸따리", "마 니 좀 치나?") ;
        // 네 번째 아이템 추가.
        adapter.addItem(
                "랄라리", "랄라리라라 라리랄리라라~") ;
    }

}
