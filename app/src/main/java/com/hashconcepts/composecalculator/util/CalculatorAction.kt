package com.hashconcepts.composecalculator.util

/**
 * @created 05/06/2022 - 9:45 AM
 * @project ComposeCalculator
 * @author  ifechukwu.udorji
 */
sealed class CalculatorAction {
    data class Digit(val digit: String): CalculatorAction()
    object Clear: CalculatorAction()
    object Backspace: CalculatorAction()
    object EqualTo: CalculatorAction()
    object Decimal: CalculatorAction()
    data class Operations(val operation: CalculatorOperation): CalculatorAction()
}
