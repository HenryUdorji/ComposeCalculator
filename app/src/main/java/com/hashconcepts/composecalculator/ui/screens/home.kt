package com.hashconcepts.composecalculator.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hashconcepts.composecalculator.ui.theme.ComposeCalculatorTheme
import com.hashconcepts.composecalculator.ui.theme.DarkSecondaryBackgroundColor

/**
 * @created 03/06/2022 - 9:47 PM
 * @project ComposeCalculator
 * @author  ifechukwu.udorji
 */

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary),
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Calculator",
                style = MaterialTheme.typography.h1,
                color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
            CalculatorOutputSection()
            CalculatorInputSection()
        }
    }
}

@Composable
fun CalculatorOutputSection() {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp, bottom = 20.dp, end = 25.dp)
    ) {
        Text(
            text = "34+4/8*5",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "18.8",
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primaryVariant
        )
    }
}

@Composable
fun ColumnScope.CalculatorInputSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .clip(RoundedCornerShape(topStart = 100.dp, topEnd = 100.dp))
            .background(if (isSystemInDarkTheme()) DarkSecondaryBackgroundColor else Color.White)
    ) {

    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DefaultPreview() {
    ComposeCalculatorTheme {
        HomeScreen()
    }
}