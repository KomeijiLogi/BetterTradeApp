package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * Created by pc on 2016/11/24.
 */

public class TabDataPaperAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentsData;

    public TabDataPaperAdapter(FragmentManager fm,List<Fragment> fragmentsData) {
        super(fm);
        this.fragmentsData=fragmentsData;
    }


    @Override
    public int getCount() {
        return fragmentsData.size();
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentsData.get(i);
    }


}
