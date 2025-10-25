package com.example.nivelver20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.example.nivelver20.navigation.AppNavigation
import com.example.nivelver20.ui.theme.NivelVer20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                scrim = Color(0xFF02214a).toArgb()
            ),
            navigationBarStyle = SystemBarStyle.dark(
                scrim = Color(0xFF02214a).toArgb()
            )
        )

        setContent {
            NivelVer20Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    AppNavigation()
                }
            }
        }
    }
}