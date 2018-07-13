package com.example.user.instock.module.home;

import android.support.v7.graphics.Palette;

import com.example.user.instock.base.BasePresenter;

public interface HomeContract {
    interface View {
        void showBannerFail(String failMessage);

        void setBanner(String imgUrl);

        void cacheImg(String imgUrl);

        void startBannerLoadingAnim();

        void stopBannerLoadingAnim();

        void enableFabButton();

        void disEnableFabButton();

        void setAppBarLayoutColor(int appBarLayoutColor);

        void setFabButtonCorlor(int color);
    }

    interface Presenter extends BasePresenter{
        void getRandomBanner();

        void setThmeColor(Palette palette);

        void getBanner(final boolean isRandom);

        void saveCacheImgUrl(String url);
    }
}
