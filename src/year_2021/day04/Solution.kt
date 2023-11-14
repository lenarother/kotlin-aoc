package year_2021.day04

import readInput

/**
 * https://adventofcode.com/2021/day/4
 */
class Board(numbers: IntArray) {
    val numbers = numbers
    var columns = mapOf<Int, Int>(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0)
    var rows = mapOf<Int, Int>(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0)
    var hits = listOf<Int>()
}

fun parseInputBoards(input: List<String>) {}


fun parseInputNumbers(input: List<String>): List<Int> {
    return input[0].split(",").map{ it.toInt() }
}

fun part1(input: List<String>): Int {
    println(input)
    val numbers = parseInputNumbers(input)
    println(numbers)
    return 1
}

fun part2(input: List<String>): Int {
    return 2
}

fun main() {
    val testInput = readInput("year_2021/day04/resources/TestData01")
    val realInput = readInput("year_2021/day04/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 1)

    // Part 1 - Solution
    //println(part1(realInput))

    // Part 2 - Test
    //check(part2(testInput) == 2)

    // Part 2 - Solution
    // println(part2(realInput))
}
