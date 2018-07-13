package com.example.user.instock.module.home;

import android.content.pm.ActivityInfo;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.example.user.instock.GlobalConfig;
import com.example.user.instock.R;
import com.example.user.instock.base.CommonViewPagerAdapter;
import com.example.user.instock.module.category.CategoryFragment;
import com.kekstudio.dachshundtablayout.DachshundTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements HomeContract.View{

    @BindView(R.id.appbar)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.iv_home_banner)
    ImageView mIvHomeBanner;
    @BindView(R.id.tab_home_category)
    DachshundTabLayout mDachshundTabLayout;
    @BindView(R.id.tl_home_toolbar)
    Toolbar mToolbar;
    @BindView(R.id.vp_home_category)
    ViewPager mVpCategory;


    private CategoryFragment appFragment;
    private CategoryFragment androidFragment;
    private CategoryFragment iOSFragment;
    private CategoryFragment frontFragment;
    private CategoryFragment referenceFragment;
    private CategoryFragment resFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置屏幕竖向
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        String[] titles = {
                GlobalConfig.CATEGORY_NAME_APP,
                GlobalConfig.CATEGORY_NAME_ANDROID,
                GlobalConfig.CATEGORY_NAME_IOS,
                GlobalConfig.CATEGORY_NAME_FRONT_END,
                GlobalConfig.CATEGORY_NAME_RECOMMEND,
                GlobalConfig.CATEGORY_NAME_RESOURCE};

        CommonViewPagerAdapter infoPagerAdapter = new CommonViewPagerAdapter(getSupportFragmentManager(), titles);

        appFragment = CategoryFragment.newInstance(titles[0]);
        androidFragment = CategoryFragment.newInstance(titles[1]);
        iOSFragment = CategoryFragment.newInstance(titles[2]);
        frontFragment = CategoryFragment.newInstance(titles[3]);
        referenceFragment = CategoryFragment.newInstance(titles[4]);
        resFragment = CategoryFragment.newInstance(titles[5]);

        infoPagerAdapter.addFragment(appFragment);
        infoPagerAdapter.addFragment(androidFragment);
        infoPagerAdapter.addFragment(iOSFragment);
        infoPagerAdapter.addFragment(frontFragment);
        infoPagerAdapter.addFragment(referenceFragment);
        infoPagerAdapter.addFragment(resFragment);

        mVpCategory.setAdapter(infoPagerAdapter);
        mDachshundTabLayout.setupWithViewPager(mVpCategory);
        mVpCategory.setCurrentItem(1);
    }

    @Override
    public void showBannerFail(String failMessage) {

    }

    @Override
    public void setBanner(String imgUrl) {

    }

    @Override
    public void cacheImg(String imgUrl) {

    }

    @Override
    public void startBannerLoadingAnim() {

    }

    @Override
    public void stopBannerLoadingAnim() {

    }

    @Override
    public void enableFabButton() {

    }

    @Override
    public void disEnableFabButton() {

    }

    @Override
    public void setAppBarLayoutColor(int appBarLayoutColor) {

    }

    @Override
    public void setFabButtonCorlor(int color) {

    }
}
