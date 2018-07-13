package com.example.user.instock.module.category;

import com.example.user.instock.base.BasePresenter;
import com.example.user.instock.entity.CategoryResult;

public interface CategoryContract {
    interface View {
        void setCategoryItems(CategoryResult categoryResult);

        void addCategoryItems(CategoryResult categoryResult);

        void getCategoryItemFail(String failMessage);

        String getCategoryName();

        void showSwipeLoading();

        void hideSwipeLoading();

        void setLoading();
    }

    interface Presenter extends BasePresenter {
        void getCategoryItems(boolean isRefresh);
    }
}
