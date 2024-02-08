package February24

import kotlin.math.min

/**
 * The problem statement is to find the minimum number of perfect square
 * that sum to `n`.
 * First intuition comes to mind is to check every square from starting
 * from 1 and check if `n` can be divided into that square number. If it
 * can be divided into square number, we store the count for the square
 * number to be added to reach 'n'(i.e. quotient of n/square number) in ans var.
 * We iterate until n and update the ans value if we find new count which is less
 * than ans.
 * Now, The above approach will work for if n/square number doesn't have any remainder.
 * To solve if it leaves a remainder we will treat remainder as new problem and
 * recursively call same function with remainder. We add the result return from
 * recursive call to the quotient of n/square number.
 *
 */
fun numSquares(n: Int): Int {
    val memo = IntArray(n+1) { -1 }
    fun dfs(rem: Int): Int {
        if (rem == 0) return 0
        if (memo[rem] != -1) return memo[rem]
        var i = 1
        var ans = Integer.MAX_VALUE
        while(i*i <= rem) {
            val square = i*i
            ans = if(rem%square == 0) {
                min(ans, rem/square)
            } else {
                val remainder = rem%square
                val quot = rem/square
                min(ans, quot+dfs(remainder))
            }
            i++
        }
        memo[rem] = ans
        return memo[ans]
    }
    return dfs(n)
}

fun main() {
    println(numSquares(13))
}