package December23

import kotlin.math.min


fun main() {
    println(minDifficultyApproach1(intArrayOf(6,5,4,3,2,1), 2))
    println(minDifficultyApproach2(intArrayOf(6,5,4,3,2,1), 2))
    println(minDifficultyApproach3(intArrayOf(6,5,4,3,2,1), 2))
}

/**
 *  Approach 3:
 *     - The function minDifficulty takes an array of job difficulties (jobDifficulty) and the
 *          required number of days (d) as input.
 *     - It checks if it's impossible to complete the jobs in d days (when the number of jobs is
 *          less than (d). If so, it returns -1.
 *     - It initializes a 2D array dp to store the minimum difficulties for various subproblems.
 *          dp[i][j] represents the minimum difficulty to complete the first i jobs in j days.
 *     - The base case dp[0][0] is initialized to 0, as there is no difficulty when there are 0 jobs
 *          and 0 days.
 *     - The code then uses nested loops to iterate through the jobs (i) and the available days (days).
 *     - Inside the loops, it calculates the maximum difficulty (maxDifficulty) for the current job based
 *          on the previous maximum difficulty and the job's difficulty.
 *     - It then iterates through possible partitions of jobs, where the number of jobs is greater than or
 *          equal to the available days (j in i downTo days). This is an optimization that reduces unnecessary iterations.
 *
 *  Time complexity: O(n*d)
 *  Space complexity: O(n*d)
 */

fun minDifficultyApproach3(jobDifficulty: IntArray, d: Int): Int {
    val n = jobDifficulty.size
    if (n < d) return -1  // Check if it's impossible to complete the jobs in 'd' days

    // Create a 2D array 'dp' to store minimum difficulties for each subproblem
    val dp = Array(n + 1) { IntArray(d + 1) { 12000 } }
    dp[0][0] = 0  // Initialize the base case: 0 difficulty for 0 days and 0 jobs

    for (i in 1..n) {  // Iterate through the jobs
        for (days in 1..d) {  // Iterate through the available days
            var maxDifficulty = 0  // Initialize the maximum difficulty for the current job/day
            dp[i][days] = 12000  // Initialize the current subproblem's difficulty to a high value

            // Iterate through possible partitions where the number of jobs is greater than or equal to the available days
            for (j in i downTo days) {
                maxDifficulty = maxOf(maxDifficulty, jobDifficulty[j - 1])
                // Calculate the minimum difficulty for the current combination of jobs and days
                dp[i][days] = minOf(dp[i][days], maxDifficulty + dp[j - 1][days - 1])
            }
        }
    }

    // The minimum difficulty for completing all the jobs in 'd' days is stored in dp[n][d]
    return dp[n][d]
}


/**
 *  Approach 2:
 * - The function minDifficulty takes an array of job difficulties (jobDifficulty) and the
 *      required number of days (d) as input.
 *  - It checks if it's impossible to complete the jobs in d days (when the number of jobs is
 *      less than d). If so, it returns -1.
 *  - It initializes a 2D array dp to store the minimum difficulties for various subproblems.
 *      dp[i][j] represents the minimum difficulty to complete the first i jobs in j days.
 *  - The base case dp[0][0] is initialized to 0, as there is no difficulty when there are 0 jobs and 0 days.
 *  - The code then uses nested loops to iterate through the jobs (i) and the available days (days).
 *  - Inside the loops, it calculates the maximum difficulty (maxDifficulty) for the current job based on the
 *      previous maximum difficulty and the job's difficulty.
 *  - It then iterates through all possible partitions of jobs for the current day (j).
 *      For each partition, it calculates the minimum difficulty and updates the dp array accordingly.
 *
 *  Time complexity: O(n^2*d)
 *  Space complexity: O(n*d)
 */

fun minDifficultyApproach2(jobDifficulty: IntArray, d: Int): Int {
    val n = jobDifficulty.size
    if (n < d) return -1  // Check if it's impossible to complete the jobs in 'd' days

    // Create a 2D array 'dp' to store minimum difficulties for each subproblem
    val dp = Array(n + 1) { IntArray(d + 1) { Int.MAX_VALUE } }
    dp[0][0] = 0  // Initialize the base case: 0 difficulty for 0 days and 0 jobs

    for (i in 1..n) {  // Iterate through the jobs
        for (days in 1..d) {  // Iterate through the available days
            var maxDifficulty = 0  // Initialize the maximum difficulty for the current job/day
            for (j in i downTo 1) {  // Explore all possible partitions of jobs for the current day
                maxDifficulty = maxOf(maxDifficulty, jobDifficulty[j - 1])
                // Calculate the minimum difficulty for the current combination of jobs and days
                dp[i][days] = minOf(dp[i][days], maxDifficulty + dp[j - 1][days - 1])
            }
        }
    }

    // The minimum difficulty for completing all the jobs in 'd' days is stored in dp[n][d]
    return dp[n][d]
}


/**
 * Approach 1: Refer NeetCode video - https://www.youtube.com/watch?v=DAAULrZFeLI
 * Suppose jobDifficulty is [6, 5, 4, 3, 2, 1] and d is 2.
 *
 *  -The function starts by checking if it's possible to complete the jobs in d days.
 *      In this case, it's possible because jobDifficulty.size is not less than d.
 *
 *  -It initializes a cache (mutableMapOf) to store intermediate results.
 *
 *  -The main recursive function dfs is called initially with i = 0 (the first job),
 *    days = d (initially, both days are available), and currMax = -1 (no previous maximum difficulty).
 *
 *  -Inside dfs, it computes the maximum difficulty of the current job (temp) by comparing it
 *   with the previous maximum difficulty (currMax).
 *
 *  -It then recursively explores two options:
 *
 *      Option 1: Continue with the current job (dfs(i + 1, days, temp)), reducing the number of available days.
 *      Option 2: Start a new day with the current job's difficulty (temp + dfs(i + 1, days - 1, -1)).
 *      It chooses the minimum difficulty between these two options and caches the result for this combination of parameters in the cache map.
 *
 *  -The function continues to explore different combinations of jobs and days, memoizing results along the way.
 *
 *  Time complexity: O(n^2*d)
 */
fun minDifficultyApproach1(jobDifficulty: IntArray, d: Int): Int {
    // Check if it's impossible to complete the jobs in 'd' days
    if (jobDifficulty.size < d) return -1

    // Create a cache to store previously computed results
    val cache = mutableMapOf<String, Int>()

    // Define the recursive function
    fun dfs(i: Int, days: Int, currMax: Int): Int {
        // Create a unique key for memoization based on 'i', 'days', and 'currMax'
        val key = "$i-$days-$currMax"

        // Base case: If we have processed all jobs and still have days left
        if (i == jobDifficulty.size) {
            // If there are no more days left, return 0 (no additional difficulty)
            return if (days == 0) {
                0
            } else {
                // If there are days left but no jobs, return a high value (invalid)
                12000
            }
        }

        // Base case: If we have days left but no more jobs, return a high value (invalid)
        if (days == 0) return 12000

        // Check if the result for this combination of 'i', 'days', and 'currMax' is already cached
        if (cache.contains(key)) return cache[key]!!

        // Calculate the maximum difficulty for the current job
        val temp = maxOf(currMax, jobDifficulty[i])

        // Calculate the minimum difficulty for the remaining jobs and days by considering two options:
        val result = min(
            // Option 1: Continue with the current job and reduce the number of days
            dfs(i + 1, days, temp),
            // Option 2: Start a new day with the current job's difficulty
            temp + dfs(i + 1, days - 1, -1)
        )

        // Cache the result for future use
        cache[key] = result

        // Return the minimum difficulty for this combination of 'i', 'days', and 'currMax'
        return result
    }

    // Start the recursive process from the first job, with 'd' days, and no previous maximum difficulty
    return dfs(0, d, -1)
}
