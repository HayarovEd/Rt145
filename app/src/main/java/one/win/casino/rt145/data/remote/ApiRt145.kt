package one.win.casino.rt145.data.remote

import one.win.casino.rt145.data.remote.dto.RemoteFootballRt145
import one.win.casino.rt145.domain.utils.RAPID_HOST
import one.win.casino.rt145.domain.utils.RAPID_TOKEN
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiRt145 {
    @GET("player/826643/matches/previous/0")
    suspend fun getRemoteFootball (
        @Header("X-RapidAPI-Key") rapidToken: String = RAPID_TOKEN,
        @Header("X-RapidAPI-Host") rapidHost: String = RAPID_HOST,
    ) : RemoteFootballRt145

    @GET("ice-hockey/player/898262/matches/previous/0")
    suspend fun getRemoteIceHockey (
        @Header("X-RapidAPI-Key") rapidToken: String = RAPID_TOKEN,
        @Header("X-RapidAPI-Host") rapidHost: String = RAPID_HOST,
    ) : RemoteFootballRt145

    @GET("basketball/player/817050/matches/previous/0")
    suspend fun getRemoteBasketball (
        @Header("X-RapidAPI-Key") rapidToken: String = RAPID_TOKEN,
        @Header("X-RapidAPI-Host") rapidHost: String = RAPID_HOST,
    ) : RemoteFootballRt145
}