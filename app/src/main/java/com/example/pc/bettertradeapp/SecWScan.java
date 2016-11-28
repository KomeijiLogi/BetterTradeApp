package com.example.pc.bettertradeapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import java.util.Hashtable;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

//implements DecoratedBarcodeView.TorchListener
public class SecWScan extends Activity  implements DecoratedBarcodeView.TorchListener{

    Button swichLight;
    DecoratedBarcodeView mDBV;
    private CaptureManager captureManager;
    private boolean isLightOn = false;


    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        captureManager.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mDBV.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_wscan);
        swichLight = (Button) findViewById(R.id.btn_switch);
        mDBV= (DecoratedBarcodeView) findViewById(R.id.dbv_custom);
        mDBV.setTorchListener(this);


         //如果没有闪光灯功能，就去掉相关按钮
        if (!hasFlash()) {
            swichLight.setVisibility(View.GONE);
        }
        //重要代码，初始化捕获
        captureManager = new CaptureManager(this, mDBV);
        captureManager.initializeFromIntent(getIntent(), savedInstanceState);
        captureManager.decode();
        //选择闪关灯
        swichLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isLightOn) {
                    mDBV.setTorchOff();
                } else {
                    mDBV.setTorchOn();
                }
            }
        });
    }



    //解析二维码图片,返回结果封装在Result对象中
//    private com.google.zxing.Result  parseQRcodeBitmap(String bitmapPath){
//        //解析转换类型UTF-8
//        Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
//        hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
//        //获取到待解析的图片
//        BitmapFactory.Options options = new BitmapFactory.Options();
//
//        options.inJustDecodeBounds = true;
//
//        Bitmap bitmap = BitmapFactory.decodeFile(bitmapPath,options);
//        //取出来的图片的边长（二维码图片是正方形的）设置为400像素
//        /**
//         options.outHeight = 400;
//         options.outWidth = 400;
//         options.inJustDecodeBounds = false;
//         bitmap = BitmapFactory.decodeFile(bitmapPath, options);
//         */
//
//        options.inSampleSize = options.outHeight / 400;
//        if(options.inSampleSize <= 0){
//            options.inSampleSize = 1; //防止其值小于或等于0
//        }
//        /**
//         * 辅助节约内存设置
//         *
//         * options.inPreferredConfig = Bitmap.Config.ARGB_4444;    // 默认是Bitmap.Config.ARGB_8888
//         * options.inPurgeable = true;
//         * options.inInputShareable = true;
//         */
//        options.inJustDecodeBounds = false;
//        bitmap = BitmapFactory.decodeFile(bitmapPath, options);
//        //新建一个RGBLuminanceSource对象，将bitmap图片传给此对象
//        RGBLuminanceSource rgbLuminanceSource = new RGBLuminanceSource(bitmap.getWidth(),bitmap.getHeight(),null);
//        //将图片转换成二进制图片
//        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(rgbLuminanceSource));
//        //初始化解析对象
//        QRCodeReader reader = new QRCodeReader();
//        //开始解析
//        Result result = null;
//        try {
//            result = reader.decode(binaryBitmap, hints);
//        } catch (Exception e) {
//            // TODO: handle exception
//        }
//
//        return result;
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onTorchOn() {
        Toast.makeText(this, "torch on", Toast.LENGTH_LONG).show();
        isLightOn = true;
    }

    @Override
    public void onTorchOff() {
        Toast.makeText(this, "torch off", Toast.LENGTH_LONG).show();
        isLightOn = false;
    }
    // 判断是否有闪光灯功能
    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }
}
