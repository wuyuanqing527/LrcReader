package com.wyq.lrcreader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.wyq.lrcreader.R;
import com.wyq.lrcreader.adapter.HomeViewPagerAdapter;
import com.wyq.lrcreader.ui.EHomePageType;
import com.wyq.lrcreader.ui.HomeAction;
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

    private EHomePageType homePageType = EHomePageType.SEARCH_PAGE;

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
        bottomAppBar.replaceMenu(homePageType.getMenuId());

        for (EHomePageType type : EHomePageType.values()) {
            tabLayout.addTab(tabLayout.newTab().setText(type.getPageName()));
        }

        HomeViewPagerAdapter pagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                LogUtil.i("onPageScrolled:"+position);
            }

            @Override
            public void onPageSelected(int position) {

                LogUtil.i("onPageSelected:" + position);
                for (EHomePageType type : EHomePageType.values()) {
                    if (type.getPosition() == position) {
                        homePageType = type;
                    }
                }

                invalidateOptionsMenu();
//                bottomAppBar.replaceMenu(homePageType.getMenuId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(homePageType.getMenuId(), menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_appbar_search_list:
                LogUtil.i("search_list");
                LiveEventBus.get().with(HomeAction.ACTION_SEARCH).postValue(HomeAction.ACTION_SEARCH_EXPAND_LIST);
                break;
            case R.id.home_appbar_search_name:
                LogUtil.i("search_name");
                LiveEventBus.get().with(HomeAction.ACTION_SEARCH).postValue(HomeAction.ACTION_SEARCH_TITLE_LIST);
                break;
            case R.id.home_appbar_search_source:
                LogUtil.i("search_source");
                break;
            case R.id.home_appbar_like_little:
                LogUtil.i("like_little");
                break;
            case R.id.home_appbar_like_normal:
                LogUtil.i("like_normal");
                break;
            case R.id.home_appbar_like_most:
                LogUtil.i("like_most");
                break;
            case R.id.home_appbar_local_list:
                LogUtil.i("local_list");
                break;
            case R.id.home_appbar_local_folder:
                LogUtil.i("local_folder");
                break;
            case R.id.home_appbar_local_refresh:
                LogUtil.i("local_refresh");
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
