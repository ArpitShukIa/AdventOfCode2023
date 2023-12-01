fun main() {

    fun part1(input: List<String>): Int {
        return input.sumOf { s -> "${s.first { it.isDigit() }}${s.last { it.isDigit() }}".toInt() }
    }

    fun part2(input: List<String>): Int {
        val digits = listOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
        return input.sumOf { s ->
            buildList {
                s.indices.forEach { i ->
                    if (s[i].isDigit())
                        add(s[i].digitToInt())
                    for (j in digits.indices)
                        if (s.substring(i).startsWith(digits[j]))
                            add(j)
                }
            }.run { 10 * first() + last() }
        }
    }

    val input = readInputLines("Day01")
    println(part1(input))
    println(part2(input))
}
