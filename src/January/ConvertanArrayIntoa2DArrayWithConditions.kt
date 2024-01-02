package January

/**
 * Approach:
 *  We have to create 2D array with each row having distinct elements. We can look at this in reverse i.e.
 *  the highest number of repeating num is equal to number of rows in 2D array.
 *  e.g. [1, 1, 1, 2, 3, 2]
 *  In this example 1 is repeating 3 times that means we have to create at least 3 rows
 *  i.e. [[1,2,3], [1,2], [1]]
 *  Create an array to keep track of nums[i] count till now. Then we check if the count is less the
 *  ans size(which contains 2D array). If it is less than ans.size that means there is already another element
 *  present which is repeated more or equal times so we can append current nums[i] to existing subarray.
 *  If it count of current num is greater than ans.size than we create new list with that item and
 *  add it to ans.
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(n)
 */
fun findMatrix(nums: IntArray): List<List<Int>> {
    val count = IntArray(nums.size + 1)
    val ans = mutableListOf<MutableList<Int>>() // Initialize a mutable list of lists

    for (value in nums) {
        count[value]++
        if (count[value] <= ans.size) {
            ans[count[value] - 1].add(value) // Append to the existing subarray
        } else {
            ans.add(mutableListOf(value)) // Create a new subarray
        }
    }

    return ans // Return the result
}

fun main() {
    println(findMatrix(intArrayOf(1,3,4,1,2,3,1)))
}