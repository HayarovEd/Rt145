package one.win.casino.rt145.domain.model

data class GameDataRt145(
    val dateTime: String,
    val nameTournament: String,
    val homeName: String,
    val awayName: String,
    val homeScore: Int,
    val awayScore: Int,
    val statusGame: String,
)
