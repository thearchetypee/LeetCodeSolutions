package January24

/**
 * Approach:
 *  The h-index is defined as the maximum value of h such that the given researcher has published
 *  at least h papers that have each been cited at least h times.
 *  So find hIndex we can sort the citations in descending order and then we iterate
 *  through array checking if the citation received at ith index (which is number of paper published which
 *  has received more citation than current index) is greater than i.
 *  Keep track of the max index till now.
 *
 *  Time Complexity: O(nlogn)
 *  Space Complexity: O(1)
 */
fun hIndex(citations: IntArray): Int {
    citations.sortDescending() // Sort the citations in descending order
    var ans = 0

    for ((index, c) in citations.withIndex()) {
        if (c >= (index + 1)) {
            ans = maxOf(index + 1, ans)
        }
    }

    return ans // Return the calculated H-index.
}

fun main() {
    println(hIndex(intArrayOf(1, 3, 1)))
}