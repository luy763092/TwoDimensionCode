package com.tianfeng.a2dimensioncode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.zxing.client.android.CaptureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnScan = (Button) findViewById(R.id.btn_scan);

        mBtnScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.btn_scan:
                Intent startScan = new Intent(MainActivity.this,CaptureActivity.class);
                break;
            default:
                break;
        }
    }
}
