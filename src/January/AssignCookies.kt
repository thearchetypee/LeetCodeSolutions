package January

import java.util.*

/**
 * Approach:
 *  We first sort both array in ascending order. Now lets take 2 variable which keep tracks
 *  of g and s index. Check if greedy factor of child at ith index is less than or equal to
 *  size of cookie at jth index. If this condition is satisfied then increment both i and j
 *  otherwise just increment j
 *
 *  Time Complexity: O(n*logn + m*logm)
 *  Space Complexity: O(1)
 */
fun findContentChildren(g: IntArray, s: IntArray): Int {
    Arrays.sort(g)
    Arrays.sort(s)

    var i = 0 // Index for 'g'
    var j = 0 // Index for 's'
    var ans = 0 // Counter for content children

    // Iterate through both arrays while comparing greed factors with available sizes.
    while (i < g.size && j < s.size) {
        if (g[i] <= s[j]) {
            ans++
            i++ // Move to the next child's greed factor.
        }
        j++ // Move to the next available content size.
    }

    return ans // Return the maximum number of content children.
}

fun main() {
    println(findContentChildren(intArrayOf(1, 2, 3), intArrayOf(1, 1)))
}