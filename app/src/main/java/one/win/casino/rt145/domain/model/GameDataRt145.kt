package one.win.casino.rt145.domain.model

import androidx.compose.ui.graphics.Color

data class GameDataRt145(
    val dateTimeRt145: String,
    val nameTournamentRt145: String,
    val homeNameRt145: String,
    val awayNameRt145: String,
    val homeScoreRt145: Int,
    val awayScoreRt145: Int,
    val statusGameRt145: String,
    val homeColor: Color,
    val awayColor: Color,
)
