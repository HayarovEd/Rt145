package one.win.casino.rt145.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.win.casino.rt145.data.remote.ApiRt145
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URL_ANALYTICS_RT_145 = "https://allsportsapi2.p.rapidapi.com/api/"
@Module
@InstallIn(SingletonComponent::class)
object RtApiModuleRt145 {
    @Provides
    @Singleton
    fun provideApiRt145(): ApiRt145 {
        return Retrofit.Builder()
            .baseUrl(URL_ANALYTICS_RT_145)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRt145::class.java)
    }

}