package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pc.bettertradeapp.LoginActivity;
import com.example.pc.bettertradeapp.R;
import com.nostra13.universalimageloader.utils.L;

import org.w3c.dom.Text;

import until.RoundImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment implements View.OnClickListener{

    private RoundImageView avatar;
    private TextView name_user;
    private TextView great_txt;
    private TextView follow_txt;
    private ImageButton img_bt_userinfo_more;
    private ImageButton img_bt_offtake;
    private ImageButton img_bt_buy;
    private ImageButton img_bt_publish;
    private ImageButton img_bt_exchange;
    private ImageButton img_bt_sale;
    private ImageButton img_bt_donateM;
    private ImageButton img_bt_donateT;
    private ImageButton img_bt_help;

    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //getView().findViewById(R.id.inclue_title).setVisibility(View.GONE);
        View v=inflater.inflate(R.layout.fragment_mine,null);
        //对对象进行初始化
        avatar= (RoundImageView) v.findViewById(R.id.avatar_mine_user);
        name_user= (TextView) v.findViewById(R.id.name_mine_user);
        great_txt= (TextView) v.findViewById(R.id.great_mine_user);
        follow_txt= (TextView) v.findViewById(R.id.follow_mine_user);
        img_bt_userinfo_more= (ImageButton) v.findViewById(R.id.userinfo_mine_more);
        img_bt_publish= (ImageButton) v.findViewById(R.id.img_bt_publish);
        img_bt_offtake= (ImageButton) v.findViewById(R.id.img_bt_offtake);
        img_bt_buy= (ImageButton) v.findViewById(R.id.img_bt_buy);
        img_bt_exchange= (ImageButton) v.findViewById(R.id.img_bt_exchange);
        img_bt_sale= (ImageButton) v.findViewById(R.id.img_bt_sale);
        img_bt_donateM= (ImageButton) v.findViewById(R.id.img_bt_donateM);
        img_bt_donateT= (ImageButton) v.findViewById(R.id.img_bt_donateT);
        img_bt_help= (ImageButton) v.findViewById(R.id.img_bt_help);

        //绑定点击事件
        avatar.setOnClickListener(this);
        name_user.setOnClickListener(this);
        great_txt.setOnClickListener(this);
        follow_txt.setOnClickListener(this);
        img_bt_userinfo_more.setOnClickListener(this);
        img_bt_publish.setOnClickListener(this);
        img_bt_offtake.setOnClickListener(this);
        img_bt_buy.setOnClickListener(this);
        img_bt_exchange.setOnClickListener(this);
        img_bt_donateM.setOnClickListener(this);
        img_bt_donateT.setOnClickListener(this);
        img_bt_help.setOnClickListener(this);

        return v;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.avatar_mine_user:
                Toast.makeText(getActivity().getApplication(),"点击头像", Toast.LENGTH_LONG).show();
                Intent it =new Intent(getActivity(), LoginActivity.class);
                startActivity(it);
                break;
            case R.id.name_mine_user:
                break;
            case R.id.great_mine_user:
                break;
            case R.id.follow_mine_user:
                break;
            case R.id.userinfo_mine_more:
                break;
            case R.id.img_bt_publish:
                break;
            case R.id.img_bt_offtake:
                break;
            case R.id.img_bt_buy:
                break;
            case R.id.img_bt_sale:
                break;
            case R.id.img_bt_exchange:
                break;
            case R.id.img_bt_donateM:
                break;
            case R.id.img_bt_donateT:
                break;
            case R.id.img_bt_help:
                break;
            default:
                break;
        }
    }
}
