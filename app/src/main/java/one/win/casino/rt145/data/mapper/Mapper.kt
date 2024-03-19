package one.win.casino.rt145.data.mapper

import one.win.casino.rt145.data.remote.dto.RemoteFootballRt145
import one.win.casino.rt145.domain.model.GameDataRt145
import one.win.casino.rt145.domain.utils.formatTimestamp


fun RemoteFootballRt145.toFootballRt145(): List <GameDataRt145> {
    return this.eventRt145s.map {
        GameDataRt145(
            awayName = it.awayTeamRt145.name,
            homeName = it.homeTeamRt145.name,
            awayScore = it.awayScoreRt145.current,
            homeScore = it.homeScoreRt145.current,
            dateTime = formatTimestamp(it.startTimestamp.toLong()),
            nameTournament = it.tournamentRt145.name,
            statusGame = it.statusRt145.type
        )
    }
}