package year_2021.day04

import readInput

/**
 * https://adventofcode.com/2021/day/4
 */
class Board() {
    val numbers = mutableListOf<Int>()
    var columns = mutableMapOf<Int, Int>(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0)
    var rows = mutableMapOf<Int, Int>(0 to 0, 1 to 0, 2 to 0, 3 to 0, 4 to 0)
    var hits = mutableListOf<Int>()

    fun isHit(num: Int): Boolean = num in numbers

    // Return x (column), y (row) position on the board
    fun getHitPosition(num: Int): Pair<Int, Int> {
        val position = numbers.indexOf(num)
        val x = position % 5
        val y = position / 5
        return x to y
    }

    fun isComplete(): Boolean {
        return 5 in columns.values || 5 in rows.values
    }

    fun addHit(num: Int) {
        hits.add(num)
        val position = getHitPosition(num)
        val x = position.component1()
        val y = position.component2()
        columns[x] = columns[x]!! + 1
        rows[y] = rows[y]!! + 1
    }

    fun getScore(): Int {
        return numbers.minus(hits).sum() * hits.last()
    }
}


fun parseInputBoards(input: List<String>): MutableList<Board> {
    var boards = mutableListOf<Board>()
    var board = Board()
    val iterationSize = input.size - 1
    for (i in 2..iterationSize) {

        if (input[i] == "") {
            val completeBoard = board
            boards.add(completeBoard)
            board = Board()
        }
        else {
            board.numbers += input[i].trim().split("\\s+".toRegex()).map{ it.toInt() }
        }
    }
    // add last element
    val completeBoard = board
    boards.add(completeBoard)
    return boards
}

fun parseInputNumbers(input: List<String>): List<Int> {
    return input[0].split(",").map{ it.toInt() }
}

fun part1(input: List<String>): Int {
    val numbers = parseInputNumbers(input)
    var boards = parseInputBoards(input)
    for (n in numbers) {
        for (b in boards) {
            if (b.isHit(n)) {
                b.addHit(n)
                if (b.isComplete()) {
                    return b.getScore()
                }
            }
        }
    }
    return -1
}

fun part2(input: List<String>): Int {
    val numbers = parseInputNumbers(input)
    var boards = parseInputBoards(input)
    var completeBoards = mutableListOf<Board>()
    for (n in numbers) {
        var completeTemp = mutableListOf<Board>()
        for (b in boards) {
            if (b.isHit(n)) {
                b.addHit(n)
                if (b.isComplete()) {
                    completeTemp.add(b)
                }
            }
        }
        completeBoards.addAll(completeTemp)
        boards.removeAll(completeTemp)
    }
    return completeBoards.last().getScore()
}

fun main() {
    val testInput = readInput("year_2021/day04/resources/TestData01")
    val realInput = readInput("year_2021/day04/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 4512)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    check(part2(testInput) == 1924)

    // Part 2 - Solution
    println(part2(realInput))
}
