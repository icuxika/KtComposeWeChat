package com.icuxika.wechat.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.icuxika.wechat.R
import com.icuxika.wechat.data.User
import com.icuxika.wechat.ui.theme.KtComposeWeChatTheme

@Composable
fun Account() {
    Box(
        modifier = Modifier
            .background(KtComposeWeChatTheme.colors.background)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(KtComposeWeChatTheme.colors.listItem)
                .fillMaxSize()
        ) {
            AccountTopBar()
            Spacer(
                modifier = Modifier
                    .background(KtComposeWeChatTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            AccountItem(icon = R.drawable.ic_pay, title = "支付")
            Spacer(
                modifier = Modifier
                    .background(KtComposeWeChatTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            AccountItem(icon = R.drawable.ic_collections, title = "收藏")
            Divider(
                startIndent = 64.dp,
                color = KtComposeWeChatTheme.colors.chatListDivider,
                thickness = 0.8f.dp
            )
            AccountItem(icon = R.drawable.ic_photos, title = "朋友圈")
            Divider(
                startIndent = 64.dp,
                color = KtComposeWeChatTheme.colors.chatListDivider,
                thickness = 0.8f.dp
            )
            AccountItem(icon = R.drawable.ic_cards, title = "卡包")
            Divider(
                startIndent = 64.dp,
                color = KtComposeWeChatTheme.colors.chatListDivider,
                thickness = 0.8f.dp
            )
            AccountItem(icon = R.drawable.ic_stickers, title = "表情")
            Spacer(
                modifier = Modifier
                    .background(KtComposeWeChatTheme.colors.background)
                    .fillMaxWidth()
                    .height(8.dp)
            )
            AccountItem(icon = R.drawable.ic_settings, title = "设置")
        }
    }
}

@Composable
fun AccountTopBar() {
    Row(
        modifier = Modifier
            .background(KtComposeWeChatTheme.colors.listItem)
            .fillMaxWidth()
            .height(224.dp)
    ) {
        Image(
            painterResource(id = R.drawable.avatar_rengwuxian),
            contentDescription = "Me",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 24.dp)
                .clip(RoundedCornerShape(8.dp))
                .size(64.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        ) {
            Text(
                text = User.Me.name,
                modifier = Modifier.padding(top = 64.dp),
                color = KtComposeWeChatTheme.colors.textPrimary,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "微信号: ${User.Me.id}",
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 16.sp,
                color = KtComposeWeChatTheme.colors.textSecondary
            )
            Text(
                text = "+ 状态",
                modifier = Modifier
                    .padding(top = 16.dp)
                    .border(
                        1.dp, KtComposeWeChatTheme.colors.onBackground,
                        RoundedCornerShape(48)
                    )
                    .padding(8.dp, 2.dp),
                fontSize = 16.sp,
                color = KtComposeWeChatTheme.colors.onBackground
            )
        }
        Icon(
            painterResource(id = R.drawable.ic_qrcode), contentDescription = "qrcode",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 24.dp)
                .size(16.dp),
            tint = KtComposeWeChatTheme.colors.onBackground
        )
        Icon(
            painterResource(id = R.drawable.ic_arrow_more), contentDescription = "更多",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(end = 24.dp)
                .size(16.dp),
            tint = KtComposeWeChatTheme.colors.more
        )
    }
}

@Composable
fun AccountItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null,
) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painterResource(id = icon), contentDescription = title,
            modifier = Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .padding(8.dp)
        )

        Text(
            text = title,
            fontSize = 18.sp,
            color = KtComposeWeChatTheme.colors.textPrimary
        )

        badge?.invoke()

        Spacer(modifier = Modifier.weight(1f))

        endBadge?.invoke()

        Icon(
            painterResource(id = R.drawable.ic_arrow_more), contentDescription = "更多",
            modifier = Modifier
                .padding(0.dp, 0.dp, 12.dp, 0.dp)
                .size(16.dp),
            tint = KtComposeWeChatTheme.colors.more
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AccountPreview() {
    KtComposeWeChatTheme {
        Account()
    }
}
