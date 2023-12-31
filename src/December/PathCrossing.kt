package December

/**
 * Approach:
 *  We have to check if given the path it crosses itself at any point, that is, if at any time
 *  you are on a location you have previously visited. Return false otherwise.
 *  To check that we maintain a set to keep track of visited path.
 *  Initialise x, y as 0, 0 for starting position and add that in set. Then iterate over
 *  path and increment x and y according to the char i.e. 'N', 'S', 'E' or 'W'.
 *  if we reach to a coordinate which is already visited then return true otherwise false.
 */
fun isPathCrossing(path: String): Boolean {
    val visits = mutableSetOf<String>() // Set to keep track of visited coordinates
    var x = 0 // Initial x-coordinate
    var y = 0 // Initial y-coordinate
    visits.add("$x $y") // Add the starting position to the set of visited coordinates

    // Iterate through each character in the path
    for (c in path) {
        when (c) {
            'N' -> {
                // Move north (increment y)
                if ("$x ${y + 1}" in visits) return true // Check if this position has been visited before
                visits.add("$x ${y + 1}") // Add the new position to the set
                y++ // Update the current y-coordinate
            }
            'E' -> {
                // Move east (increment x)
                if ("${x + 1} $y" in visits) return true
                visits.add("${x + 1} $y")
                x++
            }
            'S' -> {
                // Move south (decrement y)
                if ("$x ${y - 1}" in visits) return true
                visits.add("$x ${y - 1}")
                y--
            }
            else -> {
                // Move west (decrement x)
                if ("${x - 1} $y" in visits) return true
                visits.add("${x - 1} $y")
                x--
            }
        }
    }

    // If there are no crossing points, return false
    return false
}


fun main() {
    println(isPathCrossing("NESWW"))
}