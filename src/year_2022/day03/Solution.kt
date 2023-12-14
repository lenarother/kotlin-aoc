package year_2022.day03

import readInput

/**
 * https://adventofcode.com/2022/day/3
 */

fun part1(input: List<String>): Int {
    val alphabet = ('a'..'z').toList() + ('A'..'Z').toList()
    return input.sumOf { line ->
        val chunks = line.chunked(line.length / 2)
        val part1 = chunks[0].toSet()
        val part2 = chunks[1].toSet()
        val intersect = part1.intersect(part2)
        alphabet.indexOf(intersect.first()) + 1
    }
}

fun part2(input: List<String>): Int {
    return 2
}

fun main() {
    val testInput = readInput("year_2022/day03/resources/TestData01")
    val realInput = readInput("year_2022/day03/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 157)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    // check(part2(testInput) == 2)

    // Part 2 - Solution
    // println(part2(realInput))
}
