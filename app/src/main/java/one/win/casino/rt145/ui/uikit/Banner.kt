package one.win.casino.rt145.ui.uikit

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.banner.BannerAdSize
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData

@Composable
fun Banner(
    adId: String = "ddfdfdfdfdf"
) {
    AndroidView(factory = { context ->
        BannerAdView(context).apply {
            setAdUnitId(adId)
            setAdSize(BannerAdSize.fixedSize(context, 400, 100))
            val adRequest = AdRequest.Builder().build()
            setBannerAdEventListener(object : BannerAdEventListener {
                override fun onAdLoaded() {
                    Log.d("LogAds", "onAdLoaded: ")
                }

                override fun onAdFailedToLoad(p0: AdRequestError) {
                    Log.d("LogAds", "onAdFailedToLoad: ")
                }

                override fun onAdClicked() {
                    Log.d("LogAds", "onAdClicked: ")
                }

                override fun onLeftApplication() {
                    Log.d("LogAds", "onLeftApplication: ")
                }

                override fun onReturnedToApplication() {
                    Log.d("LogAds", "onReturnedToApplication: ")
                }

                override fun onImpression(p0: ImpressionData?) {
                    Log.d("LogAds", "onImpression: ")
                }
            }
            )

            loadAd(adRequest)
        }

    })
}