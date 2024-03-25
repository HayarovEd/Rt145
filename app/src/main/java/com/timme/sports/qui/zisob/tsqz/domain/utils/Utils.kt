package com.timme.sports.qui.zisob.tsqz.domain.utils

import androidx.compose.ui.graphics.Color
import com.timme.sports.qui.zisob.tsqz.domain.model.DateFormattedRt145
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatTimestamp(timestamp: Long): String {
    val sdf = SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.getDefault())
    val date = Date(timestamp*1000)
    return sdf.format(date)
}

fun formatDate(date: Date): DateFormattedRt145 {
    val formatterDay = SimpleDateFormat("dd", Locale.getDefault())
    val formatterMonth = SimpleDateFormat("MM", Locale.getDefault())
    val formatterYear = SimpleDateFormat("yyyy", Locale.getDefault())
    return DateFormattedRt145(
        day = formatterDay.format(date),
        month = formatterMonth.format(date),
        year = formatterYear.format(date)
    )
}

fun Color.Companion.fromHex(colorString: String): Color {
    println("colorString: $colorString")
    return Color(android.graphics.Color.parseColor(colorString))
}
