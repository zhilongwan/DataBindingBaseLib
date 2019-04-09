package com.libs.databinding;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

/**
 * 基于DataBinding的基础Activity
 * Created by wangz on 2018/12/19.
 */
public abstract class BaseDataBindingActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewDataBinding baseBinding;

    protected abstract int getLayoutId();

    protected abstract void init(ViewDataBinding baseBinding);

    protected abstract void initListener();

    public abstract void viewOnClick(View v);

    public int statusBarHeight = 0;

    public int color = 0xffffffff;

    @Override
    public void onClick(View v) {
        viewOnClick(v);
    }

    protected boolean setDatabinding() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            onActivityReCreator(savedInstanceState);
        }
        if (baseBinding == null && setDatabinding())
            baseBinding = DataBindingUtil.setContentView(this, getLayoutId());
        init(baseBinding);
        initListener();
    }

    /**
     * activity被回收后，重新打开activity需要恢复之前的数据
     */
    protected void onActivityReCreator(Bundle savedInstanceState) {

    }

}
