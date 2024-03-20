package one.win.casino.rt145

import android.app.Application
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import com.yandex.mobile.ads.common.MobileAds
import dagger.hilt.android.HiltAndroidApp
import one.win.casino.rt145.domain.utils.METRICA_RT_145


@HiltAndroidApp
class Rt145App:Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {}
        val config = YandexMetricaConfig.newConfigBuilder(METRICA_RT_145).build()
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
    }
}