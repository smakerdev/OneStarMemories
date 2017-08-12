package com.example.android.onestarmemories;

/**
 * Created by 10102김동규 on 2017-08-13.
 */

public class ListViewItem {
    private String titleStr ;
    private String descStr ;


    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }


    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
}