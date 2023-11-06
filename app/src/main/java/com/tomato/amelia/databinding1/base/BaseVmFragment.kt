package com.tomato.amelia.databinding1.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * author: created by yuqiaodan on 2023/11/6 14:48
 * description:Fragment基类 有ViewModel
 */
abstract class BaseVmFragment<T : ViewDataBinding, VM : ViewModel> : BaseViewFragment<T>() {

    protected lateinit var viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //创建ViewModel
        initViewModel()
        super.onViewCreated(view, savedInstanceState)
        //观察数据变化、更新UI
        obseverData()
        //设置相关事件
        initEvent()

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(getSubVMClass())
    }

    abstract fun getSubVMClass(): Class<VM>

    open fun obseverData() {}

    open fun initEvent() {}

}