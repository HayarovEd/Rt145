package com.timme.sports.qui.zisob.tsqz.domain.repository

import com.timme.sports.qui.zisob.tsqz.domain.model.GameDataRt145
import com.timme.sports.qui.zisob.tsqz.domain.utils.ResourceRt145

interface RemoteRepositoryRt145 {
    suspend fun sdgetFootballData(): ResourceRt145<List<GameDataRt145>> {
        return ResourceRt145.Success(listOf())
    }
    suspend fun vftGetIceHockeyData(): ResourceRt145<List<GameDataRt145>> {
        return ResourceRt145.Success(listOf())
    }
    suspend fun klmVtBasketballData(): ResourceRt145<List<GameDataRt145>> {
        return ResourceRt145.Success(listOf())
    }
    suspend fun getUrlRt145(): ResourceRt145<String> {
        return ResourceRt145.Success("")
    }
    suspend fun getSharedUrlRt145(): String? {
        return "hh"
    }
    suspend fun setSharedUrlRt145(date: String) {
        println("setSharedUrlRt14ff544")
    }
    suspend fun getFirstRt145(): Boolean {
        println("setSharedUrlRt1ff4544")
        return true
    }
    suspend fun setFirstRt145(date: Boolean) {
        println("setSharedUrlRt14ff544")
    }
}