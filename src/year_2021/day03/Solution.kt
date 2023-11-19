package year_2021.day03

import readInput

/**
 * https://adventofcode.com/2021/day/3
 */

/**
 * Input: Array of Strings that are equal in length and contain 0 / 1.
 * Returns: Array of ints, where ich element is a sum of 1 on corresponding position.
 *
 * Example input: ["010", "010", "011"]
 * Example output: [0, 3, 1]
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

fun getMostCommonBit(onesCount: Int, allItemsCount: Int): String {
    val allItemsCountHalf = (allItemsCount / 2) + (allItemsCount % 2)
    return when {
        onesCount < allItemsCountHalf -> "0"
        else -> "1"
    }
}

fun getLessCommonBit(onesCount: Int, allItemsCount: Int): String {
    val allItemsCountHalf = (allItemsCount / 2) + (allItemsCount % 2)
    return when {
        onesCount < allItemsCountHalf -> "1"
        else -> "0"
    }
}

fun part1(input: List<String>): Int {
    var countArray = getOnesSum(input)
    var resultNumber = ""
    var flippedResultNumber = ""

    // Based on sum of "1"s and total number of items
    //   determine result number and its flipped version.
    for (i in countArray) {
        resultNumber += getMostCommonBit(i, input.size)
        flippedResultNumber += getLessCommonBit(i, input.size)
    }
    return resultNumber.toInt(2) * flippedResultNumber.toInt(2)
}

/**
fun filterArray(
    inputArray: List<String>,
    countArray: IntArray,
    n: Int,
    inputInitialSize: Int,
    getBitFun: (onesCount: Int, allItemsCount: Int) -> String
): MutableList<String> {
    var results:MutableList<String> = mutableListOf()
    val wantedValue = getBitFun(countArray[n], inputInitialSize)
    for (i in inputArray) if (i[n].toString() == wantedValue) { results.add(i) }
    return results
}
*/

fun filterArrayMostCommonBit(
    inputArray: List<String>,
    countArray: IntArray,
    n: Int,
    inputInitialSize: Int,
): MutableList<String> {
    var results:MutableList<String> = mutableListOf()
    val wantedValue = getMostCommonBit(countArray[n], inputInitialSize)
    for (i in inputArray) if (i[n].toString() == wantedValue) { results.add(i) }
    return results
}

fun filterArrayLessCommonBit(
    inputArray: List<String>,
    countArray: IntArray,
    n: Int,
    inputInitialSize: Int,
): MutableList<String> {
    println(inputArray)
    var results:MutableList<String> = mutableListOf()
    val wantedValue = getLessCommonBit(countArray[n], inputInitialSize)
    for (i in inputArray) if (i[n].toString() == wantedValue) { results.add(i) }
    return results
}


fun findNum1(
    input: List<String>,
    countArray: IntArray,
    inputInitialSize: Int,
): String {
    val numberLength = input[0].length - 1
    for ( i in 0..numberLength ) {
        var input = filterArrayMostCommonBit(input, countArray, i, inputInitialSize)
        if (input.size == 1) { return input[0] }
    }
    return ""
}

fun findNum2(
    input: List<String>,
    countArray: IntArray,
    inputInitialSize: Int
): String {
    val numberLength = input[0].length - 1
    for (i in 0..numberLength) {
        var input = filterArrayLessCommonBit(input, countArray, i, inputInitialSize)
        if (input.size == 1) {
            return input[0]
        }
    }
    return ""
}

fun part2(input: List<String>): Int {
    val itemsCount = input.size
    var countArray = getOnesSum(input)
    println("Count $itemsCount, array $countArray")
    val firstNum: String = findNum1(input, countArray, itemsCount)
    val secondNum: String = findNum2(input, countArray, itemsCount)
    return firstNum.toInt(2) * secondNum.toInt(2)
}

fun main() {
    val testInput = readInput("year_2021/day03/resources/TestData01")
    val realInput = readInput("year_2021/day03/resources/RealData")

    // Part 1 - Test
    //check(part1(testInput) == 198)

    // Part 1 - Solution
    //println(part1(realInput))

    // Part 2 - Test
    check(part2(testInput) == 2)

    // Part 2 - Solution
    // println(part2(realInput))
}
