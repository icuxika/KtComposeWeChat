package com.icuxika.wechat.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.icuxika.wechat.AppViewModel
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun Home(viewModel: AppViewModel) {
    Column {
        val pagerState = rememberPagerState()
        HorizontalPager(count = 4, modifier = Modifier.weight(1f), state = pagerState) { page ->
            when (page) {
                0 -> Chat(viewModel.chatList)
                1 -> Contact()
                2 -> Discovery()
                3 -> Account()
            }
        }
        val scope = rememberCoroutineScope()
        AppBottomBar(pagerState.currentPage) { page ->
            scope.launch {
                pagerState.animateScrollToPage(page)
            }
        }
    }
}
