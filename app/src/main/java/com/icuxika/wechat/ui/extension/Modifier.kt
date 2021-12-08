package com.icuxika.wechat.ui.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp

/**
 * 界面偏移
 */
fun Modifier.offsetPercent(offsetPercentX: Float = 0f, offsetPercentY: Float = 0f) =
    this.layout { measurable, constraints ->
        val placeable = measurable.measure(constraints = constraints)
        layout(placeable.width, placeable.height) {
            val offsetX = (offsetPercentX * placeable.width).toInt()
            val offsetY = (offsetPercentY * placeable.height).toInt()
            placeable.placeRelative(offsetX, offsetY)
        }
    }

/**
 * 消息未读徽章
 */
fun Modifier.unread(show: Boolean, color: Color): Modifier = this.drawWithContent {
    drawContent()
    if (show) {
        drawCircle(
            color = color,
            radius = 6.dp.toPx(),
            center = Offset(size.width - 1.dp.toPx(), 1.dp.toPx())
        )
    }
}
