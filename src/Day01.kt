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

fun main() {
    val input = readInput("Day01_test")
    val part1Result = part1(input)
    println(part1Result)
}
