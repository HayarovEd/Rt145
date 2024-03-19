package one.win.casino.rt145.data.resitory

import android.app.Application
import android.content.Context
import com.backendless.Backendless
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import one.win.casino.rt145.data.mapper.toFootballRt145
import one.win.casino.rt145.data.remote.ApiRt145
import one.win.casino.rt145.domain.model.GameDataRt145
import one.win.casino.rt145.domain.repository.RemoteRepositoryRt145
import one.win.casino.rt145.domain.utils.ANDROID_API_KEY
import one.win.casino.rt145.domain.utils.APPLICATION_ID
import one.win.casino.rt145.domain.utils.BACK_URL
import one.win.casino.rt145.domain.utils.NAME
import one.win.casino.rt145.domain.utils.OBJECT_ID_KEY
import one.win.casino.rt145.domain.utils.POLITIC_URL
import one.win.casino.rt145.domain.utils.ResourceRt145
import one.win.casino.rt145.domain.utils.SHARED_DATA
import one.win.casino.rt145.domain.utils.SHARED_URL
import one.win.casino.rt145.domain.utils.TABLE_NAME
import javax.inject.Inject

class RemoteRepositoryRt145Impl @Inject constructor(
    private val apiRt145: ApiRt145,
    private val application: Application
) : RemoteRepositoryRt145 {

    private val sharedPrefRt137 =
        application.getSharedPreferences(SHARED_DATA, Context.MODE_PRIVATE)

    override suspend fun getFootballData(): ResourceRt145<List<GameDataRt145>> {
        return try {
            val result = apiRt145.getRemoteFootball()
            ResourceRt145.Success(
                data = result.toFootballRt145()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt145.Error(e.message ?: "An unknown error")
        }
    }

    override suspend fun getIceHockeyData(): ResourceRt145<List<GameDataRt145>> {
        return try {
            val result = apiRt145.getRemoteIceHockey()
            ResourceRt145.Success(
                data = result.toFootballRt145()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt145.Error(e.message ?: "An unknown error")
        }
    }

    override suspend fun getBasketballData(): ResourceRt145<List<GameDataRt145>> {
        return try {
            val result = apiRt145.getRemoteBasketball()
            ResourceRt145.Success(
                data = result.toFootballRt145()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt145.Error(e.message ?: "An unknown error")
        }
    }

    override suspend fun getUrl(): ResourceRt145<String> {
        return try {
            withContext(Dispatchers.IO)
            {
                Backendless.setUrl(BACK_URL)
                Backendless.initApp(application, APPLICATION_ID, ANDROID_API_KEY)
                val result = Backendless.Data.of(TABLE_NAME).findById(OBJECT_ID_KEY)[NAME]
                if (result != null) {
                    try {
                        val client = OkHttpClient()
                        val request = Request.Builder()
                            .url(result.toString())
                            .get()
                            .addHeader("User-Agent", "Mozilla/5.0")
                            .build()
                        val response = client.newCall(request).execute()
                        if (response.isSuccessful) {
                            ResourceRt145.Success(response.request().url().toString())
                        } else {
                            ResourceRt145.Error("bad")
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        ResourceRt145.Error(e.message ?: "An unknown error")
                    }
                } else {
                    ResourceRt145.Error("empty data")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt145.Error(e.message ?: "An unknown error")
        }
    }

    override suspend fun getSharedUrl(): String? = sharedPrefRt137.getString(SHARED_URL, "")

    override suspend fun setSharedUrl(date: String) =
        sharedPrefRt137.edit().putString(SHARED_URL, date).apply()
}