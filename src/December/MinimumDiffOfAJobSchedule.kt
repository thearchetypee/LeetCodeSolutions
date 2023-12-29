package December

import kotlin.math.min


fun main() {
    println(minDifficultyApproach1(intArrayOf(6,5,4,3,2,1), 2))
}

/**
 * Approach 1:
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
