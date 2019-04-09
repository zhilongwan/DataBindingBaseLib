package com.libs.databinding;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于DataBinding的基础RecyclerView适配器
 * Created by wangz on 2018/9/29.
 */

public abstract class BaseDataBindingRecyclerViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<T> list = new ArrayList<>();
    public Context mContext;

    public BaseDataBindingRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDatas(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addDatas(List<T> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void clearDatas() {
        this.list.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), getLayout(), parent, false);
        return new ViewHolderItem(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding binding = ((ViewHolderItem) holder).getBinding();
        onBindView(binding, list.get(position), position);
    }

    /**
     * adapter的布局文件
     *
     * @return
     */
    public abstract int getLayout();

    /**
     * 数据绑定 对应 onBindViewHolder中的代码
     *
     * @param dataBinding
     * @param bean
     * @param position
     */
    public abstract void onBindView(ViewDataBinding dataBinding, T bean, int position);

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolderItem extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;

        public ViewHolderItem(ViewDataBinding headBinding) {
            super(headBinding.getRoot());
            this.binding = headBinding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }
    }
}
