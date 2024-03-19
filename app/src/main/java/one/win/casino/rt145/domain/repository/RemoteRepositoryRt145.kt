package one.win.casino.rt145.domain.repository

import one.win.casino.rt145.domain.model.GameDataRt145
import one.win.casino.rt145.domain.utils.ResourceRt145

interface RemoteRepositoryRt145 {
    suspend fun getFootballData(): ResourceRt145<List<GameDataRt145>>
    suspend fun getIceHockeyData(): ResourceRt145<List<GameDataRt145>>
    suspend fun getBasketballData(): ResourceRt145<List<GameDataRt145>>
    suspend fun getUrl(): ResourceRt145<String>
    suspend fun getSharedUrl(): String?
    suspend fun setSharedUrl(date: String)
}