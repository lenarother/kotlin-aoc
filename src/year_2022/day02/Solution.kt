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

    val scoresMap = mapOf(
        "Rock" to mapOf(
            "Rock" to 3,
            "Paper" to 0,
            "Scissors" to 6,
        ),
        "Scissors" to mapOf(
            "Rock" to 0,
            "Paper" to 6,
            "Scissors" to 3,
        ),
        "Paper" to mapOf(
            "Rock" to 6,
            "Paper" to 3,
            "Scissors" to 0,
        ),
    )
    println("scoresMap $scoresMap")

    val sum = input.sumOf { row ->
        val values = row.split(" ")
        val opponentShape: String? = shapeMap[values[0]] // a -> rock
        val myShape: String? = shapeMap[values[1]] // y -paper
        val winScore = scoresMap[myShape!!]!![opponentShape]!!
        val roundScore = scoreMap[myShape]!! + winScore
        println("roundScore $roundScore")
        roundScore
    }
    return sum
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
     println(part1(realInput))

    // Part 2 - Test
    // check(part2(testInput) == 12)

    // Part 2 - Solution
//     println(part2(realInput))
}
