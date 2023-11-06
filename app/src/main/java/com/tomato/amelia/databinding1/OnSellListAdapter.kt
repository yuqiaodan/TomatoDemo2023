package com.tomato.amelia.databinding1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tomato.amelia.R
import com.tomato.amelia.databinding.ItemOnShellListBinding
import com.tomato.amelia.databinding1.api.bean.OnShellItem

/**
 * author: created by yuqiaodan on 2023/1/3 17:46
 * description:促销商品列表UI适配器
 */
class OnSellListAdapter : RecyclerView.Adapter<OnSellListAdapter.InnerHolder>() {


    private val mContent = arrayListOf<OnShellItem>()

    fun setData(newList: List<OnShellItem>) {
        mContent.clear()
        mContent.addAll(newList)
        notifyDataSetChanged()
    }

    class InnerHolder(val binding: ItemOnShellListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        return InnerHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_on_shell_list,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        val item = mContent[position]
        holder.binding.itemData = item
    }

    override fun getItemCount(): Int {
        return mContent.size
    }

}