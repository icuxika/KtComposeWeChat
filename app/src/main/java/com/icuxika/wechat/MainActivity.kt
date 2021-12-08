package com.icuxika.wechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import com.google.accompanist.pager.ExperimentalPagerApi
import com.icuxika.wechat.ui.ChatDetail
import com.icuxika.wechat.ui.Home
import com.icuxika.wechat.ui.theme.KtComposeWeChatTheme

@ExperimentalPagerApi
class MainActivity : ComponentActivity() {

    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KtComposeWeChatTheme(viewModel.theme) {
                Box {
                    Home(viewModel)
                    ChatDetail()
                }
            }
        }
    }

    override fun onBackPressed() {
        if (!viewModel.endChat()) {
            super.onBackPressed()
        }
    }
}


