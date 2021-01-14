package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
        // 음악 재생을 위한 객체
        MediaPlayer mp;

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        // 서비스에서 가장 먼저 호출됨(최초에 한번만)
        @Override
        public void onCreate() {
            super.onCreate();
            Log.d("test", "Service onCreate");
            mp = MediaPlayer.create(this, R.raw.song);
            mp.setLooping(true); // 반복재생
        }

         // onStartCommand : 서비스가 호출될 때마다 실행
        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            Log.d("test", "Service onStartCommand");
            // 노래 시작
            mp.start();
            return super.onStartCommand(intent, flags, startId);
        }

        // 서비스가 종료될 때 실행
        @Override
        public void onDestroy() {
            super.onDestroy();
            // 음악 종료
            mp.stop();
            Log.d("test", "Service onDestroy");
        }
}

