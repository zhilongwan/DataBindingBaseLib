package com.libs.databinding

import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup

import java.util.ArrayList

/**
 * 基于DataBinding的基础RecyclerView适配器
 *
 * @param <T>        item对应的数据类型
 * @param <TBinding> adapter对应的ViewDataBinding 名称与你的layout.xml命名有关
</TBinding></T> */
abstract class BaseDataBindingRecyclerViewAdapter<T, TBinding : ViewDataBinding>(var context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: MutableList<T>? = ArrayList()

    /**
     * adapter的布局文件
     *
     * @return
     */
    abstract val layout: Int

    fun setDatas(list: MutableList<T>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun addDatas(list: MutableList<T>) {
        this.list!!.addAll(list)
        notifyDataSetChanged()
    }

    fun clearDatas() {
        this.list!!.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<TBinding>(LayoutInflater.from(context), layout, parent, false)
        return ViewHolderItem(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindView((holder as BaseDataBindingRecyclerViewAdapter<*, *>.ViewHolderItem).binding as TBinding, list!![position], position)
    }

    /**
     * 数据绑定 对应 onBindViewHolder中的代码
     *
     * @param binding
     * @param bean
     * @param position
     */
    abstract fun onBindView(binding: TBinding, bean: T, position: Int)

    override fun getItemCount(): Int {
        return if (list == null) 0 else list!!.size
    }

    internal inner class ViewHolderItem(val binding: TBinding) : RecyclerView.ViewHolder(binding.root)
}
