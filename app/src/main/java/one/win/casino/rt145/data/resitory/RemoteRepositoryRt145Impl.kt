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
import one.win.casino.rt145.domain.utils.ANDROID_API_KEY_RT_145
import one.win.casino.rt145.domain.utils.APPLICATION_ID_RT_145
import one.win.casino.rt145.domain.utils.BACK_URL_RT_145
import one.win.casino.rt145.domain.utils.NAME_RT_145
import one.win.casino.rt145.domain.utils.OBJECT_ID_KEY_RT_145
import one.win.casino.rt145.domain.utils.ResourceRt145
import one.win.casino.rt145.domain.utils.SHARED_DATA_RT_145
import one.win.casino.rt145.domain.utils.SHARED_URL_RT_145
import one.win.casino.rt145.domain.utils.TABLE_NAME_RT_145
import one.win.casino.rt145.domain.utils.UNKNOWN_ERROR_RT_145
import javax.inject.Inject

class RemoteRepositoryRt145Impl @Inject constructor(
    private val apiRt145: ApiRt145,
    private val application: Application
) : RemoteRepositoryRt145 {

    private val sharedPrefRt137 =
        application.getSharedPreferences(SHARED_DATA_RT_145, Context.MODE_PRIVATE)

    override suspend fun getFootballData(): ResourceRt145<List<GameDataRt145>> {
        return try {
            val result = apiRt145.getRemoteFootball()
            ResourceRt145.Success(
                data = result.toFootballRt145()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt145.Error(e.message ?: UNKNOWN_ERROR_RT_145)
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
            ResourceRt145.Error(e.message ?: UNKNOWN_ERROR_RT_145)
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
            ResourceRt145.Error(e.message ?: UNKNOWN_ERROR_RT_145)
        }
    }

    override suspend fun getUrlRt145(): ResourceRt145<String> {
        return try {
            withContext(Dispatchers.IO)
            {
                Backendless.setUrl(BACK_URL_RT_145)
                Backendless.initApp(application, APPLICATION_ID_RT_145, ANDROID_API_KEY_RT_145)
                val result = Backendless.Data.of(TABLE_NAME_RT_145).findById(OBJECT_ID_KEY_RT_145)[NAME_RT_145]
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
                        ResourceRt145.Error(e.message ?: UNKNOWN_ERROR_RT_145)
                    }
                } else {
                    ResourceRt145.Error("empty data")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            ResourceRt145.Error(e.message ?: UNKNOWN_ERROR_RT_145)
        }
    }

    override suspend fun getSharedUrlRt145(): String? = sharedPrefRt137.getString(SHARED_URL_RT_145, "")

    override suspend fun setSharedUrlRt145(date: String) =
        sharedPrefRt137.edit().putString(SHARED_URL_RT_145, date).apply()
}