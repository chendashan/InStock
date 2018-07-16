package com.example.user.instock.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public abstract class CommonAdapter4RecyclerView<T> extends RecyclerView.Adapter {
    public Context mContext;
    public List<T> mData;
    private int layoutId;
    private View mView;

    public CommonAdapter4RecyclerView(Context mContext, List<T> mData, int layoutId) {
        this.mContext = mContext;
        this.mData = mData;
        this.layoutId = layoutId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(layoutId, viewGroup, false);
        return new CommonHolder4RecyclerView(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CommonHolder4RecyclerView commonHolder = (CommonHolder4RecyclerView) viewHolder;
        commonHolder.position = i;
        convert(commonHolder, mData.get(i));
    }

    @Override
    public int getItemCount() {
        return (mData != null) ? mData.size() : 0;
    }

    public abstract void convert(CommonHolder4RecyclerView holder, T t);
}
