package com.tomato.amelia.databinding1

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tomato.amelia.R
import com.tomato.amelia.databinding.ItemOnShellListBinding
import com.tomato.amelia.databinding1.api.bean.OnShellItem

/**
 * author: created by yuqiaodan on 2023/1/3 17:46
 * description:促销商品列表UI适配器
 */
class OnSellListAdapter : RecyclerView.Adapter<OnSellListAdapter.InnerHolder>() {

    companion object{
        /**
         * BindingAdapter必须是静态方法或者全局方法
         * 静态方法：java需要写为static方法
         * kotlin需要写在伴生对象中
         * 全局方法:写在class外
         * */
        @JvmStatic
        @BindingAdapter("goodsImage" )
        fun setUpImage(iv: ImageView, goodsImage:String?){
            if(goodsImage!=null){
                //加载图片
                Glide.with(iv).load(  "https:${goodsImage}").into(iv)
            }else{
                //错误站位图
            }
        }
    }


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

        holder.binding.tvOriginPrice.paint.flags=Paint.STRIKE_THRU_TEXT_FLAG

    }

    override fun getItemCount(): Int {
        return mContent.size
    }

}