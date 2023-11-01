package year_2021.day02

import readInput

/**
 * https://adventofcode.com/2021/day/2
 */


fun part1(input: List<String>): Int {
    var depth = 0
    var position = 0
    for (i in input) {
        val temp =  i.split(" ")
        val direction = temp[0]
        val value = temp[1].toInt()
        when (direction) {
            "forward" -> position += value
            "up" -> depth -= value
            "down" -> depth += value
        }
    }
    return position * depth
}

fun part2(input: List<String>): Int {
    var depth = 0
    var position = 0
    var aim = 0
    for (i in input) {
        val temp =  i.split(" ")
        val direction = temp[0]
        val value = temp[1].toInt()
        when (direction) {
            "forward" -> {
                position += value
                depth += value * aim
            }
            "up" -> aim -= value
            "down" -> aim += value
        }
    }
    return position * depth
}

fun main() {
    val testInput = readInput("year_2021/day02/resources/TestData01")
    val realInput = readInput("year_2021/day02/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 150)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    check(part2(testInput) == 900)

    // Part 2 - Solution
    println(part2(realInput))
}
