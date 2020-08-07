package com.example.hcm_102_0006.AndroidEventBus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hcm_102_0006.demoeventbusandroid.R;

import org.greenrobot.eventbus.EventBus;

public class PostActivity extends AppCompatActivity {
    private Button mSend1;
    private Button mSend2;
    private EditText edName;
    private EditText edAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        mSend1 = findViewById(R.id.btnSend1);
        edName = findViewById(R.id.edName);
        edAddress = findViewById(R.id.edAddress);
        mSend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(edName.getText().toString().trim())) {
                    EventBus.getDefault()
                            .post(new CustomEvent(edName.getText().toString().trim(), edAddress.getText().toString().trim()));
                    finish();
                } else {
                    Toast.makeText(PostActivity.this, "Please enter values", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }
}
