package Arrays

fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
    points.sortBy { it[0] }
    var max = Integer.MIN_VALUE

    for (i in 1..<points.size) {
        if (max<(points[i][0]-points[i-1][0])) {
            max = points[i][0]-points[i-1][0]
        }
    }
    return max
}