package February24


/**
 * Approach 1
 *
 * To get the majority element we store the number of counts of distinct elements
 * in a map. After we get the count of all distinct element then we iterate over map
 * and check for each distinct element is greater than (size of array)/2.
 * Return once this condition is met.
 */
fun majorityElement(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    val n = nums.size
    for(i in 0..<n) {
        map[nums[i]] = map.getOrDefault(nums[i], 0) + 1
    }

    for ((key, value) in map.entries) {
        if (value > (n/2)) {
            return key
        }
    }
    return 0
}

fun main() {
    println(majorityElement(intArrayOf(2,2,1,1,1,2,2)))
}