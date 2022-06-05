package com.hashconcepts.composecalculator.util

/**
 * @created 05/06/2022 - 9:51 AM
 * @project ComposeCalculator
 * @author  ifechukwu.udorji
 */
sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("*")
    object Divide: CalculatorOperation("/")
    object Modulo: CalculatorOperation("%")
    object FirstBracket: CalculatorOperation("(")
    object SecondBracket: CalculatorOperation(")")
}
