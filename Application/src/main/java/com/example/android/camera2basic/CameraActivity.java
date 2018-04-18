/*
 * Copyright 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2basic;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CameraActivity extends Activity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        if (null == savedInstanceState) {

            getFragmentManager().beginTransaction()
                    .replace(R.id.container, Camera2BasicFragment.newInstance())
                    .commit();

        }
        Log.d("XXX", "a");
        // Hello World
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        Log.d("XXX", "b");
        mAdView = (AdView) findViewById(R.id.advert);
        Log.d("XXX", "c");
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        Log.d("XXX", "d");
        mAdView.loadAd(adRequest);
        Log.d("XXX", "e");
        mAdView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                Log.i("Ads","onAdLoaded");
                mAdView.bringToFront();
            }}

        );
    }

}
