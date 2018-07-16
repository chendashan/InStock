package com.example.user.instock.adapter;

import android.view.View;

public class ListenerWithPosition implements View.OnClickListener {
    private int mPosition;
    private Object mHolder;
    private OnClickWithPositionListener mOnClickListener;

    public ListenerWithPosition(int position, Object holder) {
        this.mPosition = position;
        this.mHolder = holder;
    }

    @Override
    public void onClick(View view) {
        if (mOnClickListener != null)
            mOnClickListener.onClick(view, mPosition, mHolder);
    }

    public interface OnClickWithPositionListener<T> {
        void onClick(View v, int postion, T holder);
    }

    public void setOnClickListener(OnClickWithPositionListener mOnClickListener) {
        this.mOnClickListener = mOnClickListener;
    }
}
