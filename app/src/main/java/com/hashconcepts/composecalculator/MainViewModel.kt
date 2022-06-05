package com.hashconcepts.composecalculator

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.hashconcepts.composecalculator.ui.screens.CalculatorUIState
import com.hashconcepts.composecalculator.util.CalculatorAction
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

/**
 * @created 05/06/2022 - 10:13 AM
 * @project ComposeCalculator
 * @author  ifechukwu.udorji
 */
class MainViewModel : ViewModel() {

    var calculatorState by mutableStateOf(CalculatorUIState())

    fun onAction(calculatorAction: CalculatorAction) {
        when(calculatorAction) {
            is CalculatorAction.Digit -> {
                calculatorState = calculatorState.copy(firstNumber = calculatorState.firstNumber + calculatorAction.digit)
            }
            is CalculatorAction.Decimal -> {
                calculatorState = calculatorState.copy(firstNumber = calculatorState.firstNumber + ".")
            }
            is CalculatorAction.Backspace -> {
                val expression = calculatorState.firstNumber
                if (expression.isNotEmpty()) {
                    calculatorState = calculatorState.copy(firstNumber = expression.substring(0, expression.length - 1))
                }
            }
            is CalculatorAction.Operations -> {
                calculatorState = calculatorState.copy(firstNumber = calculatorState.firstNumber + calculatorAction.operation.symbol)
            }
            is CalculatorAction.Clear -> calculatorState = CalculatorUIState()
            is CalculatorAction.EqualTo -> performCalculation()
        }
    }

    private fun performCalculation() {
        try {
            val expression = ExpressionBuilder(calculatorState.firstNumber).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            calculatorState = if (result == longResult.toDouble()) {
                calculatorState.copy(secondNumber = longResult.toString())
            } else {
                calculatorState.copy(secondNumber = result.toString())
            }
        } catch (e: Exception) {
            Log.d("VIEWMODEL", "performCalculation: ${e.localizedMessage}")
        }
    }
}