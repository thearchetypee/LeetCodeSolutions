package December

fun isPathCrossing(path: String): Boolean {
    val visits = mutableSetOf<String>()
    var x = 0
    var y = 0
    visits.add("$x $y")
    for (c in path) {
        when (c) {
            'N' -> {
                if ("$x ${y+1}" in visits) return true
                visits.add("$x ${y+1}")
                y++
            }
            'E' -> {
                if ("${x+1} $y" in visits) return true
                visits.add("${x+1} $y")
                x++
            }
            'S' -> {
                if ("$x ${y-1}" in visits) return true
                visits.add("$x ${y-1}")
                y--
            }
            else -> {
                if ("${x-1} $y" in visits) return true
                visits.add("${x-1} $y")
                x--
            }
        }
    }
    return false
}