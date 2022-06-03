package com.hashconcepts.composecalculator.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hashconcepts.composecalculator.R

val allRoundGothic = FontFamily(
    listOf(
        Font(R.font.all_round_gothic_bold, FontWeight.Bold),
        Font(R.font.all_round_gothic_demi, FontWeight.SemiBold),
        Font(R.font.all_round_gothic_book, FontWeight.Normal),
    )
)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = allRoundGothic,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    h1 = TextStyle(
        fontFamily = allRoundGothic,
        fontWeight = FontWeight.SemiBold,
        fontSize = 35.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)