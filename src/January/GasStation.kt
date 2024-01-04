package January



fun canCompleteCircuitApproach1(gas: IntArray, cost: IntArray): Int {
    val n = gas.size

    // Iterate through each starting station
    for (i in 0 until n) {
        var currGas = 0
        var currIndex = i

        // Iterate through the stations in a circular manner
        for (j in 0 until n) {
            val index = (j + i) % n

            // Check if we can reach the next station
            if (gas[index] + currGas >= cost[index]) {
                currGas += (gas[index] - cost[index])
                currIndex = index
            } else {
                // If we can't reach the next station, exit the loop
                break
            }
        }

        // Check if we have successfully completed the circuit
        if (i == 0 && currIndex == n - 1 && currGas >= 0) {
            return i // Starting station found
        } else if (currIndex == i - 1 && currGas >= 0) {
            return i // Starting station found
        }
    }

    return -1 // No valid starting station found
}

fun main() {
    println(canCompleteCircuitApproach1(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)))
}
