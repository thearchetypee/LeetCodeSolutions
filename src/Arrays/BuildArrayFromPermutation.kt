package Arrays

import java.util.*


fun main(){
    val arr = intArrayOf(0,2,1,5,3,4)
    println(buildArray(arr).contentToString())
}

fun buildArray(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)

    for (i in nums.indices){
        ans[i] = nums[nums[i]]
    }
    return ans
}