package com.hashconcepts.composecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hashconcepts.composecalculator.ui.screens.HomeScreen
import com.hashconcepts.composecalculator.ui.theme.ComposeCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCalculatorTheme {
                HomeScreen()
            }
        }
    }
}