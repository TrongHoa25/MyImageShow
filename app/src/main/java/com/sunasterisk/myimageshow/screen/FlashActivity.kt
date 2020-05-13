package com.sunasterisk.myimageshow.screen

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.sunasterisk.myimageshow.R
import kotlinx.android.synthetic.main.activity_flash.*

class FlashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash)
        val uri = Uri.parse(
            "android.resource://" + packageName.toString() + "/drawable/background_flash_screen"
        )
        Glide.with(this)
            .load(uri)
            .into(imageFlashScreen)
        textFlash.animation = AnimationUtils.loadAnimation(this, R.anim.slide_down_animation)
        buttonShowImage.animation = AnimationUtils.loadAnimation(this, R.anim.slide_up_animation)
        buttonShowImage.setOnClickListener(
            object : View.OnClickListener{
                override fun onClick(p0: View?) {
                    val intent = MainActivity.getChangeActivityIntent(this@FlashActivity)
                    startActivity(intent)
                }
            }
        )
    }

    companion object {
    }
}
