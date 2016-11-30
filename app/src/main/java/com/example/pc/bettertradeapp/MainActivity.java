package com.example.pc.bettertradeapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nostra13.universalimageloader.utils.L;

import java.util.ArrayList;
import java.util.List;

import adapter.TabDataPaperAdapter;
import animation.MoreWindows;
import fragment.DynamicFragment;
import fragment.MainFragment;
import fragment.MessageFragment;
import fragment.MineFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView listView_Main;
    private RadioButton img_bt_mainpage;
    private RadioButton img_bt_dynamic;
    private RadioButton img_bt_message;
    private RadioButton img_bt_mine;
    private RadioButton img_bt_addon;
    private RadioGroup ragp_bottom;
    private ImageButton img_bt_ewscan;
    private ImageButton img_bt_itemlist;
    ActionBar ab;
    MoreWindows mMoreWindow;
    ViewPager viewPager;
    List<Fragment> fragmentList;
    DynamicFragment dynamicFragment;
    MainFragment mainFragment;
    MessageFragment messageFragment;
    MineFragment mineFragment;

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //listView_Main= (ListView) findViewById(R.id.list_main);
        img_bt_mainpage= (RadioButton) findViewById(R.id.imgbt_main);
        img_bt_dynamic= (RadioButton) findViewById(R.id.imgbt_dynamic);
        img_bt_addon= (RadioButton) findViewById(R.id.imgbt_addon);
        img_bt_message= (RadioButton) findViewById(R.id.imgbt_message);
        img_bt_mine= (RadioButton) findViewById(R.id.imgbt_mine);
        ragp_bottom= (RadioGroup) findViewById(R.id.rg_img_bottom);
        viewPager= (ViewPager) findViewById(R.id.viewpager_main);


//        View v=LayoutInflater.from(this).inflate(R.layout.layout_for_main_title,null);
//        img_bt_ewscan= (ImageButton) v.findViewById(R.id.img_secw);
//        img_bt_itemlist= (ImageButton) v.findViewById(R.id.settings_title);

        img_bt_ewscan= (ImageButton) findViewById(R.id.img_secw);
        img_bt_itemlist= (ImageButton) findViewById(R.id.settings_title);

        img_bt_mainpage.setChecked(true);

        dynamicFragment=new DynamicFragment();
        mainFragment=new MainFragment();
        messageFragment=new MessageFragment();
        mineFragment=new MineFragment();

        ab=getSupportActionBar();
        ab.hide();

        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(mainFragment);
        fragmentList.add(dynamicFragment);
        fragmentList.add(messageFragment);
        fragmentList.add(mineFragment);




        fm=getSupportFragmentManager();
        TabDataPaperAdapter tabDataPaperAdapter=new TabDataPaperAdapter(fm,fragmentList);
        viewPager.setAdapter(tabDataPaperAdapter);
        viewPager.setCurrentItem(0);





        //绑定监听事件
        img_bt_addon.setOnClickListener(this);
        img_bt_dynamic.setOnClickListener(this);
        img_bt_mainpage.setOnClickListener(this);
        img_bt_message.setOnClickListener(this);
        img_bt_mine.setOnClickListener(this);
        img_bt_ewscan.setOnClickListener(this);
        img_bt_itemlist.setOnClickListener(this);



//        img_bt_addon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                  showMoreWindow(view);
//            }
//        });
//        img_bt_mine.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent it =new Intent(MainActivity.this,MinePage.class);
//                startActivity(it);
//            }
//        });



        bindevent();

        tabDataPaperAdapter.notifyDataSetChanged();

        img_bt_ewscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
               intentIntegrator
                        .setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
                        .setPrompt("将二维码/条码放入框内，即可自动扫描")//写那句提示的话
                        .setOrientationLocked(false)//扫描方向固定
                        .setCaptureActivity(SecWScan.class) // 设置自定义的activity是CustomActivity
                        .initiateScan(); // 初始化扫描

            }
        });
        
    }
    private void showMoreWindow(View view) {
        //显示弹出窗体
        if (null == mMoreWindow) {
            mMoreWindow = new MoreWindows(this);
            mMoreWindow.init();
        }

        mMoreWindow.showMoreWindow(view,100);
    }

    public void bindevent(){
        //对radiogroup和viewpager进行绑定
        ragp_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                viewPager.setCurrentItem(i);
//                Intent it;
//                switch (i){
//                    case 0:
//                        break;
//                    case 1:
//                        it=new Intent(MainActivity.this,DynamicPage.class);
//                        startActivity(it);
//                        break;
//                    case 2:
//                    case 3:
//                        it=new Intent(MainActivity.this,MessagePage.class);
//                        startActivity(it);
//                        break;
//                    case 4:
//                        it=new Intent(MainActivity.this,MinePage.class);
//                        startActivity(it);
//                        break;
//                    default:
//                        break;
//                }
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                ragp_bottom.check(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgbt_addon:
                showMoreWindow(view);
                break;
            case R.id.imgbt_main:
                viewPager.setCurrentItem(0);
                break;
            case R.id.imgbt_dynamic:
                viewPager.setCurrentItem(1);
                break;
            case R.id.imgbt_message:
                viewPager.setCurrentItem(2);
                break;
            case R.id.imgbt_mine:
                viewPager.setCurrentItem(3);
                break;
            case R.id.img_secw:


//                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
//                intentIntegrator
//                        .setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
//                        .setPrompt("将二维码/条码放入框内，即可自动扫描")//写那句提示的话
//                        .setOrientationLocked(false)//扫描方向固定
//                        .setCaptureActivity(SecWScan.class) // 设置自定义的activity是CustomActivity
//                        .initiateScan(); // 初始化扫描




                break;
            case R.id.settings_title:
                break;
            default:
                break;
        }
    }

//      private void initEvent() {
//          img_bt_ewscan.setOnClickListener(new View.OnClickListener() {
//              @Override
//              public void onClick(View v) {
//                  //假如你要用的是fragment进行界面的跳转
//                  //IntentIntegrator intentIntegrator = IntentIntegrator.forSupportFragment(ShopFragment.this).setCaptureActivity(CustomScanAct.class);
//                  IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
//                  intentIntegrator
//                          .setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
//                          .setPrompt("将二维码/条码放入框内，即可自动扫描")//写那句提示的话
//                          .setOrientationLocked(false)//扫描方向固定
//                          .setCaptureActivity(CustomScanAct.class) // 设置自定义的activity是CustomActivity
//                          .initiateScan(); // 初始化扫描
//              }
//          });
//      }
//
    //获取扫描结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() == null) {

            } else {
                // ScanResult 为获取到的字符串
                String ScanResult = intentResult.getContents();

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
