package com.wyq.lrcreader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.wyq.lrcreader.R;
import com.wyq.lrcreader.adapter.HomeViewPagerAdapter;
import com.wyq.lrcreader.ui.EHomePageType;
import com.wyq.lrcreader.utils.LogUtil;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * @author Uni.W
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.home_activity_bottom_appbar)
    public BottomAppBar bottomAppBar;
    @BindView(R.id.home_activity_appbar_tablayout)
    public TabLayout tabLayout;
    @BindView(R.id.home_activity_viewpager)
    public ViewPager viewPager;
    @BindView(R.id.home_activity_float_action_button)
    public FloatingActionButton floatingActionButton;

//    private String[] tabName = {"喜欢", "本地", "搜索"};


    public static void newInstance(Context context) {
        context.startActivity(new Intent(context, HomeActivity.class));
    }


    @Override
    protected int attachLayoutRes() {
        return R.layout.home_activity;
    }

    @Override
    public void initView() {

        floatingActionButton.setOnClickListener(this);

        setSupportActionBar(bottomAppBar);
        bottomAppBar.replaceMenu(R.menu.home_appbar);

        for (EHomePageType type : EHomePageType.values()) {
            tabLayout.addTab(tabLayout.newTab().setText(type.getPageName()));
        }

        HomeViewPagerAdapter pagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home_appbar_search:
                LogUtil.i("search");
                viewPager.setCurrentItem(EHomePageType.SEARCH_PAGE.getPosition(), true);
                break;
            case R.id.home_appbar_favorite:
                LogUtil.i("favourite");
                viewPager.setCurrentItem(EHomePageType.LIKE_PAGE.getPosition(), true);
                break;
            case R.id.home_appbar_local:
                LogUtil.i("local");
                viewPager.setCurrentItem(EHomePageType.LOCAL_PAGE.getPosition(), true);
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_activity_float_action_button:
                SearchActivity.newInstance(HomeActivity.this);
                break;
            default:
                break;
        }
    }
}
