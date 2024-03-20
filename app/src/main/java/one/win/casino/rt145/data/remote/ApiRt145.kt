package one.win.casino.rt145.data.remote

import one.win.casino.rt145.data.remote.dto.RemoteFootballRt145
import one.win.casino.rt145.domain.utils.RAPID_HOST_RT_145
import one.win.casino.rt145.domain.utils.RAPID_TOKEN_RT_145
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiRt145 {
    @GET("player/826643/matches/previous/0")
    suspend fun getRemoteFootball (
        @Header("X-RapidAPI-Key") rapidTokenRt145: String = RAPID_TOKEN_RT_145,
        @Header("X-RapidAPI-Host") rapidHostRt145: String = RAPID_HOST_RT_145,
    ) : RemoteFootballRt145

    @GET("ice-hockey/player/898262/matches/previous/0")
    suspend fun getRemoteIceHockey (
        @Header("X-RapidAPI-Key") rapidTokenRt145: String = RAPID_TOKEN_RT_145,
        @Header("X-RapidAPI-Host") rapidHostRt145: String = RAPID_HOST_RT_145,
    ) : RemoteFootballRt145

    @GET("basketball/player/817050/matches/previous/0")
    suspend fun getRemoteBasketball (
        @Header("X-RapidAPI-Key") rapidTokenRt145: String = RAPID_TOKEN_RT_145,
        @Header("X-RapidAPI-Host") rapidHostRt145: String = RAPID_HOST_RT_145,
    ) : RemoteFootballRt145
}