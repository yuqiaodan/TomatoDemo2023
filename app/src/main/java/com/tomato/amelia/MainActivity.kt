package com.tomato.amelia

import android.content.Intent
import android.view.View
import com.tomato.amelia.base.BaseVMActivity
import com.tomato.amelia.databinding.ActivityMainBinding
import com.tomato.amelia.databinding1.TaobaoActivity
import com.tomato.amelia.databinding2.TemperatureActivity

class MainActivity : BaseVMActivity<ActivityMainBinding, MainViewModel>(), View.OnClickListener {

    override fun getViewModelClass(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        binding.viewModel = viewModel
        binding.btnDatabinding1.setOnClickListener(this)
        binding.btnDatabinding2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnDatabinding1 -> {
                startActivity(Intent(this, TaobaoActivity::class.java))
            }
            binding.btnDatabinding2->{
                startActivity(Intent(this, TemperatureActivity::class.java))
            }
        }
    }

}