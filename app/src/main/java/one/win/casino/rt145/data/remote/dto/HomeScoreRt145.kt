package one.win.casino.rt145.data.remote.dto


import com.google.gson.annotations.SerializedName

data class HomeScoreRt145(
    @SerializedName("current")
    val current: Int,
)