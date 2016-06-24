package com.tianfeng.a2dimensioncode;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnScan;
    private TextView mEtText;
    private EditText mEtInput;
    private Button mBtnMake;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnScan = (Button) findViewById(R.id.btn_scan);
        mEtText = (TextView) findViewById(R.id.et_text);
        imageView = (ImageView) findViewById(R.id.iv_image);
        mBtnMake = (Button) findViewById(R.id.btn_make);
        mEtInput = (EditText) findViewById(R.id.et_input);
        String str =  mEtInput.getText().toString().trim();
        mBtnScan.setOnClickListener(this);
        mBtnMake.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.btn_scan:
                Toast.makeText(this,"你可以扫描条码和二维码了",Toast.LENGTH_SHORT).show();
                Intent openCameraIntent = new Intent(MainActivity.this,CaptureActivity.class);
                //Intent startScan = new Intent(MainActivity.this,CaptureActivity.class);
                //startActivity(startScan);
                startActivityForResult(openCameraIntent,0);
                break;
            case R.id.btn_make:
                Toast.makeText(this,"生成二维码",Toast.LENGTH_SHORT).show();
                Intent makeDimension = new Intent(MainActivity.this,DimensionActivity.class);
                startActivity(makeDimension);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK && data != null){
            String result = data.getExtras().getString("result");
            mEtText.setText(result);
        }
    }
}
