package January

/**
 * Approach 1:
 *  First we can store the count of each num in a map.
 *  Now to minimise the number of operations we will try to maximise the removal of triplets.
 *  Any number divided by 3 will lead only three remainder i.e. 0, 1, 2
 *  If remainder is 0 than we will remove all the values in a pair of 3. In this case we add the
 *  count/3 to ans.
 *  If remainder is 1 that means we have to store count/3 - 1 which will leave 4 elements which
 *  can be removed by pair of 2 so that will lead to
 *  ans += count/3 - 1 + 2 i.e. ans += count/3 + 1
 *  If remainder is 2 that means we can remove remaining a pair later
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(n)
 */
fun minOperations(nums: IntArray): Int {
    val mp = mutableMapOf<Int, Int>()

    // Count the frequency of each number in the array
    for (num in nums) {
        mp[num] = mp.getOrDefault(num, 0) + 1
    }

    var ans = 0

    for (value in mp.values) {
        ans += when {
            value == 1 ->  return -1 // Not possible to achieve a balanced count
            value % 3 == 0 -> value / 3 // Divide by 3 evenly
            value % 3 == 2 || value % 3 == 1 -> (value / 3) + 1 // Divide by 3 with remainder
            else -> return -1 // Not possible to achieve a balanced count
        }
    }
    return ans
}

fun main() {
    println(minOperations(intArrayOf(2,3,3,2,2,4,2,3,4)))
}