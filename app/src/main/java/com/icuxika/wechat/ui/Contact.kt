package com.icuxika.wechat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.icuxika.wechat.R
import com.icuxika.wechat.data.User
import com.icuxika.wechat.ui.theme.KtComposeWeChatTheme

@Composable
fun Contact(viewModel: AppViewModel = viewModel()) {
    Column(modifier = Modifier.fillMaxSize()) {
        ContactTopBar()
        Box(
            modifier = Modifier
                .background(color = KtComposeWeChatTheme.colors.background)
                .fillMaxSize()
        ) {
            ContactList(contactList = viewModel.contactList)
        }
    }
}

@Composable
fun ContactTopBar() {
    AppTopBar(title = "通讯录")
}

@Composable
fun ContactItem(
    contact: User,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(contact.avatar), "avatar", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Text(
            text = contact.name,
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            fontSize = 17.sp,
            color = KtComposeWeChatTheme.colors.textPrimary
        )
    }
}


@Composable
fun ContactList(contactList: List<User>) {
    LazyColumn(
        modifier = Modifier
            .background(color = KtComposeWeChatTheme.colors.listItem)
            .fillMaxWidth()
    ) {
        val buttonList = listOf(
            User("contact_add", "新的朋友", R.drawable.ic_contact_add),
            User("contact_chat", "仅聊天", R.drawable.ic_contact_chat),
            User("contact_group", "群聊", R.drawable.ic_contact_group),
            User("contact_tag", "标签", R.drawable.ic_contact_tag),
            User("contact_official", "公众号", R.drawable.ic_contact_official),
        )
        itemsIndexed(buttonList) { index, contact ->
            ContactItem(contact)
            if (index < buttonList.size - 1) {
                Divider(
                    startIndent = 56.dp,
                    color = KtComposeWeChatTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
            }
        }
        item {
            Text(
                text = "朋友",
                modifier = Modifier
                    .background(KtComposeWeChatTheme.colors.background)
                    .fillMaxWidth()
                    .padding(12.dp, 8.dp),
                fontSize = 14.sp,
                color = KtComposeWeChatTheme.colors.onBackground
            )
        }
        itemsIndexed(contactList) { index, contact ->
            ContactItem(contact)
            if (index < contactList.size - 1) {
                Divider(
                    startIndent = 56.dp,
                    color = KtComposeWeChatTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
            }
        }
    }
}