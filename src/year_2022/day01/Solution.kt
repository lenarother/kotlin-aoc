package year_2022.day01

import readInput

/**
 * https://adventofcode.com/2022/day/1
 */

fun part1(input: List<String>): Int {
    var currentMax = 0
    var localMax = 0
    for (i in input) {
        if (i.isEmpty()) {
            if (localMax > currentMax) {
                currentMax = localMax
            }
            localMax = 0
        } else {
            localMax += i.toInt()
        }
    }
    return currentMax
}

fun part2(input: List<String>): Int {
    var results:MutableList<Int> = mutableListOf()
    var localMax = 0
    for (i in input) {
        if (i.isEmpty()) {
            results.add(localMax)
            localMax = 0
        } else {
            localMax += i.toInt()
        }
    }
    results.add(localMax)
    return results.sortedDescending().take(3).sum()
}

fun main() {
    val testInput = readInput("year_2022/day01/resources/TestData01")
    val realInput = readInput("year_2022/day01/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 24000)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    check(part2(testInput) == 45000)

    // Part 2 - Solution
    println(part2(realInput))
}
