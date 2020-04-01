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
abstract class  BaseDataBindingFragment<TBinding : ViewDataBinding> : Fragment() {
    lateinit var binding: TBinding
    protected abstract val layoutId: Int
    var isBinding = false

    protected abstract fun init()
    protected abstract fun initListener()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (!isBinding) {
            binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
            isBinding = true
            init()
            initListener()
        }
        return binding.root
    }
}
