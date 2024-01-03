package January

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val leftArr = IntArray(n)
    val rightArr = IntArray(n)
    var curr = 1

    // Calculate the product of elements to the left of each element
    for (i in 0 until n) {
        curr *= nums[i]
        leftArr[i] = curr
    }

    curr = 1

    // Calculate the product of elements to the right of each element
    for (i in n - 1 downTo 0) {
        curr *= nums[i]
        rightArr[i] = curr
    }

    // Calculate the final result by multiplying left and right products for each element
    for (i in nums.indices) {
        val left = if (i > 0) leftArr[i - 1] else 1
        val right = if (i < n - 1) rightArr[i + 1] else 1
        nums[i] = left * right
    }

    return nums
}

fun main() {
    println(productExceptSelf(intArrayOf(1,2,3, 4)))
}