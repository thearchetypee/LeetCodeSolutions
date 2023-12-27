package December

fun main() {
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
}

fun canJump(nums: IntArray): Boolean {
    var goal = nums.size-1
    var i = nums.size-2
    // [2, 3, 1, 1, 4]
    while (i >= 0) {
        val distance = goal - i
        if (nums[i] >= distance) {
            goal = i
        }
        i--
    }
    return goal == 0
}