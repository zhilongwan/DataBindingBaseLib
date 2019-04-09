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
 * Created by wangz on 2018/12/19.
 */
public abstract class BaseDataBindingFragment extends Fragment {
    private ViewDataBinding baseBinding;
    protected abstract int getLayoutId();

    protected abstract void init(ViewDataBinding baseBinding);
    protected abstract void initListener();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (baseBinding == null) {
            baseBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
            init(baseBinding);
            initListener();
        }
        return baseBinding.getRoot();
    }
}
