package com.example.user.instock.module.category;

import android.content.Context;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;

import com.example.user.instock.R;
import com.example.user.instock.adapter.CommonAdapter4RecyclerView;
import com.example.user.instock.adapter.CommonHolder4RecyclerView;
import com.example.user.instock.adapter.ListenerWithPosition;
import com.example.user.instock.entity.CategoryResult;

import java.util.List;

public class CategoryListAdapter extends CommonAdapter4RecyclerView<CategoryResult.ResultsBean> implements ListenerWithPosition.OnClickWithPositionListener<CommonHolder4RecyclerView>{
    public CategoryListAdapter(Context mContext) {
        super(mContext, null, R.layout.item);
    }

    @Override
    public void convert(CommonHolder4RecyclerView holder, CategoryResult.ResultsBean androidResult) {
        if (androidResult != null) {
            holder.setTextViewText(R.id.tv_item_title, androidResult.desc == null ? "unknown" : androidResult.desc);
        }
    }

    @Override
    public void onClick(View v, int postion, CommonHolder4RecyclerView holder) {

    }
}
