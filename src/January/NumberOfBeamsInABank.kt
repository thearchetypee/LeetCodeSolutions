package January

/**
 * Approach:
 *  As per conditions given in question every device on row r1 can make a beam with every device
 *  at r2 where r1<r2. Another condition is that For each row i where r1 < i < r2, there are no
 *  security devices in the ith row.
 *  Lets first ignore the second condition.
 *  Now if r1 has 2 devices and r2 has 2 devices than how many rays can be in between these two
 *  rows?
 *  First device of r1 can have two rays on each device of r2 that means total of 2*2 = 4 rays.
 *  By this approach we have to check how many ones are there in adjacent rows and multiply it
 *  to get the ans.
 *  Pretty straight forward right?
 *  Well here comes the second condition. According to which if there is r3 which also have 2 devices
 *  than r1 can't make beams with r3 devices because r2 has 2 devices.
 *  Lets take a look where r1 can make beams with r3. r1 and r3 devices can only make beams if
 *  there is no devices in r2.
 *
 *  Now with above approach we count number of devices in each row (i.e. number of ones) and multiply it
 *  with prev row. We also keep track of prev row by updating it with current row if current row have any
 *  devices.
 *
 *  Time Complexity: O(m*n)
 *  Space Complexity: O(1)
 */
fun numberOfBeams(bank: Array<String>): Int {
    var ans = 0 // Initialize the result to 0
    var lastRow = 0 // Initialize the count of '1's in the last row to 0

    // Iterate through each row in the bank
    for (row in bank) {
        var currRow = 0 // Initialize the count of '1's in the current row to 0

        // Iterate through each character in the current row
        for (char in row) {
            if (char == '1') {
                currRow++ // Increment the count of '1's in the current row
            }
        }

        // If the current row has at least one '1'
        if (currRow > 0) {
            ans += lastRow * currRow // Update the result by multiplying the counts
            lastRow = currRow // Update the lastRow to the count of '1's in the current row
        }
    }

    return ans // Return the final result
}

fun main() {
    println(numberOfBeams(arrayOf("011001","000000","010101","001000")))
}