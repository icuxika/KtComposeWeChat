package com.icuxika.wechat.data

import androidx.annotation.DrawableRes
import com.icuxika.wechat.R

class User(
    val id: String,
    val name: String,
    @DrawableRes val avatar: Int
) {
    companion object {
        val Me: User = User("0", "ICUXIKA", R.drawable.avatar_rengwuxian)
    }
}