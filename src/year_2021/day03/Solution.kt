package year_2021.day03

import readInput

/**
 * https://adventofcode.com/2021/day/3
 */


fun getOnesSum(input: List<String>): IntArray {
    // Sum how many "1"s appear on each position.
    val numberSize = input[0].length
    var countArray = IntArray(numberSize)

    for (number in input) {
        for (i in 0 until numberSize) {
            if (number[i] == '1') {countArray[i] += 1}
        }
    }
    return countArray
}


fun part1(input: List<String>): Int {
    val itemsCountHalf = (input.size / 2) + (input.size % 2)
    var resultNumber = ""
    var flippedResultNumber = ""

    var countArray = getOnesSum(input)


    // Based on sum of "1"s and total number of items
    //   determine result number and its flipped version.
    for (i in countArray) {
        if (i >= itemsCountHalf) {
            resultNumber += "1"
            flippedResultNumber += "0"
        } else {
            resultNumber += "0"
            flippedResultNumber += "1"

        }
    }
    return resultNumber.toInt(2) * flippedResultNumber.toInt(2)
}

fun part2(input: List<String>): Int {
    return 2
}

fun main() {
    val testInput = readInput("year_2021/day03/resources/TestData01")
    val realInput = readInput("year_2021/day03/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 198)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    // check(part2(testInput) == 2)

    // Part 2 - Solution
    // println(part2(realInput))
}
