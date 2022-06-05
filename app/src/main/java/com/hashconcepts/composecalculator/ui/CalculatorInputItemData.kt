package com.hashconcepts.composecalculator.ui

import android.content.Context
import com.hashconcepts.composecalculator.R

/**
 * @created 04/06/2022 - 10:10 PM
 * @project ComposeCalculator
 * @author  ifechukwu.udorji
 */
data class CalculatorInputItemData(
    val symbol: String,
    val isEqualToSymbol: Boolean = false,
    val isBackSpaceSymbol: Boolean = false
)

val firstRow = listOf(
    CalculatorInputItemData("c"),
    CalculatorInputItemData("( )"),
    CalculatorInputItemData("%"),
    CalculatorInputItemData("/")
)
val secondRow = listOf(
    CalculatorInputItemData("7"),
    CalculatorInputItemData("8"),
    CalculatorInputItemData("9"),
    CalculatorInputItemData("+")
)
val thirdRow = listOf(
    CalculatorInputItemData("4"),
    CalculatorInputItemData("5"),
    CalculatorInputItemData("6"),
    CalculatorInputItemData("x")
)
val fourthRow = listOf(
    CalculatorInputItemData("1"),
    CalculatorInputItemData("2"),
    CalculatorInputItemData("3"),
    CalculatorInputItemData("-")
)
val fifthRow = listOf(
    CalculatorInputItemData("•"),
    CalculatorInputItemData("0"),
    CalculatorInputItemData("<-", isBackSpaceSymbol = true),
    CalculatorInputItemData("=", isEqualToSymbol = true)
)