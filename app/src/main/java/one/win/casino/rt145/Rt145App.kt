package one.win.casino.rt145

import android.app.Application
import com.yandex.mobile.ads.common.MobileAds



class Rt145App:Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this) {}
    }
}