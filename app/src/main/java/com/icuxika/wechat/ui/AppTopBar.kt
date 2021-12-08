package com.icuxika.wechat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.icuxika.wechat.AppViewModel
import com.icuxika.wechat.R
import com.icuxika.wechat.ui.theme.KtComposeWeChatTheme

@Composable
fun AppTopBar(title: String, onBack: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .background(KtComposeWeChatTheme.colors.background)
            .fillMaxWidth()
    ) {
        Row(modifier = Modifier.height(48.dp)) {
            if (onBack != null) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable(onClick = onBack)
                        .align(Alignment.CenterVertically)
                        .size(36.dp)
                        .padding(8.dp),
                    tint = KtComposeWeChatTheme.colors.icon
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            val viewModel: AppViewModel = viewModel()
            Icon(
                painter = painterResource(id = R.drawable.ic_palette),
                contentDescription = "切换主题",
                modifier = Modifier
                    .clickable {
                        viewModel.theme = when (viewModel.theme) {
                            KtComposeWeChatTheme.Theme.Light -> KtComposeWeChatTheme.Theme.Dark
                            KtComposeWeChatTheme.Theme.Dark -> KtComposeWeChatTheme.Theme.NewYear
                            KtComposeWeChatTheme.Theme.NewYear -> KtComposeWeChatTheme.Theme.Light
                        }
                    }
                    .align(Alignment.CenterVertically)
                    .size(36.dp)
                    .padding(8.dp),
                tint = KtComposeWeChatTheme.colors.icon
            )
        }
        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            color = KtComposeWeChatTheme.colors.textPrimary
        )
    }
}