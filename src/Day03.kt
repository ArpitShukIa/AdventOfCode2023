fun main() {

    fun getAdjacentSymbol(input: List<String>, i: Int, range: IntRange): Pair<Int, Int>? {
        listOf(i - 1, i + 1).forEach { r ->
            for (j in maxOf(range.first - 1, 0)..minOf(range.last + 1, input[i].lastIndex))
                if (r in input.indices && input[r][j] in "@#$%&*/=+-")
                    return r to j
        }
        listOf(range.first - 1, range.last + 1).forEach { c ->
            if (c in input[i].indices && input[i][c] in "@#$%&*/=+-")
                return i to c
        }
        return null
    }

    fun part1(input: List<String>): Int {
        val numbers = input.flatMapIndexed { i, s -> Regex("\\d+").findAll(s).map { i to it.range } }
        return numbers.sumOf { (i, range) ->
            if (getAdjacentSymbol(input, i, range) != null) input[i].substring(range).toInt() else 0
        }
    }

    fun part2(input: List<String>): Int {
        val numbers = input.flatMapIndexed { i, s -> Regex("\\d+").findAll(s).map { i to it.range } }
        var sum = 0
        for ((i, r1) in numbers) {
            for ((j, r2) in numbers) {
                val (x1, y1) = getAdjacentSymbol(input, i, r1) ?: continue
                val (x2, y2) = getAdjacentSymbol(input, j, r2) ?: continue
                if ((i != j || r1 != r2) && x1 == x2 && y1 == y2 && input[x1][y1] == '*')
                    sum += input[i].substring(r1).toInt() * input[j].substring(r2).toInt()
            }
        }
        return sum / 2
    }

    val input = readInputLines("Day03")
    println(part1(input))
    println(part2(input))
}
