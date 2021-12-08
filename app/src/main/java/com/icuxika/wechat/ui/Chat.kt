package com.icuxika.wechat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.icuxika.wechat.AppViewModel
import com.icuxika.wechat.data.Chat
import com.icuxika.wechat.ui.extension.unread
import com.icuxika.wechat.ui.theme.KtComposeWeChatTheme

@Composable
fun Chat(chatList: List<Chat>) {
    Column(
        modifier = Modifier
            .background(KtComposeWeChatTheme.colors.background)
            .fillMaxSize()
    ) {
        AppTopBar(title = "ICUXIKA")
        LazyColumn(modifier = Modifier.background(KtComposeWeChatTheme.colors.listItem)) {
            itemsIndexed(chatList) { index, chat ->
                ChatListItem(chat)
                if (index < chatList.lastIndex) {
                    Divider(
                        startIndent = 64.dp,
                        color = KtComposeWeChatTheme.colors.chatListDivider,
                        thickness = 0.8f.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun ChatListItem(chat: Chat) {
    val viewModel: AppViewModel = viewModel()
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            viewModel.startChat(chat = chat)
        }) {
        Image(
            painter = painterResource(id = chat.friend.avatar),
            contentDescription = chat.friend.name,
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp)
                .unread(!chat.messageList.last().read, KtComposeWeChatTheme.colors.badge)
                .clip(shape = RoundedCornerShape(4.dp))
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterVertically)
        ) {
            Text(
                text = chat.friend.name,
                fontSize = 18.sp,
                color = KtComposeWeChatTheme.colors.textPrimary
            )
            Text(
                text = chat.messageList.last().text,
                fontSize = 14.sp,
                color = KtComposeWeChatTheme.colors.textSecondary
            )
        }
        Text(
            text = chat.messageList.last().time,
            modifier = Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 12.sp,
            color = KtComposeWeChatTheme.colors.textSecondary
        )
    }
}
