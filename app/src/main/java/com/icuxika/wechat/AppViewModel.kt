package com.icuxika.wechat

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.icuxika.wechat.data.Chat
import com.icuxika.wechat.data.Message
import com.icuxika.wechat.data.User
import com.icuxika.wechat.ui.theme.KtComposeWeChatTheme

class AppViewModel : ViewModel() {

    /**
     * 当前主题
     */
    var theme by mutableStateOf(KtComposeWeChatTheme.Theme.Light)

    /**
     * 当前聊天
     */
    var currentChat: Chat? by mutableStateOf(null)

    /**
     * 当前正在聊天
     */
    var chatting by mutableStateOf(false)

    fun startChat(chat: Chat) {
        currentChat = chat
        chatting = true
    }

    fun endChat(): Boolean {
        if (chatting) {
            chatting = false
            return true
        }
        return false
    }

    fun boom(chat: Chat) {
        chat.messageList.add(Message(User.Me, "\uD83D\uDCA3", "15:10").apply { read = true })
    }

    /**
     * 会话列表模拟数据
     */
    var chatList by mutableStateOf(
        listOf(
            // List<Chat>
            Chat(
                friend = User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                mutableStateListOf(
                    Message(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "锄禾日当午",
                        "14:20"
                    ),
                    Message(User.Me, "汗滴禾下土", "14:20"),
                    Message(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "谁知盘中餐",
                        "14:20"
                    ),
                    Message(User.Me, "粒粒皆辛苦", "14:20"),
                    Message(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "唧唧复唧唧，木兰当户织。不闻机杼声，惟闻女叹息。",
                        "14:20"
                    ),
                    Message(User.Me, "双兔傍地走，安能辨我是雄雌？", "14:20"),
                    Message(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "床前明月光，疑是地上霜。",
                        "14:20"
                    ),
                    Message(User.Me, "吃饭吧？", "14:20"),
                )
            ),
            Chat(
                friend = User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian),
                mutableStateListOf(
                    Message(User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian), "哈哈哈", "13:48"),
                    Message(User.Me, "哈哈昂", "13:48"),
                    Message(
                        User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian),
                        "你笑个屁呀",
                        "13:48"
                    ).apply { read = false },
                )
            ),
        )
    )

    val contactList by mutableStateOf(
        listOf(
            User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
            User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian)
        )
    )
}