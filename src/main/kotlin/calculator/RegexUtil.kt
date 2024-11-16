package calculator

import java.util.regex.Pattern

const val NUMBER_REGEX = "\\d+"
const val OPERATOR_REGEX = "[+\\-*/]"
const val EXPRESSION_REGEX = "^\\d+( [+\\-*/] \\d+)*$"

fun numberRegex(): Pattern = Pattern.compile(NUMBER_REGEX)

fun operatorRegex(): Pattern = Pattern.compile(OPERATOR_REGEX)

fun expressionRegex(): Pattern = Pattern.compile(EXPRESSION_REGEX)
