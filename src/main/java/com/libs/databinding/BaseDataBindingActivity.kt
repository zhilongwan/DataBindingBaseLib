package com.libs.databinding

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

import android.os.Bundle
import android.view.View

/**
 * 基于DataBinding的基础Activity
 *
 * @param <TBinding> activity对应的ViewDataBinding 名称与你的layout.xml命名有关
</TBinding> */
abstract class BaseDataBindingActivity<TBinding : ViewDataBinding> : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: TBinding

    protected abstract val layoutId: Int

    var statusBarHeight = 0

    var color = -0x1

    protected abstract fun onInit()

    protected abstract fun onListenerInit()

    protected abstract fun onDataRequest()

    abstract fun viewOnClick(v: View)

    override fun onClick(v: View) {
        viewOnClick(v)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        onInit()
        onListenerInit()
        onDataRequest()
    }
}
