package December23

import kotlin.math.min

/**
 * Approach 1:
 * To eliminate adjacent duplicate colors in a string of balloons, we employ a simple strategy. Starting from index 1,
 * we compare the current color with the previous one. We then determine which balloon to remove based on the minimum
 * time needed, and add that time to the result.
 * For example, if the color is "abaaab" and the neededTime is [1, 2, 3, 6, 1, 5], during the loop iteration at index 3,
 * we identify that the previous element at index 2 is the same color, and the time required to remove it is minimal.
 * Therefore, we add 3 to the result.
 * Edge Case:
 * In scenarios like "ababbbb" with neededTime [5, 3, 5, 5, 4, 8, 1], the previous approach may remove the 4th balloon at index 4
 * because it takes less time than 5. However, at index 5, it removes the 4th balloon again, which has already been taken out.
 * This issue arises because we don't consider the fact that after removing a balloon, we should look back to the previous
 * balloon in the array.
 * Approach 2:
 * To address this problem, we can keep track of the last remaining balloon after each removal. We introduce a variable
 * to store the index of the previously removed balloon and update it if a balloon requires less time than the current one.
 * This enhanced approach ensures that we always consider the last remaining balloon in the array, leading to a more accurate
 * and efficient solution.
 *
 * TimeComplexity: O(n)
 * SpaceComplexity: O(1)
 */


fun main() {
    println(minCost("aaabbbabbbb", intArrayOf(3,5,10,7,5,3,5,5,4,8,1)))
}

fun minCost(colors: String, neededTime: IntArray): Int {
    var ans = 0
    var prevBalloonIndex = 0
    for(i in 1..<colors.length) {
        if (colors[prevBalloonIndex] == colors[i]) {
            ans += min(neededTime[prevBalloonIndex], neededTime[i])
            if (neededTime[prevBalloonIndex] <= neededTime[i]) {
                prevBalloonIndex = i
            }
        } else {
            prevBalloonIndex = i
        }
    }
    return ans
}