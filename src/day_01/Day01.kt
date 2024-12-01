package day_01

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val locations = input.map { it.split(" ").filterNot(String::isNullOrBlank).map(String::toInt) }
        val left = locations.map { it[0] }.sorted()
        val right = locations.map { it[1] }.sorted()

        return left.zip(right).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        val locations = input.map { it.split(" ").filterNot(String::isNullOrBlank).map(String::toInt) }
        val left = locations.map { it[0] }.groupingBy { it }.eachCount()
        val right = locations.map { it[1] }.groupingBy { it }.eachCount()

        return left.entries.sumOf { (location, repeated) -> location * repeated  * right.getOrDefault(location, 0) }
    }


    val testInput = readInput("day_01/Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = readInput("day_01/Day01")
    part1(input).println()
    part2(input).println()
}
