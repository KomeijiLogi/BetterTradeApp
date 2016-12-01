package com.example.pc.bettertradeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edit_user;
    private EditText edit_pwd;
    private TextView txt_forgotton;
    private Button bt_login;
    private Button bt_register;
    private ImageButton img_bt_weibo;
    private ImageButton img_bt_qq;
    private ImageButton img_bt_wechat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_user= (EditText) findViewById(R.id.edit_userinfo_login);
        edit_pwd= (EditText) findViewById(R.id.edit_userpassword_login);
        txt_forgotton= (TextView) findViewById(R.id.forgotton_login);
        bt_login= (Button) findViewById(R.id.bt_login_login);
        bt_register= (Button) findViewById(R.id.bt_register_login);
        img_bt_weibo= (ImageButton) findViewById(R.id.img_bt_weibo);
        img_bt_qq= (ImageButton) findViewById(R.id.img_bt_qq);
        img_bt_wechat= (ImageButton) findViewById(R.id.img_bt_wechat);


        txt_forgotton.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        bt_register.setOnClickListener(this);
        img_bt_weibo.setOnClickListener(this);
        img_bt_qq.setOnClickListener(this);
        img_bt_wechat.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.forgotton_login:
                break;
            case R.id.bt_login_login:
                break;
            case R.id.bt_register_login:
                break;
            case R.id.img_bt_weibo:
                break;
            case R.id.img_bt_qq:
                break;
            case R.id.img_bt_wechat:
                break;
            default:
                break;
        }
    }
}
