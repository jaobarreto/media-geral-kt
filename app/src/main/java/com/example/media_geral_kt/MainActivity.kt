package com.example.media_geral_kt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.media_geral_kt.ui.theme.MediageralktTheme
import com.example.media_geral_kt.view.AlunoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MediageralktTheme {
                AlunoScreen()
            }
        }
    }
}