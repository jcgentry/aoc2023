package com.jcgentry.aoc2023.cubeconundrum

import com.jcgentry.com.jcgentry.aoc2023.cubeconundrum.Contents
import com.jcgentry.com.jcgentry.aoc2023.cubeconundrum.gamesPower
import com.jcgentry.com.jcgentry.aoc2023.cubeconundrum.sumGameIDs
import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationSum
import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationSumWithWords

fun main() {
    object {}
        .javaClass
        .getResource("/com/jgentry/aoc2023/cubeconundrum/games.txt")!!
        .readText()
        .let {
            print("Power is ${gamesPower(it)}")
        }
}

fun main1() {
    object {}
        .javaClass
        .getResource("/com/jgentry/aoc2023/cubeconundrum/games.txt")!!
        .readText()
        .let {
            print("Result is ${sumGameIDs(it, Contents(red = 12, green = 13, blue = 14))}")
        }
}
