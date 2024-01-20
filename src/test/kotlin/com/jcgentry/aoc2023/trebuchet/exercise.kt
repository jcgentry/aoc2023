package com.jcgentry.aoc2023.trebuchet

import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationSum
import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationValue

fun main() {
    object {}
        .javaClass
        .getResourceAsStream("/lines.txt")!!
        .bufferedReader()
        .readLines()
        .asSequence()
        .let {
            print("Sum is ${calibrationSum(it)}")
        }
}