package December23

import java.util.PriorityQueue

/**
 *  Approach:
 *  As we look at the question one thing is clear that indexes (0, 0) will always be the smallest pair.
 *  Now from there next smaller element can be either (0, 1), (1, 1) or (1, 0).
 *  So we define a priority queue which has a comparator to compare pairs based on
 *  the sum of their corresponding elements in nums1 and nums2. That means priority queue will short the
 *  pair based on the sum in ascending order.
 *  We also have to take care of duplicate values like at (0, 0) we can have two (1, 1).
 *  To handle that we are maintaining a set which will mark a pair visited once it is added
 *  to queue.
 *  We iterates k times, where k represents the number of smallest pairs to find.
 *  And on each iteration, it retrieves the pair with the smallest sum from the priority queue (queue.poll()).
 *  we then checks and adds two possible next pairs (right and down) to the queue if they are within bounds and haven't been visited before.
 *  The current pair is added to the result list.
 *   Finally, the function returns the result list containing the k smallest pairs.
 *
 *   Time complexity: O(k*logk)
 *   Space complexity: O(k)
 */
fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    // Create a comparator to compare pairs based on their sum
    val compare = { arr1: IntArray, arr2: IntArray ->
        (nums1[arr1[0]] + nums2[arr1[1]]).compareTo(nums1[arr2[0]] + nums2[arr2[1]])
    }

    val visited = mutableSetOf<String>() // To keep track of visited pairs
    val queue = PriorityQueue(compare) // Priority queue to store pairs sorted by sum
    val result = mutableListOf<List<Int>>() // Result list to store the k smallest pairs

    queue.add(intArrayOf(0, 0)) // Add the initial pair (0, 0) to the queue

    for (m in 0 until k) {
        val (i, j) = queue.poll() // Get the pair with the smallest sum from the queue

        // Check and add the next pairs (right and down) to the queue if they are within bounds
        val k1 = "${i + 1} $j"
        if ((i + 1) < nums1.size && k1 !in visited) {
            queue.add(intArrayOf(i + 1, j))
            visited.add(k1)
        }

        val k2 = "$i ${j + 1}"
        if ((j + 1) < nums2.size && k2 !in visited) {
            queue.add(intArrayOf(i, j + 1))
            visited.add(k2)
        }

        result.add(listOf(nums1[i], nums2[j])) // Add the current pair to the result
    }

    return result // Return the k smallest pairs
}


fun main() {
    kSmallestPairs(intArrayOf(1,7,11), intArrayOf(2,4,6), 3)
}