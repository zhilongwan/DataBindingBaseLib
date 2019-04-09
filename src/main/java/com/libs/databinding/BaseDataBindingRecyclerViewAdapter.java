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
 * @param <T> item对应的数据类型
 * @param <TBinding> adapter对应的ViewDataBinding 名称与你的layout.xml命名有关
 */
public abstract class BaseDataBindingRecyclerViewAdapter<T,TBinding extends ViewDataBinding> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
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
        TBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), getLayout(), parent, false);
        return new ViewHolderItem(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TBinding binding = ((ViewHolderItem) holder).getBinding();
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
     * @param binding
     * @param bean
     * @param position
     */
    public abstract void onBindView(TBinding binding, T bean, int position);

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolderItem extends RecyclerView.ViewHolder {
        private TBinding binding;

        public ViewHolderItem(TBinding headBinding) {
            super(headBinding.getRoot());
            this.binding = headBinding;
        }

        public TBinding getBinding() {
            return binding;
        }

        public void setBinding(TBinding binding) {
            this.binding = binding;
        }
    }
}
