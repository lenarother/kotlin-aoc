package year_2023.day02

import readInput

/**
 * https://adventofcode.com/2023/day/2
 */

const val RED = 12
const val GREEN = 13
const val BLUE = 14

// Use DSL, builder pattern
// https://kotlinlang.org/docs/type-safe-builders.html
fun game(init: Game.() -> Unit): Game {
    val game = Game(id = 0, red = listOf(), blue = listOf(), green = listOf())
    game.init()
    return game
}

data class Game(var id: Int, var red: List<Int>, var blue: List<Int>, var green: List<Int>) {
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

fun parseGame(inputLine: String) = game {
    this.red = inputLine.findNumbers("([0-9]+) red")
    this.blue = inputLine.findNumbers("([0-9]+) blue")
    this.green = inputLine.findNumbers("([0-9]+) green")
    this.id = inputLine.findNumbers("Game ([0-9]+):")[0]
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
