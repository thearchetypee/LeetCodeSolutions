package January24

import kotlin.math.max


fun rob(nums: IntArray): Int {
    val n = nums.size
    if (n == 0) return 0
    if (n == 1) return nums[0]
    var prevPrev = nums[0]
    var prev = max(nums[0], nums[1])
    var current = 0
    for (i in 2..<n) {
        current = max(prev, prevPrev + nums[i])
        prevPrev = prev
        prev = current
    }

    return prev
}
fun robApproach3(nums: IntArray): Int {
    val n = nums.size
    if (n == 0) return 0
    if (n == 1) return nums[0]
    val dp = IntArray(n) { -1 }
    dp[0] = nums[0]
    dp[1] = max(nums[0], nums[1])
    for (i in 2..<n) {
        dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
    }

    return dp[n - 1]
}

fun robApproach2(nums: IntArray): Int {
    val n = nums.size
    val memo = IntArray(n) { -1 }
    fun dfs(i: Int): Int {
        if (i >= n) return 0
        if (memo[i] != -1) return memo[i]

        val pick = nums[i] + dfs(i + 2)
        val notPick = dfs(i + 1)
        memo[i] = max(pick, notPick)
        return memo[i]
    }
    return dfs(0)
}

fun robApproach1(nums: IntArray): Int {
    val n = nums.size
    fun dfs(i: Int): Int {
        if (i >= n) return 0

        val pick = nums[i] + dfs(i + 2)
        val notPick = dfs(i + 1)
        return max(pick, notPick)
    }

    return dfs(0)
}