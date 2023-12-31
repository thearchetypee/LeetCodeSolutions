package December

/**
 *  Refer to NeedCode - https://www.youtube.com/watch?v=6aEyTjOwlJU
 */
fun numDecodings(s: String): Int {
    val memo = IntArray(s.length + 1) { -1 } // Memoization array to store computed results

    // Helper function using depth-first search (DFS)
    fun dfs(s: String, curr: Int, n: Int): Int {
        // Base case: If the current index is beyond the string length, return 1 (a valid decoding)
        if (curr >= n) return 1

        // If the result for the current index has been memoized, return it
        if (memo[curr] != -1) return memo[curr]

        val ch = s[curr] // Current character
        if (ch == '0') return 0 // If the current character is '0', it can't be decoded on its own
        val nextCh = if (curr < n - 1) s[curr + 1] else 'N' // Next character (or 'N' if it's out of bounds)

        // Try picking one character (if it's not '0')
        val pickOne = if (nextCh != '0') dfs(s, curr + 1, n) else 0

        // Try picking two characters (if the combination is valid)
        val pickTwo = if (nextCh != 'N' && (ch <= '1' || (ch == '2' && nextCh <= '6'))) dfs(s, curr + 2, n) else 0

        // Store the result in the memoization array
        memo[curr] = pickOne + pickTwo

        // Return the total number of valid decodings
        return memo[curr]
    }

    val ans = dfs(s, 0, s.length)

    // If there are no valid decodings, return 0; otherwise, return the computed result
    return if (ans == -1) 0 else ans
}


fun main() {
    println(numDecodings("226"))
}