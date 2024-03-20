package one.win.casino.rt145.data.remote

import one.win.casino.rt145.data.remote.dto.RemoteFootballRt145
import one.win.casino.rt145.domain.utils.RAPID_HOST_RT_145
import one.win.casino.rt145.domain.utils.RAPID_TOKEN_RT_145
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiRt145 {
    @GET("matches/{day}/{month}/{year}")
    suspend fun getRemoteFootball (
        @Header("X-RapidAPI-Key") rapidTokenRt145: String = RAPID_TOKEN_RT_145,
        @Header("X-RapidAPI-Host") rapidHostRt145: String = RAPID_HOST_RT_145,
        @Path("day") day: String,
        @Path("month") month: String,
        @Path("year") year: String
    ) : RemoteFootballRt145

    @GET("ice-hockey/matches/{day}/{month}/{year}")
    suspend fun getRemoteIceHockey (
        @Header("X-RapidAPI-Key") rapidTokenRt145: String = RAPID_TOKEN_RT_145,
        @Header("X-RapidAPI-Host") rapidHostRt145: String = RAPID_HOST_RT_145,
        @Path("day") day: String,
        @Path("month") month: String,
        @Path("year") year: String
    ) : RemoteFootballRt145

    @GET("basketball/matches/{day}/{month}/{year}")
    suspend fun getRemoteBasketball (
        @Header("X-RapidAPI-Key") rapidTokenRt145: String = RAPID_TOKEN_RT_145,
        @Header("X-RapidAPI-Host") rapidHostRt145: String = RAPID_HOST_RT_145,
        @Path("day") day: String,
        @Path("month") month: String,
        @Path("year") year: String
    ) : RemoteFootballRt145
}