package January24

/**
 * 1. We create a 2D array dp of size (m + 1) x (n + 1) to store the length of the
 *  LCS between different substrings of text1 and text2.
 * 2. We iterate through both strings using nested loops. If the characters match,
 *  we increment the LCS length by 1; otherwise, we take the maximum of the LCS lengths
 *  obtained from removing one character from either string.
 * 3. Finally, dp[m][n] stores the length of the LCS between the entire text1 and text2,
 *  which is the result we return.
 */
fun longestCommonSubsequence(text1: String, text2: String): Int {
    val m = text1.length
    val n = text2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    for (i in 1..m) {
        for (j in 1..n) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }

    return dp[m][n]
}

fun main() {
    val text1 = "abcde"
    val text2 = "ace"
    println(longestCommonSubsequence(text1, text2)) // Output: 3

    val text3 = "abc"
    val text4 = "abc"
    println(longestCommonSubsequence(text3, text4)) // Output: 3

    val text5 = "abc"
    val text6 = "def"
    println(longestCommonSubsequence(text5, text6)) // Output: 0
}
