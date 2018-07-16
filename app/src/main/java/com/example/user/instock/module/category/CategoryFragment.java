package com.example.user.instock.module.category;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.user.instock.MainActivity;
import com.example.user.instock.R;
import com.example.user.instock.entity.CategoryResult;
import com.example.user.instock.module.home.HomeActivity;
import com.example.user.instock.widget.recyclerviewwithfooter.OnLoadMoreListener;
import com.example.user.instock.widget.recyclerviewwithfooter.RecyclerViewWithFooter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryFragment extends Fragment implements CategoryContract.View, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener{

    public static final String CATEGORY_NAME = "com.example.user.instock.module.category.CATEGORY_NAME";

//    @BindView(R.id.rec_test)
//    RecyclerView recyclerView;
    @BindView(R.id.recycler_view)
    RecyclerViewWithFooter mRecyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private CategoryListAdapter mCategoryListAdapter;
    private CategoryContract.Presenter mPresenter = new CategoryPresenter(this);

    private String mCategoryName;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mCategoryName = bundle.getString(CATEGORY_NAME);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == HomeActivity.SETTING_REQUEST_CODE) {
            mCategoryListAdapter.notifyDataSetChanged();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ButterKnife.bind(this, view);

        mCategoryListAdapter = new CategoryListAdapter(getContext());

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mCategoryListAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.subscribe();
//        String[] arr = {"app", "src", "main", "java", "com", "example", "user", "instock", "module", "category", "src", "main", "java", "com", "example"};
//        LinearLayoutManager manager = new LinearLayoutManager(getContext());
//        recyclerView.setLayoutManager(manager);
//        TestAdapter adapter = new TestAdapter(arr);
//        recyclerView.setAdapter(adapter);
    }

    public static CategoryFragment newInstance(String mCategoryName) {
        CategoryFragment categoryFragment = new CategoryFragment();

        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY_NAME, mCategoryName);

        categoryFragment.setArguments(bundle);
        return categoryFragment;
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void setCategoryItems(CategoryResult categoryResult) {
        mCategoryListAdapter.mData = categoryResult.results;
        mCategoryListAdapter.notifyDataSetChanged();
    }

    @Override
    public void addCategoryItems(CategoryResult categoryResult) {
        int start = mCategoryListAdapter.getItemCount();
        mCategoryListAdapter.mData.addAll(categoryResult.results);
        mCategoryListAdapter.notifyItemRangeInserted(start, categoryResult.results.size());
    }

    @Override
    public void getCategoryItemFail(String failMessage) {

    }

    @Override
    public String getCategoryName() {
        return this.mCategoryName;
    }

    @Override
    public void showSwipeLoading() {

    }

    @Override
    public void hideSwipeLoading() {

    }

    @Override
    public void setLoading() {

    }

    @Override
    public void onLoadMore() {

    }
}
