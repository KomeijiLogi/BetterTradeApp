package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.bettertradeapp.R;

import java.util.List;

import entry.ItemInfo;
import until.ImageLoaderUtil;

/**
 * Created by pc on 2016/11/23.
 */

public class DataBasicAdapter extends BaseAdapter {
    private Context context;
    private List showlist;

    public DataBasicAdapter(Context context, List showlist) {
        this.context = context;
        this.showlist = showlist;
    }

    @Override
    public int getCount() {
        return showlist.size();
    }

    @Override
    public Object getItem(int i) {
        return showlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHold vh=null;
        View v;
        if(view==null){
            vh=new ViewHold();
            view= LayoutInflater.from(context).inflate(R.layout.layout_for_adapter,null);
            vh.img_item_show= (ImageView) view.findViewById(R.id.img_adapter_item);
            vh.txt_item_name= (TextView) view.findViewById(R.id.txt_adapter_name);
            vh.txt_item_price= (TextView) view.findViewById(R.id.txt_adapter_price);
            view.setTag(vh);
        }else {
            vh= (ViewHold) view.getTag();
        }
        ItemInfo itemInfo=new ItemInfo();
        ImageLoaderUtil.display(itemInfo.getImg_item(),vh.img_item_show);
        vh.txt_item_name.setText(itemInfo.getItem_name());
        vh.txt_item_price.setText(itemInfo.getItem_price());
        return view;
    }

    public class ViewHold{
        public ImageView img_item_show;
        public TextView  txt_item_name;
        public TextView  txt_item_price;
    }

}
