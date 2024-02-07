package December23

/**
 *  Approach 1: The jump function calls the jumpRecursive function with the initial position set to 0.
 *  The jumpRecursive function explores all possible jump positions from the current position and recursively
 *  calculates the minimum number of jumps required to reach the end. The base case is when we reach the last index,
 *  in which case we return 0 jumps. Otherwise, we iterate through all possible jump positions and calculate the number
 *  of jumps needed.
 *  Time Complexity: O(2^n)
 *  Space Complexity: O(n)
 *
 *  Approach 2: The jump function iterates through the nums array and keeps track of the farthest index it can reach from
 *  the current position. When the current position reaches the currentEnd,
 *  it means we need to make a jump, so we increment the jumps counter and update currentEnd to the farthest index we can
 *  reach so far. Finally, we return the total number of jumps required to reach the last index.
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(1)
 */

fun main() {
    val nums1 = intArrayOf(2, 3, 1, 1, 4)
    println(jumpApproach1(nums1)) // Output: 2

    val nums2 = intArrayOf(2, 3, 0, 1, 4)
    println(jump(nums2)) // Output: 2
}

// Approach 2
fun jump(nums: IntArray): Int {
    val n = nums.size
    var jumps = 0
    var currentEnd = 0
    var farthest = 0

    for (i in 0 until n - 1) {
        farthest = maxOf(farthest, i + nums[i])

        if (i == currentEnd) {
            jumps++
            currentEnd = farthest
        }
    }

    return jumps
}


// Approach 1
fun jumpApproach1(nums: IntArray): Int {
    return jumpRecursive(nums, 0)
}

fun jumpRecursive(nums: IntArray, position: Int): Int {
    val n = nums.size
    if (position == n - 1) {
        return 0
    }

    var minJumps = Int.MAX_VALUE
    val maxJump = minOf(position + nums[position], n - 1)
    for (nextPos in (position + 1)..maxJump) {
        val jumps = 1 + jumpRecursive(nums, nextPos)
        minJumps = minOf(minJumps, jumps)
    }

    return minJumps
}