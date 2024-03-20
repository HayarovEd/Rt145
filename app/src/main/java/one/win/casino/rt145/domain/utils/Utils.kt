package one.win.casino.rt145.domain.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale
import one.win.casino.rt145.domain.model.DateFormattedRt145

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
