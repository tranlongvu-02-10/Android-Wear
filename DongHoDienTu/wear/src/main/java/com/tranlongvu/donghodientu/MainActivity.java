package com.tranlongvu.donghodientu;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private TextView mTextView;
    TimerTask task;
    Timer timer;
    SimpleDateFormat sdf=new SimpleDateFormat(&quot;hh:mm:ss aaa&quot;);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                timer=new Timer();
                timer.schedule(task,0,1000);
            }
        });
        task=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Calendar calendar=Calendar.getInstance();
                        if(mTextView!=null)
                            mTextView.setText(sdf.format(calendar.getTime()));
                    }
                });
            }
        };

    }
}