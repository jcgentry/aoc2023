package com.jcgentry.aoc2023.cubeconundrum

import com.jcgentry.com.jcgentry.aoc2023.cubeconundrum.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.streams.asStream

val TEST_CONTENTS = Contents(red = 12, green = 13, blue = 14)
class CubeconundrumKtTest {

    @Test
    fun possible() {
        val games = parseGames(games).associateBy({ it.index }, { it })
        val test = TEST_CONTENTS
        assertTrue(games[1]!!.possible(test))
        assertTrue(games[2]!!.possible(test))
        assertTrue(games[5]!!.possible(test))

        assertFalse(games[3]!!.possible(test))
        assertFalse(games[4]!!.possible(test))
    }

    @Test
    fun idSum() {
        assertEquals(8, sumGameIDs(games, TEST_CONTENTS))
    }

    @Test
    fun power() {
        assertEquals(2286, gamesPower(games))
    }

    @Test
    fun idSumExtraLine() {
        assertEquals(8, sumGameIDs(gamesExtraLine, TEST_CONTENTS))
    }

    @ParameterizedTest
    @MethodSource("needed")
    fun necessary(test: Pair<Game, Contents>) {
        val (game, contents) = test
        assertEquals(contents, game.needed())
    }

    @ParameterizedTest
    @MethodSource("powers")
    fun powers(test: Pair<Game, Int>) {
        val (game, power) = test
        assertEquals(power, game.power())
    }

    private companion object {
        @JvmStatic
        fun needed() = sequence {
            val games = parseGames(games)
            for ((idx, g) in games.withIndex()) {
                yield(Pair(g, needed[idx]))
            }
        }.asStream()

        @JvmStatic
        fun powers() = sequence {
            val games = parseGames(games)
            for ((idx, g) in games.withIndex()) {
                yield(Pair(g, powers[idx]))
            }
        }.asStream()

        val games = """Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green""".trim()

        val needed = listOf(
            Contents(4, 2, 6),
            Contents(1, 3, 4),
            Contents(20, 13, 6),
            Contents(14, 3, 15),
            Contents(6, 3, 2),
        )

        val powers = listOf(48, 12, 1560, 630, 36)

        val gamesExtraLine = """Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
""".trim()
    }

}

