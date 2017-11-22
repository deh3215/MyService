package com.example.a32150.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;

public class MyService extends Service {

    public static boolean isStop = true;
    private int count;
    private Thread t;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        isStop = false;
        t = new Thread()    {
            @Override
            public void run() {
                while(true)  {
                    if(!isStop) {
                        try {
                            Thread.sleep(1000);
                            System.out.println("count = "+count);
                            count++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else    {
                        System.out.println("結束服務");
                        break;
                    }
                }
            }
        };
        t.start();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // t.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        isStop = true;
        t=null;
        super.onDestroy();
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }
}
