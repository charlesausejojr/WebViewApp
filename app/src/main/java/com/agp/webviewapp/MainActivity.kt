package com.agp.webviewapp

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setAlertDialogList()
    }
    private fun setAlertDialogList() {
        //Traditional List - single choice
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val items: Array<String> = resources.getStringArray(R.array.web_list)
            AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_web)
                .setTitle("Pick a path")
                .setItems(items) { dialog, which ->
                    val intent = Intent(this, SecondActivity::class.java)
                    when(items[which]){
                        "Google" -> intent.putExtra("url","https://www.google.com")
                        "Youtube" -> intent.putExtra("url","https://www.youtube.com/")
                        "TikTok" -> intent.putExtra("url","https://www.tiktok.com/en/")
                        "Stack Overflow" -> intent.putExtra("url","https://stackoverflow.com/")
                        "ABS-CBN" -> intent.putExtra("url","https://www.youtube.com/watch?v=dQw4w9WgXcQ")
                        else -> Toast.makeText(this, "Error! Try Again.", Toast.LENGTH_SHORT).show()
                    }
                    startActivity(intent)
                }
                .show()
        }
    }
}