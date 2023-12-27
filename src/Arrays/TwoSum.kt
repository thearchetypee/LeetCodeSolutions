package Arrays

import kotlin.math.abs

fun main () {
    println(twoSum(intArrayOf(3, 2, 4), 6).toList())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map : MutableMap<Int, Int> = mutableMapOf()
    nums.forEachIndexed { index, item ->
        map[item] = index
    }
    for (i in nums.indices) {
        val anotherItem = target - nums[i]
        if (map.containsKey(anotherItem) && i != map[anotherItem]!!) {
            return intArrayOf(i, map[anotherItem]!!)
        }
    }

    return intArrayOf()
}
