package com.jcgentry.aoc2023.trebuchet

import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationSum
import com.jcgentry.com.jcgentry.aoc2023.trebuchet.calibrationValue
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

    private companion object {
        val testLines = mapOf(
            "1abc2" to 12,
            "pqr3stu8vwx" to 38,
            "a1b2c3d4e5f" to 15,
            "treb7uchet" to 77
        )
        @JvmStatic
        fun lines(): Stream<Arguments> =
            testLines
                .entries
                .map { (line, calibration) ->
                    Arguments.of(line, calibration)
                }
                .asSequence()
                .asStream()
    }
}