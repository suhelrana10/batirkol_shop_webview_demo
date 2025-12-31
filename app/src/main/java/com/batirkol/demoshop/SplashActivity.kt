package com.batirkol.demoshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.batirkol.demoshop.ui.theme.BATIRKOLDemoShopTheme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BATIRKOLDemoShopTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    // Fade‑in animation for logo
                    val alpha by animateFloatAsState(
                        targetValue = 1f,
                        animationSpec = tween(durationMillis = 1500),
                        label = "logoAlpha"
                    )

                    // IMPORTANT: Use a drawable logo (PNG or vector), not mipmap/ic_launcher
                    Image(
                        painter = painterResource(id = R.drawable.logo), // <-- put logo.png in res/drawable
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .size(150.dp)
                            .graphicsLayer { this.alpha = alpha }
                    )
                }

                // Delay then navigate to MainActivity
                LaunchedEffect(Unit) {
                    delay(2000) // 2 seconds
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish() // prevent back navigation to splash
                }
            }
        }
    }
}
