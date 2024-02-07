package February24

import java.util.*
import kotlin.collections.ArrayList

/**
 * Store the number of occurrence of each character in map
 * then sort the map by values in descending order
 * iterate over the map and append each character to result the number
 * of times it occurred.
 * Time Complexity: O(n.logn)
 */
fun frequencySort(s: String): String {
    val map = mutableMapOf<Char, Int>()

    for (ch in s) {
        if (map.containsKey(ch)) {
            map[ch] = map[ch]!! + 1
        } else {
            map[ch] = 1
        }
    }

    val sortedmap = map.toList().sortedByDescending { (_, value) -> value }.toMap()
    val result = StringBuilder()
    for ((key, value) in sortedmap) {
        for(i in 0..<value) {
            result.append(key)
        }
    }
    return result.toString()
}

fun main() {
    println(frequencySort("tree"))
    println(frequencySort("cccaaa"))
    println(frequencySort("Aabb"))
}