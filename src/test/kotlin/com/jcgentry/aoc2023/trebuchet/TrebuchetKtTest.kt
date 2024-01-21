package com.jcgentry.aoc2023.trebuchet

import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationSum
import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationSumWithWords
import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationValue
import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationValueWithWords
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.streams.asStream

class TrebuchetKtTest {

    @ParameterizedTest
    @MethodSource("lines")
    fun calibrationValue(line: String, calibration: Int) {
        assertEquals(calibration, calibrationValue(line))
    }

    @Test
    fun calibrationSum() {
        assertEquals(142, calibrationSum(testLines.keys.asSequence()))
    }

    @ParameterizedTest
    @MethodSource("lines2")
    fun calibrationValueWithWords(line: String, calibration: Int) {
        assertEquals(calibration, calibrationValueWithWords(line))
    }

    @Test
    fun calibrationSumWithWords() {
        assertEquals(281, calibrationSumWithWords(testLines2.keys.asSequence()))
    }

    @Test
    fun overlap() {
        assertEquals(83, calibrationValueWithWords("eighthree"))
    }


    private companion object {
        val testLines = mapOf(
            "1abc2" to 12,
            "pqr3stu8vwx" to 38,
            "a1b2c3d4e5f" to 15,
            "treb7uchet" to 77
        )
        @JvmStatic
        fun lines(): Stream<Arguments> =
            stream(testLines)

        val testLines2= mapOf(
            "two1nine" to 29,
            "eightwothree" to 83,
            "abcone2threexyz" to 13,
            "xtwone3four" to 24,
            "4nineeightseven2" to 42,
            "zoneight234" to 14,
            "7pqrstsixteen" to 76,
        )

        @JvmStatic
        fun lines2(): Stream<Arguments> =
            stream(testLines2)

        private fun stream(linesMap: Map<String, Int>) = linesMap
            .entries
            .map { (line, calibration) ->
                Arguments.of(line, calibration)
            }
            .asSequence()
            .asStream()
    }
}