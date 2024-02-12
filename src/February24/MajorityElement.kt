package February24

/**
 * Approach 2: Boyer-Moore's Voting algorithm
 *
 *  This algorithms finds the majority element, if one exists.
 *  The majority element in an array is an element that occurs more than half of the size of array.
 *
 * **Note:** This algorithm only return majority element if it exists. If there is no majority element,
 *      then this will return arbitrary element. We can make some minor improvement in the algorithm to
 *      return -1 or null if majority element doesn’t exist.
 *
 * ### Algorithm
 *
 * 1. Initialise two variables: `num` and `count` .
 *    `num` will hold the majority element, and `count` will determine if `num` is majority element or not.
 * 2. Iterate through the elements of array
 * 3. If `count` is `0` then set `num` to current element.
 * 4. If current element is equal to `num`, then increment `count`
 * 5. If current element is not equal to `num`,then decrement `count`
 * 6. Return `num` after traversing array
 */

fun majorityElement(nums: IntArray): Int {
    val n = nums.size
    var count = 0
    var num = -1
    for (i in 0..<n) {
        if (count == 0) {
            num = nums[i]
        }
        if(num == nums[i]) {
            count++
        } else {
            count--
        }
    }
    return num
}

/**
 * Approach 1: HashMap
 *
 * To get the majority element we store the number of counts of distinct elements
 * in a map. After we get the count of all distinct element then we iterate over map
 * and check for each distinct element is greater than (size of array)/2.
 * Return once this condition is met.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 */
fun majorityElementApproach1(nums: IntArray): Int {
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