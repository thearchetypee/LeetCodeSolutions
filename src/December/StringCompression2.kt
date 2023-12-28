package December

import kotlin.math.min

/**
 * Refer to NeedCode: https://www.youtube.com/watch?v=ISIG3o-Xofg
 */

fun main() {
    println(getLengthOfOptimalCompression("aaaaaaaaaaa", 0))
}

fun getLengthOfOptimalCompression(s: String, k: Int): Int {
    // Set of values that indicate when a character count becomes 1, 9, or 99
    val specialCounts = setOf(1, 9, 99)

    // Cache to store intermediate results for dynamic programming
    val cache = mutableMapOf<String, Int>()

    // Recursive function to calculate optimal compression length
    fun dfs(index: Int, remainingDeletions: Int, prevChar: String, prevCount: Int): Int {
        // Create a unique key based on the function parameters
        val key = "$index-$remainingDeletions-$prevChar-$prevCount"

        // Check if the result for the given parameters is already cached
        if (cache.containsKey(key))
            return cache[key]!!

        // If remaining deletions are negative, return a large value (not a valid solution)
        if (remainingDeletions < 0)
            return Int.MAX_VALUE

        // If we have processed the entire string, return 0 (base case)
        if (index == s.length)
            return 0

        val result: Int = if (s[index].toString() == prevChar) {
            // If the current character matches the previous one, try compressing it
            val increment = if (prevCount in specialCounts) 1 else 0
            increment + dfs(index + 1, remainingDeletions, prevChar, prevCount + 1)
        } else {
            // If the current character is different, either delete it or keep it
            min(
                dfs(index + 1, remainingDeletions - 1, prevChar, prevCount), // Delete the current character
                1 + dfs(index + 1, remainingDeletions, s[index].toString(), 1) // Keep the current character
            )
        }

        // Cache the result for this set of parameters
        cache[key] = result

        return result
    }

    // Start the recursive calculation from the beginning of the string
    return dfs(0, k, "", 0)
}


/**
 *  WARNING: This is wrong approach
 */
fun getLengthOfOptimalCompressionApproach1(s: String, k: Int): Int {
    val encoded = StringBuilder()
    var currChar = s[0]
    var currLength = 0
    for (c in s) {
        if (currChar == c) {
            currLength++
        } else {
            encoded.append(currChar)
            if (currLength > 1) {
                encoded.append(currLength)
            }
            currLength = 1
            currChar = c
        }
    }

    encoded.append(currChar)
    if (currLength > 1) {
        encoded.append(currLength)
    }

    var encodedString = encoded.toString()
    encoded.clear()

    var i = 0
    var k1 = k
    while (i < encodedString.length && k1 > 0) {
        if ((i + 1 < encodedString.length) && encodedString[i + 1].isDigit()) {
            currChar = encodedString[i]
            val numSb = StringBuilder()
            i++
            while (i < encodedString.length && encodedString[i].isDigit()) {
                numSb.append(encodedString[i])
                i++
            }
            val num = numSb.toString().toInt()
            if ((num <= k1 && num <= 2).not()) {
                encoded.append(currChar)
                encoded.append(numSb.toString())
            } else {
                k1 -= (numSb.length + 1)
            }
        } else {
            i++
            k1--
        }
    }
    encodedString = encoded.toString()
    println(encodedString)
    encoded.clear()
    println(k1)
    i = 0
    while (i < encodedString.length && k1 > 0) {
        if ((i + 1 < encodedString.length) && encodedString[i + 1].isDigit()) {
            currChar = encodedString[i]
            val numSb = StringBuilder()
            i++
            while (i < encodedString.length && encodedString[i].isDigit()) {
                numSb.append(encodedString[i])
                i++
            }
            val num = numSb.toString().toInt()
            if ((num <= k1).not()) {
                val numLength = numSb.length
                val newLength = (num - k1).toString().length
                if (newLength < numLength) {
                    encoded.append(currChar)
                    encoded.append((num - k1).toString())
                    k1 = 0
                }
            } else {
                k1 -= (numSb.length + 1)
            }
        } else {
            i++
            k1--
        }
    }
    encodedString = if (encoded.isNotEmpty()) encoded.toString() else encodedString
    return encodedString.length
}