package year_2023.day04

import readInput
import kotlin.math.pow

/**
 * https://adventofcode.com/2023/day/4
 */

class Card(
    val id: Int,
    val numbers: List<Int>,
    val winningNumbers: List<Int>
) {
    fun countPoints(): Int {
        val n = numbers.intersect(winningNumbers.toSet()).size
        return 2.0.pow(n - 1).toInt()
    }
}

fun parseCard(input: String): Card {
    val cardParts = input.split(" | ").toTypedArray()
    val cardPartOne = cardParts[0].split(":").toTypedArray()
    return Card(
        id=cardPartOne[0].filter { it.isDigit() }.toInt(),
        numbers=cardParts[1].trim().split("\\s+".toRegex()).map { it.trim().toInt() },
        winningNumbers=cardPartOne[1].trim().split("\\s+".toRegex()).map { it.toInt() }
    )
}

fun part1(input: List<String>): Int = input.sumOf { parseCard(it).countPoints() }


fun part2(input: List<String>): Int {
    return 2
}

fun main() {
    val testInput = readInput("year_2023/day04/resources/TestData01")
    val realInput = readInput("year_2023/day04/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 13)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    //check(part2(testInput) == 2)

    // Part 2 - Solution
    // println(part2(realInput))
}
