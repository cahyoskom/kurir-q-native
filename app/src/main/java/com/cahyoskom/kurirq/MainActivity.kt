package com.cahyoskom.kurirq

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var wv: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wv = WebView(this)
        setContentView(wv)

        with(wv.settings) {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            allowFileAccess = true
            allowFileAccessFromFileURLs = true
            allowUniversalAccessFromFileURLs = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        wv.webViewClient = object : WebViewClient() {
            override fun onReceivedError(v: WebView?, r: WebResourceRequest?, e: WebResourceError?) {
                Toast.makeText(this@MainActivity, "ERROR: ${e?.description}", Toast.LENGTH_LONG).show()
            }
        }

        wv.webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(msg: ConsoleMessage?): Boolean {
                Toast.makeText(this@MainActivity, "JS: ${msg?.message()}", Toast.LENGTH_SHORT).show()
                return true
            }
        }

        // Load dengan try-catch
        try {
            wv.loadUrl("file:///android_asset/www/index.html")
        } catch (e: Exception) {
            wv.loadData("<h1>CRASH: ${e.message}</h1>", "text/html", "UTF-8")
        }
    }
}