package January


fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    val n = gas.size
    var currGas = 0 // Current gas at the current station
    var totalGas = 0 // Total gas surplus/deficit over the entire circuit
    var startIndex = 0 // Index of the starting station

    for (i in 0 until n) {
        val diff = gas[i] - cost[i] // Calculate the gas difference at the current station
        currGas += diff // Add the difference to the current gas

        totalGas += diff // Update the total gas surplus/deficit

        if (currGas < 0) {
            // If we run out of gas at the current station, reset the starting station
            currGas = 0
            startIndex = i + 1
        }
    }

    if (totalGas < 0) {
        // If the total gas surplus/deficit is negative, it's not possible to complete the circuit
        return -1
    }

    return startIndex // Return the index of the valid starting station
}

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
