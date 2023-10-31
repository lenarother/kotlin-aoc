package year_2021.day01

import readInput

/**
 * https://adventofcode.com/2021/day/1
 */


fun part1(input: List<String>): Int {
    var counter = 0
    var current = 0
    for (i in input) {
        if (i.toInt() > current) {counter += 1}
        current = i.toInt()
    }
    return counter - 1
}

fun part2(input: List<String>): Int {
    // return input.size
    var counter = 0
    var current = 0
    for (i in 0..input.size - 3) {
        val newCurrent = input[i].toInt() + input[i + 1].toInt() + input[i + 2].toInt()
        if (newCurrent > current) {counter += 1}
        current = newCurrent
    }
    return counter - 1
}

fun main() {
    val testInput = readInput("year_2021/day01/resources/TestData01")
    val realInput = readInput("year_2021/day01/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 7)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    check(part2(testInput) == 5)

    // Part 2 - Solution
    println(part2(realInput))
}
