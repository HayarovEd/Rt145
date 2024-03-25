package one.win.casino.rt145.data.mapper

import androidx.compose.ui.graphics.Color
import one.win.casino.rt145.data.remote.dto.RemoteFootballRt145
import one.win.casino.rt145.domain.model.GameDataRt145
import one.win.casino.rt145.domain.utils.formatTimestamp
import kotlin.random.Random


fun RemoteFootballRt145.toFootballRt145(): List<GameDataRt145> {
    return this.eventRt145s.map {
        GameDataRt145(
            awayNameRt145 = it.awayTeamRt145.name,
            homeNameRt145 = it.homeTeamRt145.name,
            awayScoreRt145 = it.awayScoreRt145.current,
            homeScoreRt145 = it.homeScoreRt145.current,
            dateTimeRt145 = formatTimestamp(it.startTimestamp.toLong()),
            nameTournamentRt145 = it.tournamentRt145.name,
            statusGameRt145 = setResultGame(it.statusRt145.type),
            homeColor = generateRandomColor(),
            awayColor = generateRandomColor(),
        )
    }
}

private fun setResultGame(remoteResult: String): String {
    return when (remoteResult) {
        "notstarted" -> "Ожидание"
        "inprogress" -> "Live"
        "finished" -> "Завершен"
        "canceled" -> "Отменен"
        else -> "Неизвестно"
    }
}

fun generateRandomColor(): Color {
    val random = Random
    val red = random.nextInt(256)
    val green = random.nextInt(256)
    val blue = random.nextInt(256)
    return Color(red, green, blue)
}