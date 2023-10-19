// https://adventofcode.com/2022/day/1
// TODO: How ro add txt file to repo?

fun part1(input: List<String>): Int {
    var currentMax = 0
    var localMax = 0
    for (i in input) {
        if (i.isEmpty()) {
            if (localMax > currentMax) {
                currentMax = localMax
            }
            localMax = 0
        } else {
            localMax += i.toInt()
        }
    }
    return currentMax
}

fun part2(input: List<String>): Int {
    var results:MutableList<Int> = mutableListOf()
    var localMax = 0
    for (i in input) {
        if (i.isEmpty()) {
            results.add(localMax)
            localMax = 0
        } else {
            localMax += i.toInt()
        }
    }
    results.add(localMax)
    println(results)
    return results.sortedDescending().take(3).sum()
}

fun main() {
    val input = readInput("Day01_TestData")

    check(part1(input) == 24000)
    println(part1(input))

    println(part2(input))
    check(part2(input) == 45000)
}
