package com.tomato.amelia

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tomato.amelia.databinding1.bean.Gender
import com.tomato.amelia.databinding1.bean.User
import com.tomato.amelia.databinding.ActivityMainBinding
import com.tomato.amelia.databinding1.TaobaoActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**方式一:直接创建binding 需要setContentView**/
        /*val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/
        /**方式二:通过DataBindingUtil创建binding 不需要setContentView DataBindingUtil可以通过Id来创建binding*/
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.user = User("张三", 18, Gender.Male)

        startActivity(Intent(this,TaobaoActivity::class.java))

    }
}