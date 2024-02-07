package December23

import kotlin.math.min

/**
 * Approach:
 *  To make string alternating we have to make sure that every consecutive
 *  char is different. First thought in mind comes as to iterate over string and change the
 *  char if it is same as previous one but that way we can't find the minimum number of operations.
 *  This is a binary string which means it can have '0' and '1' only. So a string of length 2
 *  can either start with either '0' or '1' i.e. '01' or '10' so that the string is alternating.
 *  Now we can implement this theory in longer string also. There are only 2 possible alternating
 *  string one starts with '0' and other with '1'. So we create two variable to keep track
 *  of Number of operations for '1'-starting pattern and Number of operations for '0'-starting pattern.
 *  We iterate over string and check if the current character doesn't match the expected '1'-starting pattern
 *  and similarly check if the current character doesn't match the expected '0'-starting pattern.
 *  After checking the current char we toggle the expected characters for the next iteration
 *
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
fun minOperations(s: String): Int {
    var currCharWithOne = '1'    // Current expected character when starting with '1'
    var currCharWithZero = '0'   // Current expected character when starting with '0'
    var currOpWithOne = 0        // Number of operations for '1'-starting pattern
    var currOpWithZero = 0       // Number of operations for '0'-starting pattern

    for (c in s) {
        if (currCharWithOne != c) {
            currOpWithOne++       // Increment the operation count for '1'-starting pattern
        }

        if (currCharWithZero != c) {
            currOpWithZero++      // Increment the operation count for '0'-starting pattern
        }

        currCharWithOne = if (currCharWithOne == '1') '0' else '1'
        currCharWithZero = if (currCharWithZero == '1') '0' else '1'
    }

    // Return the minimum of the two operation counts, as it represents the minimum required operations
    return min(currOpWithZero, currOpWithOne)
}

fun main() {
    println(minOperations("10010100"))
}
