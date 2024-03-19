package one.win.casino.rt145.data.remote.dto


import com.google.gson.annotations.SerializedName

data class EventRt145(
    @SerializedName("awayScore")
    val awayScoreRt145: AwayScoreRt145,
    @SerializedName("awayTeam")
    val awayTeamRt145: AwayTeamRt145,
    @SerializedName("homeScore")
    val homeScoreRt145: HomeScoreRt145,
    @SerializedName("homeTeam")
    val homeTeamRt145: HomeTeamRt145,
    @SerializedName("startTimestamp")
    val startTimestamp: Int,
    @SerializedName("status")
    val statusRt145: StatusRt145,
    @SerializedName("tournament")
    val tournamentRt145: TournamentRt145,
)