package com.jcgentry.aoc2023.gearratios

import com.jcgentry.com.jcgentry.aoc2023.gearratios.toSchematic
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


val SCHEMATIC = """467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...$.*....
.664.598..""".trim()

class SchematicTest {
    @Test
    fun `not part numbers`() {
        assertEquals(setOf(114, 68), SCHEMATIC.toSchematic().nonPartNumbers())
    }

    @Test
    fun `part numbers sum`() {
        assertEquals(4361, SCHEMATIC.toSchematic().partNumbers().sum())
    }
}