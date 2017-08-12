package com.example.android.onestarmemories;

import android.app.Application;
import com.tsengvn.typekit.Typekit;

/**
 * Created by 10102김동규 on 2017-08-13.
 */

public class ApplicationBase extends Application {
    @Override public void onCreate() {
        super.onCreate();
        // 폰트 정의
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "BMYEONSUNG_ttf.ttf"))
                .addBold(Typekit.createFromAsset(this, "BMYEONSUNG_ttf.ttf"));
    }
}