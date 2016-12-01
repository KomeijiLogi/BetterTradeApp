package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.pc.bettertradeapp.MainActivity;
import com.example.pc.bettertradeapp.R;
import com.example.pc.bettertradeapp.SecWScan;
import com.google.zxing.integration.android.IntentIntegrator;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private View mParent;
    private FragmentActivity mActivity;

    private ImageButton img_bt_ewscan;
    private ImageButton img_bt_itemlist;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getView().findViewById(R.id.inclue_title).setVisibility(View.VISIBLE);
        View v=inflater.inflate(R.layout.fragment_main,null);
        img_bt_ewscan= (ImageButton) v.findViewById(R.id.img_secw);
        img_bt_itemlist= (ImageButton) v.findViewById(R.id.settings_title);
        img_bt_ewscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator
                        .setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
                        .setPrompt("将二维码/条码放入框内，即可自动扫描")//写那句提示的话
                        .setOrientationLocked(false)//扫描方向固定
                        .setCaptureActivity(SecWScan.class) // 设置自定义的activity是CustomActivity
                        .initiateScan(); // 初始化扫描

            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
