package one.win.casino.rt145.domain.repository

import one.win.casino.rt145.domain.model.GameDataRt145
import one.win.casino.rt145.domain.utils.ResourceRt145

interface RemoteRepositoryRt145 {
    suspend fun sdgetFootballData(): ResourceRt145<List<GameDataRt145>>
    suspend fun vftGetIceHockeyData(): ResourceRt145<List<GameDataRt145>>
    suspend fun klmVtBasketballData(): ResourceRt145<List<GameDataRt145>>
    suspend fun getUrlRt145(): ResourceRt145<String>
    suspend fun getSharedUrlRt145(): String?
    suspend fun setSharedUrlRt145(date: String)
    suspend fun getFirstRt145(): Boolean
    suspend fun setFirstRt145(date: Boolean)
}