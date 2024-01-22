package January

/**
 * Iterate through array and store elements in set. At every iteration
 * we check if that element already present in the set or not. If it is present
 * that means we found our duplicate element.
 * Once we have all the unique element in the set. We iterate from 1 to n
 * and check for missing number.
 */
fun findErrorNums(nums: IntArray): IntArray {
    val ans = IntArray(2)
    val visited = mutableSetOf<Int>()
    for (i in nums) {
        if (visited.contains(i)) {
            ans[0] = i
        }
        visited.add(i)
    }
    for (i in 1..nums.size) {
        if (!visited.contains(i)) {
            ans[1] = i
            break
        }
    }

    return ans
}