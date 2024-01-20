package com.jcgentry.com.jcgentry.aoc2023.trebuchet

fun calibrationValue(line: String): Int {
    val digits = line.filter { it.isDigit() }
    return digits.first().digitToInt() * 10 + digits.last().digitToInt()
}

fun calibrationSum(lines: Sequence<String>): Int =
    lines
        .map { calibrationValue(it) }
        .sum()