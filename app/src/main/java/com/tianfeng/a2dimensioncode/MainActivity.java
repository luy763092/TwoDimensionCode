package com.tianfeng.a2dimensioncode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                Toast.makeText(this,"你可以扫描条码和二维码了",Toast.LENGTH_LONG).show();
                Intent startScan = new Intent(MainActivity.this,CaptureActivity.class);
                startActivity(startScan);
                break;
            default:
                break;
        }
    }
}
