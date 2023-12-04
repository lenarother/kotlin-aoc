package year_2023.day01

import readInput

/**
 * https://adventofcode.com/2023/day/1
 */

val numbersMap = mapOf<String, Int>(
    "1" to 1,
    "2" to 2,
    "3" to 3,
    "4" to 4,
    "5" to 5,
    "6" to 6,
    "7" to 7,
    "8" to 8,
    "9" to 9,
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9,
)


fun part1(input: List<String>): Int {
    var result = 0
    for (line in input) {
        val numbers = line.filter { it.isDigit() }
        result += "${numbers.first()}${numbers.last()}".toInt()
    }
    return result
}


fun part2(input: List<String>): Int {
    var result = 0

    for (line in input) {
        var first = 0
        var firstIndex = 10000
        var last = 0
        var lastIndex = 0

        for (num in numbersMap) {
            if (line.contains(num.key)) {
                val newIndex = line.indexOf(num.key)
                if (newIndex <= firstIndex) {
                    firstIndex = newIndex
                    first = num.value
                }
                val newRightIndex = line.lastIndexOf(num.key)
                if (newRightIndex >= lastIndex) {
                    lastIndex = newRightIndex
                    last = num.value
                }
            }
        }

        val finalNumber = "${first}${last}".toInt()
        result += finalNumber
    }
    return result
}

fun main() {
    val testInput = readInput("year_2023/day01/resources/TestData01")
    val testInput2 = readInput("year_2023/day01/resources/TestData02")
    val realInput = readInput("year_2023/day01/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 142)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    check(part2(testInput) == 142)
    check(part2(testInput2) == 281)

    // Part 2 - Solution
    println(part2(realInput))
}
