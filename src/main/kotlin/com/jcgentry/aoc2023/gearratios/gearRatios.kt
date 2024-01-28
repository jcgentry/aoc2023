package com.jcgentry.com.jcgentry.aoc2023.gearratios


typealias PartNumber = Int
typealias Coordinates = Pair<Int, Int>

class Schematic(items: Sequence<Pair<Coordinates, Item>>) {
    val itemMap : Map<Coordinates, Item> = initItemMap(items)

    private fun initItemMap(items: Sequence<Pair<Coordinates, Item>>) =
        items.toMap()

    fun partNumbers(): Collection<PartNumber> = TODO()
    fun nonPartNumbers(): Collection<Int> = TODO()
}


fun String.toSchematic(): Schematic = this.split("\n")
    .withIndex()
    .map { (idx, line) -> line.symbols(idx) }
    .toList()
    .flatMap { it }
    .asSchematic()

private fun <E> Collection<E>.asSchematic(): Schematic = TODO()

sealed class Item
class Part(val x: Int) : Item()

class Symbol : Item()

private fun String.symbols(x: Int): Sequence<Pair<Coordinates, Item>> {
    var y = 0
    val input = this
    return sequence {
        while (y < length) {
            when {
                input[y] == '.' -> { y += 1 }
                input[y].isDigit() -> {
                    val (partNumber, next) = getNumber(input, y)
                    yield(Pair(Coordinates(x, y), Part(partNumber)))
                    y = next
                }
                else -> {
                    yield(Pair(Coordinates(x, y), Symbol()))
                    y += 1
                }
            }
        }
    }
}

private fun getNumber(s: String, y: Int): Pair<Int, Int> {
    var idx = y
    var result = ""
    while (s[y].isDigit()) {
        result += s[y]
        idx++
    }
    return Pair(result.toInt(), idx)
}