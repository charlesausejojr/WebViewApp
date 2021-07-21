package com.agp.webviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val url = intent.getStringExtra("url")
        val webView: WebView = findViewById(R.id.webView)

        webView.webViewClient = WebViewClient()
        if (url != null) {
            webView.loadUrl(url)
        }

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }
    override fun onBackPressed() {
        val webView: WebView = findViewById(R.id.webView)
        if (webView!!.canGoBack()){
            webView.goBack()
        }else {
            super.onBackPressed()
        }
    }
}