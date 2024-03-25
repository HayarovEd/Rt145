package com.timme.sports.qui.zisob.tsqz.data.remote.dto


import com.google.gson.annotations.SerializedName

data class RemoteFootballRt145(
    @SerializedName("events")
    val eventRt145s: List<EventRt145>,
)