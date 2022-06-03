package com.hashconcepts.composecalculator.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = DarkBackgroundColor,
    primaryVariant = DarkMainTextColor,
    secondary = AccentColor,
    surface = DarkButtonBackgroundColor,
    onSurface = DarkSecondaryTextColor
)

private val LightColorPalette = lightColors(
    primary = LightBackgroundColor,
    primaryVariant = LightMainTextColor,
    secondary = AccentColor,
    surface = LightButtonBackgroundColor,
    onSurface = LightSecondaryTextColor

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ComposeCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}