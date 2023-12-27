package December

import java.util.PriorityQueue

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val compare = { arr1: IntArray, arr2: IntArray ->
        (nums1[arr1[0]] + nums2[arr1[1]]).compareTo(nums1[arr2[0]] + nums2[arr2[1]])
    }
    val visited = mutableSetOf<String>()
    val queue = PriorityQueue(compare)
    val result = mutableListOf<List<Int>>()
    queue.add(intArrayOf(0, 0))
    for (m in 0..<k) {
        val (i, j) = queue.poll()
        val k1 = "${i+1} $j"
        if ((i+1) < nums1.size && k1 !in visited) {
            queue.add(intArrayOf(i+1, j))
            visited.add(k1)
        }

        val k2 = "$i ${j+1}"
        if ((j+1) < nums2.size && k2 !in visited) {
            queue.add(intArrayOf(i, j+1))
            visited.add(k2)
        }
        result.add(listOf(i, j))
    }
    return result
}