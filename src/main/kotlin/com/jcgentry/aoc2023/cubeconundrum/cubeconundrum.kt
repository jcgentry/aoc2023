package com.jcgentry.com.jcgentry.aoc2023.cubeconundrum

data class Pull(
    val red: Int,
    val green: Int,
    val blue: Int,
)

data class Contents(
    val red: Int,
    val green: Int,
    val blue: Int,
)

typealias Game = List<Pull>

fun game(vararg games: Game) = listOf(*games)

fun Game.possible(contents: Contents): Int = TODO()