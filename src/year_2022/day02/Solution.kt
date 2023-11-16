package year_2022.day02

import readInput

/**
 * https://adventofcode.com/2022/day/2
 */

fun part1(input: List<String>): Int {
    println("input: $input")
    val shapeMap = mapOf(
        "X" to "Rock",
        "Y" to "Paper",
        "Z" to "Scissors",
        "A" to "Rock",
        "B" to "Paper",
        "C" to "Scissors"
    )
    val scoreMap = mapOf(
        "Rock" to 1,
        "Paper" to 2,
        "Scissors" to 3,
    )
    println("scoreMap: $scoreMap")

    input.forEach { row ->
        val values = row.split(" ")
        println("values: ${shapeMap[values[0]]}, ${shapeMap[values[1]]}")
    }
    return 1
}

fun part2(input: List<String>): Int {
    return 2
}

fun main() {
    val testInput = readInput("year_2022/day02/resources/TestData01")
    val realInput = readInput("year_2022/day02/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 15)

    // Part 1 - Solution
    // println(part1(realInput))

    // Part 2 - Test
    // check(part2(testInput) == 12)

    // Part 2 - Solution
    // println(part2(realInput))
}
