package Arrays

fun main() {
    val arr = intArrayOf(1, 1, 1, 2, 2, 3)
    println(removeDuplicates(arr))
}

fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    for(num in nums) {
        if (i < 2 || num > nums[i-2]) {
            nums[i++] = num
        }
    }
    return i
}