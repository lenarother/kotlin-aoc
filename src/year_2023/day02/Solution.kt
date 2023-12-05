package year_2023.day02

import readInput

/**
 * https://adventofcode.com/2023/day/2
 */

class Game(val id: Int, val red: List<Int>, val blue: List<Int>, val green: List<Int>) {

    override fun toString(): String = "<Game ${id}>"

    fun isPossible(r: Int, b: Int, g: Int): Boolean = (
            (red.max() <= r) and (blue.max() <= b) and (green.max() <= g)
            )

    fun getPower(): Int = red.max() * blue.max() * green.max()
}

fun findNumbers(regexString: String, inputLine: String): List<Int> {
    return Regex(regexString).findAll(inputLine).map { it.groupValues[1].toInt() }.toList()
}

fun parseGame(inputLine: String): Game {
    val red = findNumbers("([0-9]+) red", inputLine)
    val blue = findNumbers("([0-9]+) blue", inputLine)
    val green = findNumbers("([0-9]+) green", inputLine)
    val id = findNumbers("Game ([0-9]+):", inputLine)[0]
    return Game(id=id, red=red, blue=blue, green=green)
}

fun part1(input: List<String>): Int {
    var result = 0
    for (line in input) {
        val game = parseGame(line)
        if ( game.isPossible(r=12, b=14, g=13)) { result += game.id }
    }
    return result
}

fun part2(input: List<String>): Int {
    var result = 0
    for (line in input) {
        val game = parseGame(line)
        result += game.getPower()
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
