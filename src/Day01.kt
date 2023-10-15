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
    return 1
}

fun main() {
    val input = readInput("Day01_TestData")

    check(part1(input) == 24000)
    println(part1(input))

    // check(part1(input) == 45000)
    // println(part2(input))
}
