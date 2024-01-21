package com.jcgentry.aoc2023.trebuchet

import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationSum
import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationSumWithWords

fun main() {
    main2()
}
@Suppress("unused")
fun main1() {
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

fun main2() {
    object {}
        .javaClass
        .getResourceAsStream("/lines.txt")!!
        .bufferedReader()
        .readLines()
        .asSequence()
        .let {
            print("Sum is ${calibrationSumWithWords(it)}")
        }
}