package com.libs.databinding

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 基于DataBinding的基础Fragment
 * @param <TBinding> fragment对应的ViewDataBinding 名称与你的layout.xml命名有关
</TBinding> */
abstract class BaseDataBindingFragment<TBinding : ViewDataBinding> : Fragment() {
    var binding: TBinding? = null
        protected set
    protected abstract val layoutId: Int

    protected abstract fun init()
    protected abstract fun initListener()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            init()
            initListener()
        }
        return binding!!.root
    }
}
