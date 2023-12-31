package December

fun main() {
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
}

/**
 * Approach:
 *  - The code starts with the goal variable initialized to the last index of the nums
 *      array and the i variable initialized to the second-to-last index.
 *
 *  - It then enters a while loop that iterates from the second-to-last index (i) down
 *      to the first index (inclusive).
 *
 *  - Inside the loop, it calculates the distance from the current index (i) to the goal
 *      (the last index).
 *
 *  - It checks if the value at the current index (nums[i]) is greater than or equal to the
 *      distance. If it is, this means that you can jump from the current position to reach
 *      the goal, so it updates the goal to the current index (i).
 *
 *  - The loop continues until it reaches the beginning of the array (index 0) or until it
 *      determines that it's not possible to reach the goal.
 *
 *  - Finally, it checks if the goal has reached the beginning of the array (index 0). If it has,
 *      it returns true, indicating that it's possible to reach the last index; otherwise, it returns false.
 */

fun canJump(nums: IntArray): Boolean {
    var goal = nums.size - 1 // Initialize the goal to the last index
    var i = nums.size - 2    // Start iterating from the second-to-last index

    while (i >= 0) {
        val distance = goal - i // Calculate the distance from the current index to the goal

        if (nums[i] >= distance) {
            // If the value at the current index can cover or exceed the required distance
            // to reach the goal, update the goal to the current index.
            goal = i
        }
        i--
    }

    // If the goal has reached the beginning of the array (index 0), return true;
    // otherwise, return false as it means we can reach the end starting from the beginning.
    return goal == 0
}
