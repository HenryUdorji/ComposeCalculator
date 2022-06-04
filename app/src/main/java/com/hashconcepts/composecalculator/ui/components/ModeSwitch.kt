package com.hashconcepts.composecalculator.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hashconcepts.composecalculator.ui.screens.HomeScreen
import com.hashconcepts.composecalculator.ui.theme.ComposeCalculatorTheme

/**
 * @created 04/06/2022 - 4:01 PM
 * @project ComposeCalculator
 * @author  ifechukwu.udorji
 */
@Composable
fun ModeSwitch(
   mode: Boolean = false,
   onSwitched: () -> Unit
) {

}

@Preview(showBackground = true)
@Composable
fun ModeSwitchPreview() {
    ComposeCalculatorTheme {
        ModeSwitch(){}
    }
}