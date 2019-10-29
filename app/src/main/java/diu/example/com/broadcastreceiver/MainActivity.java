package diu.example.com.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    ConnectionReceiver receiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        receiver = new ConnectionReceiver();
        intentFilter = new IntentFilter("diu.example.com.broadcastreceiver.SOME_ACTION");

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }
    @OnClick(R.id.button)
    void someMethod() {

        Intent intent = new Intent("diu.example.com.broadcastreceiver.SOME_ACTION");
        sendBroadcast(intent);
    }
}