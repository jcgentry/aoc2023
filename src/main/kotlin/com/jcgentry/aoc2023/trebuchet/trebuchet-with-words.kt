package com.jcgentry.com.jcgentry.aoc2023.trebuchet

fun calibrationValueWithWords(line: String): Int {
    val digits = numbers(line)
    return digits.first() * 10 + digits.last()
}

private fun numbers(line: String) = sequence {
    var buffer = ""
    line.indices.forEach { idx ->
        line[idx].let { nextChar ->
            if (nextChar.isDigit()) {
                buffer = ""
                yield(nextChar.digitToInt())
            } else {
                buffer += nextChar
                val digit = buffer.getDigit()
                if (digit != null) {
                    yield(digit)
                }
            }
        }
    }
}


private fun String.getDigit(): Int? {
    DIGITS.indices.forEach {
        if (endsWith(DIGITS[it]))
            return it
    }
    return null
}

val DIGITS = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

fun calibrationSumWithWords(lines: Sequence<String>): Int =
    lines
        .map { calibrationValueWithWords(it) }
        .sum()