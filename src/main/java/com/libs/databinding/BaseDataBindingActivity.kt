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
    var binding: TBinding? = null
        protected set

    protected abstract val layoutId: Int

    var statusBarHeight = 0

    var color = -0x1

    protected abstract fun init()

    protected abstract fun initListener()

    abstract fun viewOnClick(v: View)

    override fun onClick(v: View) {
        viewOnClick(v)
    }

    protected fun setDatabinding(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            onActivityReCreator(savedInstanceState)
        }
        if (binding == null && setDatabinding())
            binding = DataBindingUtil.setContentView(this, layoutId)
        init()
        initListener()
    }

    /**
     * activity被回收后，重新打开activity需要恢复之前的数据
     */
    protected fun onActivityReCreator(savedInstanceState: Bundle) {

    }

}
