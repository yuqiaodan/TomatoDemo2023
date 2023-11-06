package com.tomato.amelia.databinding1

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.tomato.amelia.R
import com.tomato.amelia.databinding.FragmentOnSellBinding
import com.tomato.amelia.databinding1.base.BaseVmFragment

/**
 * author: created by yuqiaodan on 2023/11/6 16:25
 * description:
 */
class OnSellFragment : BaseVmFragment<FragmentOnSellBinding, OnSellViewModel>() {
    override fun getSubVMClass(): Class<OnSellViewModel> {
        return OnSellViewModel::class.java
    }

    override fun getSubLayoutId(): Int {
        return R.layout.fragment_on_sell
    }

    val mAdapter = OnSellListAdapter()

    override fun initView() {
        viewModel.loadContent()

        binding.onShellListView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

    }

    override fun obseverData() {
        viewModel.loadState.observe(this) { state ->
            Log.d("OnSellTAG", "obseverData:loadState->${state} ")
        }
        viewModel.contentList.observe(this) { list ->
            Log.d("OnSellTAG", "obseverData:contentList->${list} ")
            mAdapter.setData(list)
        }
    }
}