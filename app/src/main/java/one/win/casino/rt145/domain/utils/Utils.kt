package one.win.casino.rt145.domain.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatTimestamp(timestamp: Long): String {
    val sdf = SimpleDateFormat("dd MMMM yyyy HH:mm", Locale.getDefault())
    val date = Date(timestamp)
    return sdf.format(date)
}
