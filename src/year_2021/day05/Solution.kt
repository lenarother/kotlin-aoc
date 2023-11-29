package year_2021.day05

import readInput

/**
 * https://adventofcode.com/2021/day/5
 */

class Line(startX: Int, startY: Int, endX: Int, endY: Int, includeDiagonal: Boolean) {
    val startX = startX
    val startY = startY
    val endX = endX
    val endY = endY
    var includeDiagonal = includeDiagonal

    fun isDiagonal(): Boolean = maxOf(startX, endX) - minOf(startX, endX) == maxOf(startY, endY) - minOf(startY, endY)

    fun getPoints(): MutableList<Pair<Int, Int>> {
        var points = mutableListOf<Pair<Int, Int>>()
        if (startX == endX) {
            val newStart = minOf(startY, endY)
            val newEnd = maxOf(startY, endY)
            for (i in newStart..newEnd)  {
                points.add(Pair(startX, i))
            }
        }
        else if (startY == endY) {
            val newStart = minOf(startX, endX)
            val newEnd = maxOf(startX, endX)
            for (i in newStart..newEnd)  {
                points.add(Pair(i, startY))
            }
        }
        else if (includeDiagonal and isDiagonal()) {
            val diffX = if (startX < endX) 1 else -1
            val diffY = if (startY < endY) 1 else -1
            var currentPoint = Pair(startX, startY)
            for (i in 0..(kotlin.math.abs(startX - endX))) {
                points.add(currentPoint)
                currentPoint = Pair(currentPoint.first + diffX, currentPoint.second + diffY)
            }
        }
        return points
    }
}

fun parseLine(lineString: String, includeDiagonal: Boolean = false): Line {
    val startEnd = lineString.split(" -> ")
    val start = startEnd[0].split(",").map { it.toInt() }
    val end = startEnd[1].split(",").map { it.toInt() }
    return Line(start[0], start[1], end[0], end[1], includeDiagonal)
}

fun getLines(input: List<String>, includeDiagonal: Boolean = false): MutableList<Line> {
    var lines = mutableListOf<Line>()
    for (lineString in input) {
        lines.add(parseLine(lineString, includeDiagonal))
    }
    return lines
}

fun part1(input: List<String>, includeDiagonal: Boolean = false): Int {
    val lines = getLines(input, includeDiagonal)
    var pointsCount = mutableMapOf<Pair<Int, Int>, Int>()
    for (line in lines) {
        for (point in line.getPoints()) {
            if (point !in pointsCount) {
                pointsCount[point] = 0
            }
            pointsCount[point] = pointsCount[point]!! + 1
        }
    }
    return pointsCount.values.count { it > 1 }
}


fun main() {
    val testInput = readInput("year_2021/day05/resources/TestData01")
    val realInput = readInput("year_2021/day05/resources/RealData")

    // Part 1 - Test
    check(part1(testInput) == 5)

    // Part 1 - Solution
    println(part1(realInput))

    // Part 2 - Test
    check(part1(testInput, includeDiagonal = true) == 12)

    // Part 2 - Solution
    println(part1(realInput, includeDiagonal = true))
}
