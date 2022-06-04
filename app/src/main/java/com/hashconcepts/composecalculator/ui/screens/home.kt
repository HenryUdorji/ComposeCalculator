package com.hashconcepts.composecalculator.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hashconcepts.composecalculator.R
import com.hashconcepts.composecalculator.ui.*
import com.hashconcepts.composecalculator.ui.components.CalculatorInputItem
import com.hashconcepts.composecalculator.ui.theme.ComposeCalculatorTheme
import com.hashconcepts.composecalculator.ui.theme.DarkSecondaryBackgroundColor
import com.hashconcepts.composecalculator.ui.theme.LightMainTextColor
import com.hashconcepts.composecalculator.ui.theme.SwitchTrackColor

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
            .padding(top = 35.dp, bottom = 30.dp, end = 25.dp)
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
        Switch(
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
                .scale(2f)
                .size(100.dp),
            colors = SwitchDefaults.colors(
                checkedThumbColor = LightMainTextColor,
                checkedTrackColor = SwitchTrackColor
            ),
            checked = true,
            onCheckedChange = {
                //Todo -> Toggle mode
            })
        CalculatorInputItemSection()
    }
}

@Composable
fun ColumnScope.CalculatorInputItemSection() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
    ) {
        InputRows(firstRow)
        InputRows(secondRow)
        InputRows(thirdRow)
        InputRows(fourthRow)
        InputRows(fifthRow)
    }
}

@Composable
fun InputRows(rowItems: List<CalculatorInputItemData>) {
    val context = LocalContext.current
    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth(),
        content = {
            itemsIndexed(rowItems) { _, item ->
                CalculatorInputItem(calculatorInputData = item) {
                    Toast.makeText(context, item.symbol, Toast.LENGTH_SHORT).show()
                }
            }
        })
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DefaultPreview() {
    ComposeCalculatorTheme {
        HomeScreen()
    }
}