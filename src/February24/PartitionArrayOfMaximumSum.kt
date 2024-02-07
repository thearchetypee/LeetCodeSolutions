package February24

import kotlin.math.max

/**
 * 1. Initialize the variables:
 *  - n as the size of the input array arr.
 *  - dp as an array to store the maximum sum of partitioned subarrays.
 *      Initialize it with all zeros.
 *  - Set the first element of dp as the first element of arr.
 *
 * 2. Iterate through the elements of the array using a loop variable i from 0 to n-1.
 *
 * 3. Inside the loop, initialize a variable currMax to store the maximum value encountered
 *      so far.
 *
 * 4. Iterate from j = 0 to k-1. This loop represents the current partition size.
 *
 * 5. Check if the index i - j is within bounds. If it's out of bounds (i.e., less than 0),
 *      continue to the next iteration of the loop.
 *
 * 6. Update currMax by taking the maximum of the current element arr[i - j] and the current maximum currMax.
 *
 * 7. Update the value of dp[i] by taking the maximum of:
 *      - The current value of dp[i].
 *      - The sum of the maximum value currMax multiplied by the current
 *         partition size (j+1) and the maximum sum of the previous partition (i-j-1).
 * 8. After the loops, return the value of dp[n-1], which represents the maximum sum after
 *  partitioning the array.
 * ------------------------------------------------------------------------------------
 * Let's illustrate this with an example:
 * Input: arr = [1, 15, 7, 9, 2, 5, 10], k = 3
 *
 *  - n = 7 (size of arr)
 *  - Initialize dp = [0, 0, 0, 0, 0, 0, 0]
 *  - Start iterating through the elements of arr:
 *  - For i = 0, update dp[0] = arr[0] = 1
 *  - For i = 1:
 *      - Calculate currMax = 15 (max of arr[1])
 *      - Calculate dp[1] as max(15*1 + dp[0], 1) = max(15 + 0, 1) = 15
 *  - For i = 2:
 *      - Calculate currMax = 15 (max of arr[1])
 *      - Calculate dp[2] as max(15*1 + dp[1], 15) = max(15 + 15, 15) = 30
 *  - Continue similarly for other values of i.
 *
 * Finally, return dp[6] = 30, which represents the maximum sum after partitioning
 *  the array.
 */
fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
    val n = arr.size
    val dp = IntArray(n) { 0 }
    dp[0] = arr[0]
    for (i in 0..<n) {
        var currMax = 0
        for (j in 0..<k) {
            if (i - j < 0) continue // out of bound
            currMax =  max(arr[i - j], currMax)
            dp[i] = max(dp[i], currMax * (j+1) + if (i - j -1 < 0) 0 else dp[i-j - 1])
        }
    }
    return dp[n-1]
}

fun main() {
    println(maxSumAfterPartitioning(intArrayOf(1,15,7,9,2,5,10), 3))
}