package com.icuxika.wechat.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.icuxika.wechat.R
import com.icuxika.wechat.ui.theme.KtComposeWeChatTheme

@Composable
fun AppBottomBar(selected: Int, onSelectedChange: (Int) -> Unit) {
    Row(modifier = Modifier.background(KtComposeWeChatTheme.colors.bottomBar)) {
        TabItem(
            if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            "聊天",
            if (selected == 0) KtComposeWeChatTheme.colors.iconCurrent else KtComposeWeChatTheme.colors.icon,
            Modifier
                .weight(1f)
                .clickable {
                    onSelectedChange(0)
                }
        )
        TabItem(
            if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "通讯录",
            if (selected == 1) KtComposeWeChatTheme.colors.iconCurrent else KtComposeWeChatTheme.colors.icon,
            Modifier
                .weight(1f)
                .clickable {
                    onSelectedChange(1)
                }
        )
        TabItem(
            if (selected == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            "发现",
            if (selected == 2) KtComposeWeChatTheme.colors.iconCurrent else KtComposeWeChatTheme.colors.icon,
            Modifier
                .weight(1f)
                .clickable {
                    onSelectedChange(2)
                }
        )
        TabItem(
            if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            "我",
            if (selected == 3) KtComposeWeChatTheme.colors.iconCurrent else KtComposeWeChatTheme.colors.icon,
            Modifier
                .weight(1f)
                .clickable {
                    onSelectedChange(3)
                }
        )
    }
}

@Composable
fun TabItem(
    @DrawableRes iconId: Int,
    title: String,
    tint: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painterResource(id = iconId),
            contentDescription = title,
            modifier = Modifier.size(32.dp),
            tint = tint
        )
        Text(text = title, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun AppBottomBarPreview() {
    KtComposeWeChatTheme(KtComposeWeChatTheme.Theme.Dark) {
        var selectedTab by remember { mutableStateOf(0) }
        AppBottomBar(selected = 0) {
            selectedTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(
        iconId = R.drawable.ic_chat_outlined,
        title = "聊天",
        tint = KtComposeWeChatTheme.colors.icon
    )
}
