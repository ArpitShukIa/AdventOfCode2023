fun main() {

    fun part1(input: List<String>): Int {
        return input.filter { s ->
            val cubes = s.substringAfter(":").split(Regex("[;,]"))
            cubes.all { cube ->
                val count = cube.trim().substringBefore(" ").toInt()
                val maxCount = if ("red" in cube) 12 else if ("green" in cube) 13 else 14
                count <= maxCount
            }
        }.sumOf { it.substringAfter(" ").substringBefore(":").toInt() }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { s ->
            val cubes = s.substringAfter(":").split(Regex("[;,]"))
            val counts = mutableListOf(0, 0, 0)
            cubes.forEach { cube ->
                val count = cube.trim().substringBefore(" ").toInt()
                val index = if ("red" in cube) 0 else if ("green" in cube) 1 else 2
                counts[index] = maxOf(counts[index], count)
            }
            counts.reduce(Int::times)
        }
    }

    val input = readInputLines("Day02")
    println(part1(input))
    println(part2(input))
}
