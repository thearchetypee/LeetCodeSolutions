package Arrays

import java.util.Arrays.toString

fun main() {
    print(getConcatenation(intArrayOf(1, 2, 3,)).contentToString())
}

fun getConcatenation(nums: IntArray): IntArray {
    val size = nums.size
    val ans = IntArray(2*size)
    for (i in 0 until 2*size){
        ans[i] = nums[i%size]
    }
    return ans
}