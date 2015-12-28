package com.android.customviewpagerindicator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class FeedBackViewPagerAdapter extends FragmentPagerAdapter {

    private String[] titleListArray;
    private List<String[]> contentArrayList;

    public FeedBackViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    public void setContentList(List<String[]> contentArrayList) {
        this.contentArrayList = contentArrayList;
    }

    public void setTitleList(String[] titleListArray) {
        this.titleListArray = titleListArray;
    }

    @Override
    public Fragment getItem(int position) {
        // TODO Auto-generated method stub
        if (contentArrayList == null) {
            return null;
        }
        return FeedBackContentFragment.newInstance(titleListArray[position],contentArrayList.get(position),position);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        if (titleListArray != null) {
            return titleListArray.length;
        } else {
            return 0;
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        if (titleListArray != null) {
            return titleListArray[position];
        }
        return super.getPageTitle(position);
    }


}
