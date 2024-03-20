package one.win.casino.rt145.data.mapper

import one.win.casino.rt145.data.remote.dto.RemoteFootballRt145
import one.win.casino.rt145.domain.model.GameDataRt145
import one.win.casino.rt145.domain.utils.formatTimestamp


fun RemoteFootballRt145.toFootballRt145(): List <GameDataRt145> {
    return this.eventRt145s.map {
        GameDataRt145(
            awayNameRt145 = it.awayTeamRt145.name,
            homeNameRt145 = it.homeTeamRt145.name,
            awayScoreRt145 = it.awayScoreRt145.current,
            homeScoreRt145 = it.homeScoreRt145.current,
            dateTimeRt145 = formatTimestamp(it.startTimestamp.toLong()),
            nameTournamentRt145 = it.tournamentRt145.name,
            statusGameRt145 = it.statusRt145.type
        )
    }
}