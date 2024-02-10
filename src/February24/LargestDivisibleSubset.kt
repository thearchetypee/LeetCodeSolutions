package February24

/**
 * Approach:
 * 1. Sort the Array ( ascending order )
 * 2. For Each Element traverse the previous element
 * 3. If element is divisible by any previous element it means
 *    it can be part of that group by we also need to make sure
 *    it is part of the group with maximum size, So if we found
 *    any bigger group we will add it to that group
 * 4. If we update the group size, it means we have added new element
 *    I will update my previous of the current element with group's maximum
 *    till now ( before adding )
 * 5. I will also track the index of the last element added in the biggest group
 * 6. Now I will backtraverse from that maximum index ( defined in previous point )
 *     using my previous element array and one by one add into my result list
 */
fun largestDivisibleSubset(nums: IntArray): List<Int> {
    if (nums.isEmpty()) return emptyList()

    nums.sort()
    val n = nums.size
    val dp = IntArray(n) { 1 }
    val prev = IntArray(n) { -1 }

    var maxIndex = 0
    for (i in 1 until n) {
        for (j in 0 until i) {
            if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                dp[i] = dp[j] + 1
                prev[i] = j
            }
        }
        if (dp[i] > dp[maxIndex]) {
            maxIndex = i
        }
    }

    val result = mutableListOf<Int>()
    var currentIndex = maxIndex
    while (currentIndex != -1) {
        result.add(nums[currentIndex])
        currentIndex = prev[currentIndex]
    }

    return result
}

fun main() {
    println(largestDivisibleSubset(intArrayOf(5, 9, 18, 54, 108, 540, 90, 180, 360, 720)))
}