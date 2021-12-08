package com.icuxika.wechat.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.icuxika.wechat.R
import com.icuxika.wechat.ui.extension.unread
import com.icuxika.wechat.ui.theme.KtComposeWeChatTheme

@Composable
fun Discovery() {
    Column(modifier = Modifier.fillMaxSize()) {
        DiscoveryTopBar()
        Box(
            modifier = Modifier
                .background(KtComposeWeChatTheme.colors.background)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .background(KtComposeWeChatTheme.colors.listItem)
                    .fillMaxWidth()
            ) {
                DiscoveryItem(R.drawable.ic_moments, "朋友圈", badge = {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(50))
                            .size(18.dp)
                            .background(KtComposeWeChatTheme.colors.badge)
                    ) {
                        Text(
                            "3",
                            modifier = Modifier.align(Alignment.Center),
                            fontSize = 12.sp,
                            color = KtComposeWeChatTheme.colors.onBadge
                        )
                    }
                }, endBadge = {
                    Image(
                        painter = painterResource(id = R.drawable.avatar_gaolaoshi),
                        "avatar",
                        Modifier
                            .padding(8.dp, 0.dp)
                            .size(32.dp)
                            .unread(false, KtComposeWeChatTheme.colors.badge)
                            .clip(RoundedCornerShape(4.dp))
                    )
                })
                Spacer(
                    modifier = Modifier
                        .background(KtComposeWeChatTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryItem(R.drawable.ic_channels, "视频号", endBadge = {
                    Image(
                        painter = painterResource(R.drawable.avatar_diuwuxian), "avatar", Modifier
                            .padding(8.dp, 0.dp)
                            .size(32.dp)
                            .unread(false, KtComposeWeChatTheme.colors.badge)
                            .clip(RoundedCornerShape(4.dp))
                    )
                    Text(
                        text = "赞过", modifier = Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp),
                        fontSize = 14.sp, color = KtComposeWeChatTheme.colors.textSecondary
                    )
                })
                Spacer(
                    modifier = Modifier
                        .background(KtComposeWeChatTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryItem(icon = R.drawable.ic_ilook, title = "看一看")
                Divider(
                    startIndent = 56.dp,
                    color = KtComposeWeChatTheme.colors.chatListDivider,
                    thickness = 0.8f.dp
                )
                DiscoveryItem(icon = R.drawable.ic_isearch, title = "搜一搜")
                Spacer(
                    modifier = Modifier
                        .background(KtComposeWeChatTheme.colors.background)
                        .fillMaxWidth()
                        .height(8.dp)
                )
                DiscoveryItem(icon = R.drawable.ic_nearby, title = "直播和附近")
            }
        }
    }
}

@Composable
fun DiscoveryTopBar() {
    AppTopBar(title = "发现")
}

@Composable
fun DiscoveryItem(
    @DrawableRes icon: Int,
    title: String,
    modifier: Modifier = Modifier,
    badge: @Composable (() -> Unit)? = null,
    endBadge: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(icon), "title", Modifier
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .size(36.dp)
                .padding(8.dp)
        )
        Text(
            text = title,
            fontSize = 17.sp,
            color = KtComposeWeChatTheme.colors.textPrimary
        )
        badge?.invoke()
        Spacer(modifier = Modifier.weight(1f))
        endBadge?.invoke()
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_more), contentDescription = "更多",
            modifier = Modifier
                .padding(0.dp, 0.dp, 12.dp, 0.dp)
                .size(16.dp),
            tint = KtComposeWeChatTheme.colors.more
        )
    }
}