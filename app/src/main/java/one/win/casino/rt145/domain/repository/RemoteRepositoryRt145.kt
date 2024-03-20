package one.win.casino.rt145.domain.repository

import one.win.casino.rt145.domain.model.GameDataRt145
import one.win.casino.rt145.domain.utils.ResourceRt145

interface RemoteRepositoryRt145 {
    suspend fun getFootballData(): ResourceRt145<List<GameDataRt145>>
    suspend fun getIceHockeyData(): ResourceRt145<List<GameDataRt145>>
    suspend fun getBasketballData(): ResourceRt145<List<GameDataRt145>>
    suspend fun getUrlRt145(): ResourceRt145<String>
    suspend fun getSharedUrlRt145(): String?
    suspend fun setSharedUrlRt145(date: String)
}