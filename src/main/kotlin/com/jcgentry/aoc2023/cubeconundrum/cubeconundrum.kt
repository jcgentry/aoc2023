package com.jcgentry.com.jcgentry.aoc2023.cubeconundrum

import java.lang.Integer.max


data class Contents(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
) {

    operator fun minus(other: Contents): Contents =
        Contents(
            max(red - other.red, 0),
            max(green - other.green, 0),
            max(blue - other.blue, 0)
        )

    infix fun minCombine(other: Contents): Contents =
        Contents(
            max(red, other.red),
            max(green, other.green),
            max(blue, other.blue)
        )

    fun power() = red * green * blue
}

private fun String.parseIndex() = this.substring(5).toInt()

private fun String.parseColor() = Color.entries.first() { it.label == this }

private fun String.parseColorAmount(): Pair<Int, Color> {
    val (count, color) = this.split(" ").map { it.trim() }
    return count.toInt() to color.parseColor()
}

fun List<Pair<Int, Color>>.combineIntoPull(): Pull {
    var (red, green, blue) = Triple(0, 0, 0)
    for ((count, color) in this) {
        when (color) {
            Color.Red -> red += count
            Color.Green -> green += count
            Color.Blue -> blue += count
        }
    }
    return Pull(red, green, blue)
}

fun String.parsePull() =
    this.split(",")
        .map { it.trim() }
        .map { it.parseColorAmount() }
        .combineIntoPull()

fun String.parsePulls() =
    this.split(";")
        .map { it.trim() }
        .map { it.parsePull() }

fun String.toGame(): Game {
    val (index, pull) = this.split(":").map { it.trim() }
    return Game(index.parseIndex(), pull.parsePulls())
}

fun parseGames(games: String) =
    games.split("\n")
        .map { it.trim() }
        .filter { it.length > 0 }
        .map { it.toGame() }

fun sumGameIDs(games: String, contents: Contents) =
    parseGames(games)
        .filter { it.possible(contents) }
        .map { it.index }
        .sum()

fun gamesPower(games: String) =
    parseGames(games)
        .map { it.power() }
        .sum()

class Game(val index: Int, val pulls: List<Pull>) {
    fun possible(contents: Contents): Boolean =
        pulls.all { (r, g, b) ->
            r <= contents.red && g <= contents.green && b <= contents.blue
        }

    fun needed(): Contents =
        pulls.fold(Contents()) { acc, pull ->
            acc minCombine pull.contents
        }

    fun power() = needed().power()
}

enum class Color(val label: String) {
    Red("red"),
    Green("green"),
    Blue("blue")
}

data class Pull(
    val red: Int = 0,
    val green: Int = 0,
    val blue: Int = 0,
) {
    val contents get() = Contents(red, green, blue)
}




