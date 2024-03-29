package com.timme.sports.qui.zisob.tsqz.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.os.Parcelable
import android.provider.MediaStore
import android.util.Log
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.MimeTypeMap
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import com.timme.sports.qui.zisob.tsqz.ui.state.ApplicationStRt145
import com.timme.sports.qui.zisob.tsqz.ui.state.MainEventRt145
import com.timme.sports.qui.zisob.tsqz.ui.theme.whiteRt145

private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
private var imageOutputFileUri: Uri? = null

private const val BASE_U = "evernote://share"


@Composable
fun WebViewScreen(
    modifier: Modifier = Modifier,
    url: String,
    onEvent: (MainEventRt145) -> Unit,
) {
    val activityResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.data != null) {
            result.data?.data?.let { uri ->
                mFilePathCallback?.onReceiveValue(arrayOf(uri))
            }
        } else {
            imageOutputFileUri?.let { uri ->
                mFilePathCallback?.onReceiveValue(arrayOf(uri))
            }
        }
    }
    val context = LocalContext.current
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = whiteRt145)
    ) {
        AndroidView(
            modifier = modifier.padding(4.dp),
            factory = {
                WebView(it).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = object  :WebViewClient() {
                        override fun shouldOverrideUrlLoading(
                            view: WebView?,
                            request: WebResourceRequest?
                        ): Boolean {
                            if (request?.url!=null) {
                                if (request.url.toString().startsWith(BASE_U))
                                    return true
                                else {
                                    val reqUri: Uri = request.url
                                    val scheme = reqUri.scheme
                                    if (!scheme.equals("https") && !scheme.equals("http")) {
                                        val newIntent =
                                            Intent.parseUri(
                                                reqUri.toString(),
                                                Intent.URI_INTENT_SCHEME
                                            )
                                        return try {
                                            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                            startActivity(it, newIntent, null)
                                            true
                                        } catch (exc: Exception) {
                                            false
                                        }
                                    }
                                    return false
                                }
                            } else return false
                        }
                    }
                    webChromeClient = object : WebChromeClient() {

                        override fun onShowFileChooser(
                            webView: WebView?,
                            filePathCallback: ValueCallback<Array<Uri>>?,
                            fileChooserParams: FileChooserParams?
                        ): Boolean {

                            val acceptTypes = fileChooserParams!!.acceptTypes
                            val allowMultiple =
                                fileChooserParams!!.mode === FileChooserParams.MODE_OPEN_MULTIPLE
                            val captureEnabled = fileChooserParams.isCaptureEnabled

                            return startPickerIntent(
                                callback = filePathCallback,
                                acceptTypes = acceptTypes,
                                allowMultiple = allowMultiple,
                                activityResultLauncher = activityResultLauncher,
                                context = context
                            )
                        }


                    }
                    settings.domStorageEnabled = true
                    settings.javaScriptCanOpenWindowsAutomatically = true
                    settings.javaScriptEnabled = true
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    settings.domStorageEnabled = true
                    settings.databaseEnabled = true
                    settings.setSupportZoom(false)
                    settings.allowFileAccess = true
                    settings.allowContentAccess = true
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true

                    settings.domStorageEnabled = true
                    settings.javaScriptCanOpenWindowsAutomatically = true
                    val cookieManager = CookieManager.getInstance()
                    cookieManager.setAcceptCookie(true)
                    settings.javaScriptEnabled = true
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true
                    settings.domStorageEnabled = true
                    settings.databaseEnabled = true
                    settings.setSupportZoom(false)
                    settings.allowFileAccess = true
                    settings.allowContentAccess = true
                    settings.loadWithOverviewMode = true
                    settings.useWideViewPort = true

                    onBackPressedDispatcher?.addCallback {
                        if (this@apply.canGoBack()) {
                            this@apply.goBack()
                        } else {
                            onEvent(MainEventRt145.OnSetScreenState(ApplicationStRt145.EnterRt145))
                        }
                    }
                    loadUrl(url)
                }
            }, update = {
                it.loadUrl(url)
            })
    }
}

private fun startPickerIntent(
    callback: ValueCallback<Array<Uri>>?,
    acceptTypes: Array<String>,
    allowMultiple: Boolean?,
    activityResultLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    context: Context
): Boolean {
    mFilePathCallback = callback;
    val extraIntents = ArrayList<Parcelable>()
    extraIntents.add(
        getPhotoIntent(
            //activityResultLauncher = activityResultLauncher,
            context = context
        )
    )
    val fileSelectionIntent = getFileChooserIntent(acceptTypes, allowMultiple)
    val pickerIntent = Intent(Intent.ACTION_CHOOSER)
    pickerIntent.putExtra(Intent.EXTRA_INTENT, fileSelectionIntent);
    pickerIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, extraIntents.toTypedArray())
    activityResultLauncher.launch(pickerIntent)
    return true
}

private fun getPhotoIntent(
    //activityResultLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    context: Context
): Intent {
    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    imageOutputFileUri = getOutputUri(
        intentType = MediaStore.ACTION_IMAGE_CAPTURE,
        //activityResultLauncher = activityResultLauncher,
        context = context
    )
    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageOutputFileUri)
    return intent
}

private fun getOutputUri(
    intentType: String,
    //activityResultLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    context: Context
): Uri? {
    var capturedFile: File? = null
    try {
        capturedFile = getCapturedFile(
            intentType = intentType,
            //activityResultLauncher = activityResultLauncher,
            context = context
        )
    } catch (e: IOException) {
        Log.e("web_view", "Error occurred while creating the File", e);
        e.printStackTrace()
    }
    if (capturedFile == null) {
        return null
    }
    // for versions below 6.0 (23) we use the old File creation & permissions model
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        return Uri.fromFile(capturedFile)
    }
    // for versions 6.0+ (23) we use the FileProvider to avoid runtime permissions
    val fileProviderAuthority: String =
        context.packageName + "." + "webview.fileprovider"
    return FileProvider.getUriForFile(
        context,
        fileProviderAuthority,
        capturedFile
    )
}


@Throws(IOException::class)
private fun getCapturedFile(
    intentType: String,
    //activityResultLauncher: ManagedActivityResultLauncher<Intent, ActivityResult>,
    context: Context
): File? {
    var prefix = ""
    var suffix = ""
    var dir = ""
    if (intentType == MediaStore.ACTION_IMAGE_CAPTURE) {
        prefix = "image"
        suffix = ".jpg"
        dir = Environment.DIRECTORY_PICTURES
    } else if (intentType == MediaStore.ACTION_VIDEO_CAPTURE) {
        prefix = "video"
        suffix = ".mp4"
        dir = Environment.DIRECTORY_MOVIES
    }

    // for versions below 6.0 (23) we use the old File creation & permissions model
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
        // only this Directory works on all tested Android versions
        // ctx.getExternalFilesDir(dir) was failing on Android 5.0 (sdk 21)
        val storageDir: File =
            Environment.getExternalStoragePublicDirectory(dir)
        val filename =
            String.format("%s-%d%s", prefix, System.currentTimeMillis(), suffix)
        return File(storageDir, filename)
    }
    val storageDir =
        context.getExternalFilesDir(null)
    return File.createTempFile(prefix, suffix, storageDir)
}

private fun getFileChooserIntent(
    acceptTypes: Array<String>,
    allowMultiple: Boolean?
): Intent {
    val intent = Intent(Intent.ACTION_GET_CONTENT)
    intent.addCategory(Intent.CATEGORY_OPENABLE)
    intent.type = "*/*"
    intent.putExtra(Intent.EXTRA_MIME_TYPES, getAcceptedMimeType(acceptTypes))
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, allowMultiple)
    return intent
}

private fun getAcceptedMimeType(types: Array<String>): Array<String?>? {
    if (types.isEmpty()) {
        val DEFAULT_MIME_TYPES = "*/*";
        return arrayOf(DEFAULT_MIME_TYPES)
    }
    val mimeTypes = arrayOfNulls<String>(types.size)
    for (i in types.indices) {
        val t = types[i]
        val regex = Regex("\\.\\w+")
        if (t.matches(regex)) {
            val oldValue = ".";
            val newValue = "";
            val mimeType = getMimeTypeFromExtension(t.replace(oldValue, newValue))
            mimeTypes[i] = mimeType
        } else {
            mimeTypes[i] = t
        }
    }
    return mimeTypes
}

private fun getMimeTypeFromExtension(extension: String?): String? {
    var type: String? = null
    if (extension != null) {
        type = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension)
    }
    return type
}