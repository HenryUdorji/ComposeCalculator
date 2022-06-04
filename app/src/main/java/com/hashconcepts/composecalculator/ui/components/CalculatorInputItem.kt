package com.hashconcepts.composecalculator.ui.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hashconcepts.composecalculator.R
import com.hashconcepts.composecalculator.ui.CalculatorInputItemData
import com.hashconcepts.composecalculator.ui.theme.AccentColor
import com.hashconcepts.composecalculator.ui.theme.ComposeCalculatorTheme

@Composable
fun CalculatorInputItem(
    calculatorInputData: CalculatorInputItemData,
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(60.dp)
            .clip(if (calculatorInputData.isEqualToSymbol) RoundedCornerShape(20.dp) else CircleShape)
            .background(if (calculatorInputData.isEqualToSymbol) AccentColor else MaterialTheme.colors.surface)
            .clickable(onClick = onClick)
    ) {
        if (calculatorInputData.isBackSpaceSymbol) {
            Icon(
                painter = painterResource(id = R.drawable.ic_backspace),
                contentDescription = "Back space",
                tint = MaterialTheme.colors.onSurface
            )
        } else {
            Text(
                text = calculatorInputData.symbol,
                style = MaterialTheme.typography.body1,
                color = if (calculatorInputData.isEqualToSymbol) Color.White else MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorInputItemPreview() {
    ComposeCalculatorTheme {
        val data = CalculatorInputItemData("0")
        CalculatorInputItem(data) {}
    }
}