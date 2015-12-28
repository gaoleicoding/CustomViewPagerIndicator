package com.android.customviewpagerindicator;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.customviewpagerindicator.viewpagerindicator.TabPageIndicator;
import com.android.customviewpagerindicator.viewpagerindicator.UnderlinePageIndicatorEx;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FeedBackViewPagerAdapter mContentAdapter;
    private ViewPager mPager;
    private TabPageIndicator mTabPageIndicator;
    private UnderlinePageIndicatorEx mUnderlinePageIndicator;
    private ImageView back;
    private List<String[]> mContentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();

            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window   window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        initData();
        setupViews();
    }
    private void initData() {

        mContentList = new ArrayList<String[]>();
        String[] titleStrings = getResources().getStringArray(R.array.feedback);
        String[] commerce = getResources().getStringArray(R.array.commerce);
        String[] techology = getResources().getStringArray(R.array.techology);
        String[] record = getResources().getStringArray(R.array.record);
        String[] other = getResources().getStringArray(R.array.other);
        mContentList.add(commerce);
        mContentList.add(techology);
        mContentList.add(record);
        mContentList.add(other);
        mContentAdapter = new FeedBackViewPagerAdapter(getSupportFragmentManager());
        mContentAdapter.setTitleList(titleStrings);
        mContentAdapter.setContentList(mContentList);

    }
    private void setupViews() {
        mPager = (ViewPager) findViewById(R.id.message_viewpager);
        mPager.setOffscreenPageLimit(0);
        mPager.setAdapter(mContentAdapter);
        mTabPageIndicator = (TabPageIndicator) findViewById(R.id.tab_indicator);
        mTabPageIndicator.setViewPager(mPager);
        mUnderlinePageIndicator = (UnderlinePageIndicatorEx) findViewById(R.id.underline_indicator);
        mUnderlinePageIndicator.setViewPager(mPager);
        mUnderlinePageIndicator.setFades(false);
        mTabPageIndicator.setOnPageChangeListener(mUnderlinePageIndicator);

    }
}
