package January24

/**
 * Approach 2:
 *  1. We start by sorting the pairs array based on starting value of each
 *      pair.
 *  2. Store the minimum right bound of the chains with length maxLength
 *  3. Update minimum right bound if new min found
 */
fun findLongestChain(pairs: Array<IntArray>): Int {
    var maxLength = 1
    pairs.sortBy { it[0] }
    val n = pairs.size
    var minRight  = pairs[0][1]
    for (i in 1 until n) {
        if (minRight < pairs[i][0]) {
            minRight = pairs[i][1]
            maxLength++
        } else {
            minRight = pairs[i][1].coerceAtMost(minRight)
        }
    }
    return maxLength
}

/**
 * Approach 1:
 *  1. We start by sorting the pairs array based on the ending values of each pair.
 *      Sorting makes it easier to find the longest chain.
 *
 *  2. We initialize an array dp of the same length as pairs, where dp[i] represents
 *      the length of the longest chain ending with the pair at index i. We initialize
 *      all values in dp to 1 because each pair can form a chain of at least length 1.
 *
 *  3. We iterate through the pairs array and for each pair at index i, we iterate through
 *      all pairs from index 0 to i-1. If the starting value of pair i is greater than the
 *      ending value of pair j, it means we can extend the chain by including pair i after
 *      pair j. We update dp[i] with the maximum of its current value and dp[j] + 1.
 *
 *  4. Finally, we return the maximum value in the dp array as the length of the longest chain.
 *
 *  Time Complexity: O(n^2)
 *  Space Complexity: O(n)
 */

fun findLongestChainApproach1(pairs: Array<IntArray>): Int {
    pairs.sortBy { it[1] }
    val n = pairs.size
    val dp = IntArray(n) { 1 }
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (pairs[i][0] > pairs[j][1]) {
                dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
    }
    return dp.max()
}

fun main() {
    println(findLongestChain(arrayOf(intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4))))
}