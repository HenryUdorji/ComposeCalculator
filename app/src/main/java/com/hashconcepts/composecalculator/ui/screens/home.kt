package com.hashconcepts.composecalculator.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hashconcepts.composecalculator.MainViewModel
import com.hashconcepts.composecalculator.ui.*
import com.hashconcepts.composecalculator.ui.components.CalculatorInputItem
import com.hashconcepts.composecalculator.ui.theme.ComposeCalculatorTheme
import com.hashconcepts.composecalculator.ui.theme.DarkSecondaryBackgroundColor
import com.hashconcepts.composecalculator.ui.theme.LightMainTextColor
import com.hashconcepts.composecalculator.ui.theme.SwitchTrackColor
import com.hashconcepts.composecalculator.util.CalculatorAction
import com.hashconcepts.composecalculator.util.CalculatorOperation

/**
 * @created 03/06/2022 - 9:47 PM
 * @project ComposeCalculator
 * @author  ifechukwu.udorji
 */

@Composable
fun HomeScreen() {
    val viewModel = viewModel<MainViewModel>()
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
            CalculatorOutputSection(viewModel)
            CalculatorInputSection(viewModel)
        }
    }
}

@Composable
fun CalculatorOutputSection(viewModel: MainViewModel) {
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 35.dp, bottom = 30.dp, end = 25.dp, start = 25.dp)
    ) {
        Text(
            text = viewModel.calculatorState.firstNumber,
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.Normal,
            maxLines = 1,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = viewModel.calculatorState.secondNumber,
            style = MaterialTheme.typography.h1,
            color = MaterialTheme.colors.primaryVariant,
            maxLines = 1
        )
    }
}

@Composable
fun ColumnScope.CalculatorInputSection(viewModel: MainViewModel) {
    val checkedState = remember { mutableStateOf(false) }


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
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = it
            })
        CalculatorInputItemSection(viewModel)
    }
}

@Composable
fun ColumnScope.CalculatorInputItemSection(viewModel: MainViewModel) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
    ) {
        InputRows(viewModel, firstRow)
        InputRows(viewModel, secondRow)
        InputRows(viewModel, thirdRow)
        InputRows(viewModel, fourthRow)
        InputRows(viewModel, fifthRow)
    }
}

@Composable
fun InputRows(viewModel: MainViewModel, rowItems: List<CalculatorInputItemData>) {
    var openParenthesis by remember { mutableStateOf(false) }

    LazyRow(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth(),
        content = {
            itemsIndexed(rowItems) { _, item ->
                CalculatorInputItem(calculatorInputData = item) {
                    when (item.symbol) {
                        "c" -> viewModel.onAction(CalculatorAction.Clear)
                        "." -> viewModel.onAction(CalculatorAction.Decimal)
                        "<-" -> viewModel.onAction(CalculatorAction.Backspace)
                        "=" -> viewModel.onAction(CalculatorAction.EqualTo)
                        "%" -> viewModel.onAction(CalculatorAction.Operations(CalculatorOperation.Modulo))
                        "/" -> viewModel.onAction(CalculatorAction.Operations(CalculatorOperation.Divide))
                        "( )" -> {
                            openParenthesis = if (openParenthesis) {
                                viewModel.onAction(CalculatorAction.Operations(CalculatorOperation.SecondBracket))
                                false
                            } else {
                                viewModel.onAction(CalculatorAction.Operations(CalculatorOperation.FirstBracket))
                                true
                            }
                        }
                        "x" -> viewModel.onAction(CalculatorAction.Operations(CalculatorOperation.Multiply))
                        "+" -> viewModel.onAction(CalculatorAction.Operations(CalculatorOperation.Add))
                        "-" -> viewModel.onAction(CalculatorAction.Operations(CalculatorOperation.Subtract))
                        "1" -> viewModel.onAction(CalculatorAction.Digit("1"))
                        "2" -> viewModel.onAction(CalculatorAction.Digit("2"))
                        "3" -> viewModel.onAction(CalculatorAction.Digit("3"))
                        "4" -> viewModel.onAction(CalculatorAction.Digit("4"))
                        "5" -> viewModel.onAction(CalculatorAction.Digit("5"))
                        "6" -> viewModel.onAction(CalculatorAction.Digit("6"))
                        "7" -> viewModel.onAction(CalculatorAction.Digit("7"))
                        "8" -> viewModel.onAction(CalculatorAction.Digit("8"))
                        "9" -> viewModel.onAction(CalculatorAction.Digit("9"))
                        "0" -> viewModel.onAction(CalculatorAction.Digit("0"))
                    }
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