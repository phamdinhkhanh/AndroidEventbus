package com.example.hcm_102_0006.AndroidEventBus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hcm_102_0006.demoeventbusandroid.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private TextView mName;
    private TextView mAddress;
    private Button mOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = findViewById(R.id.txtName);
        mAddress = findViewById(R.id.txtAdress);
        mOpen = findViewById(R.id.btnOpen);
        mOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PostActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCustomEvent(CustomEvent customEvent) {
        mName.setText(customEvent.getName().toString().trim());
        mAddress.setText(customEvent.getPassword().toString().trim());
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
