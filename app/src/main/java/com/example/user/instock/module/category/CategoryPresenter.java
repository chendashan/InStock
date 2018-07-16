package com.example.user.instock.module.category;

import com.example.user.instock.GlobalConfig;
import com.example.user.instock.entity.CategoryResult;
import com.example.user.instock.netWork.NetWork;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class CategoryPresenter implements CategoryContract.Presenter {

    private CategoryContract.View mCategoryView;

    private int mPage = 1;

    private CompositeSubscription mSubscriptions;

    public CategoryPresenter(CategoryContract.View mCategoryView) {
        this.mCategoryView = mCategoryView;
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void getCategoryItems(final boolean isRefresh) {
        if (isRefresh) {
            mCategoryView.showSwipeLoading();
            mPage = 1;
        } else {
            mPage += 1;
        }
        Subscription subscription = NetWork.getGankApi()
                .getCategoryDate(mCategoryView.getCategoryName(), GlobalConfig.PAGE_SIZE_CATEGORY, mPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CategoryResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mCategoryView.hideSwipeLoading();
                        mCategoryView.getCategoryItemFail(mCategoryView.getCategoryName() + "列表数据获取失败。");
                    }

                    @Override
                    public void onNext(CategoryResult categoryResult) {
                        if (isRefresh) {
                            mCategoryView.setCategoryItems(categoryResult);
                            mCategoryView.hideSwipeLoading();
                            mCategoryView.setLoading();
                        } else {
                            mCategoryView.addCategoryItems(categoryResult);
                        }
                    }
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void subscribe() {
        getCategoryItems(true);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }


}
