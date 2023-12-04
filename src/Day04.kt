import kotlin.math.*

fun main() {
    val input = readInputLines("Day04")
    var part1 = 0
    val part2 = MutableList(input.size) { 1 }
    for (i in input.indices) {
        val (left, right) = input[i].substringAfter(":").split("|").map { it.trim().split(Regex(" +")) }
        val match = right.count { it in left }
        part1 += floor(2.0.pow(match - 1)).toInt()
        for (j in i + 1..i + match)
            part2[j] += part2[i]
    }
    println(part1)
    println(part2.sum())
}
