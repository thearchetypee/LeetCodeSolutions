package January

import kotlin.math.min

fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val n = matrix.size

    fun dfs(i: Int, j: Int): Int {
        if (i == n-1) return matrix[i][j]
        var leftBottom = Integer.MAX_VALUE
        var rightBottom = Integer.MAX_VALUE
        if (j+1 < n) {
            rightBottom = matrix[i][j] + dfs(i+1, j+1)
        }

        if (j-1 >= 0) {
            leftBottom = matrix[i][j] + dfs(i+1, j-1)
        }
        val bottom = matrix[i][j] + dfs(i+1, j)
        return min(bottom, min(leftBottom, rightBottom))
    }

    var ans = Integer.MAX_VALUE
    for (i in 0..<n) {
        ans = min(ans, dfs(0, i))
    }

    return ans
}