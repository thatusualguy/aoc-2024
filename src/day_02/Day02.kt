package day_02

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val reports = input.map { it.split(" ").filterNot(String::isNullOrBlank).map(String::toInt) }

        return reports.count { report ->
            (report == report.sorted() || report == report.sortedDescending()) && report.zipWithNext()
                .all { pair -> abs(pair.first - pair.second) in 1..3 }
        }
    }

    fun part2(input: List<String>): Int {
        val reports = input.map { it.split(" ").filterNot(String::isNullOrBlank).map(String::toInt) }

        return reports.count { report ->
            for (i in 0..report.size) {
                val permutation = report.filterIndexed { index, _ -> index != i }
                val solution =
                    (permutation == permutation.sorted() || permutation == permutation.sortedDescending()) && permutation.zipWithNext()
                        .all { pair -> abs(pair.first - pair.second) in 1..3 }
                if (solution) {
                    return@count true
                }
            }
            return@count false
        }
    }


    val testInput = readInput("day_02/Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day_02/Day02")
    part1(input).println()
    part2(input).println()
}
