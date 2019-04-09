package com.libs.databinding;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 基于DataBinding的基础Fragment
 * @param <TBinding> fragment对应的ViewDataBinding 名称与你的layout.xml命名有关
 */
public abstract class BaseDataBindingFragment<TBinding extends ViewDataBinding> extends Fragment {
    protected TBinding binding;
    protected abstract int getLayoutId();

    protected abstract void init();
    protected abstract void initListener();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
            init();
            initListener();
        }
        return binding.getRoot();
    }
}
