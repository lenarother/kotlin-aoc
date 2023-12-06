package year_2023.day02

import readInput

/**
 * https://adventofcode.com/2023/day/2
 */

const val RED = 12
const val GREEN = 13
const val BLUE = 14

data class Game(val id: Int, val red: List<Int>, val blue: List<Int>, val green: List<Int>) {
    val power: Int
        get() = red.max() * blue.max() * green.max()

    override fun toString(): String = "<Game $id>"

    fun isPossible(
        r: Int = RED,
        b: Int = BLUE,
        g: Int = GREEN,
    ): Boolean =
        (
            (red.max() <= r) and (blue.max() <= b) and (green.max() <= g)
        )
}

// extension function
fun String.findNumbers(regexString: String): List<Int> = Regex(regexString).findAll(this).map { it.groupValues[1].toInt() }.toList()

fun parseGame(inputLine: String): Game {
    val red = inputLine.findNumbers("([0-9]+) red")
    val blue = inputLine.findNumbers("([0-9]+) blue")
    val green = inputLine.findNumbers("([0-9]+) green")
    val id = inputLine.findNumbers("Game ([0-9]+):")[0]
    return Game(id = id, red = red, blue = blue, green = green)
}

fun part1(input: List<String>): Int {
    var result = 0
    for (line in input) {
        val game = parseGame(line)
        if (game.isPossible()) {
            result += game.id
        }
    }
    return result
}

fun part2(input: List<String>): Int {
    var result = 0
    for (line in input) {
        val game = parseGame(line)
        result += game.power
    }
    return result
}

fun main() {
    val testInput = readInput("year_2023/day02/resources/TestData01")
    val realInput = readInput("year_2023/day02/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 8)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    check(part2(testInput) == 2286)

    // Part 2 - Solution
    println(part2(realInput))
}
