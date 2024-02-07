package December23

fun main() {
    println(maxLengthBetweenEqualCharacters("abca"))
}

/**
 * Approach  :
 *
 * - `ans` is initialized to -1, which will be used to store the maximum distance
 *      between equal characters found in the string.
 *
 * - indArr is an integer array of size 26, initialized to all -1s. It is used to
 *      keep track of the last seen index of each lowercase letter ('a' to 'z') in the input string.
 *
 * - The function iterates through the characters of the input string s using s.withIndex().
 *      For each character, it checks if it has been seen before by examining the corresponding
 *      index in the indArr array.
 *
 * - If the character is seen for the first time (i.e., its index in indArr is -1), the function updates
 *      the indArr array with the current index.
 *
 * - If the character has been seen before, the function calculates the distance between the current index
 *      and the last seen index of that character. It then updates `ans` with the maximum of its current value
 *      and this calculated distance.
 *
 *  - Finally, the function returns the maximum distance (ans) between equal characters found in the input string.
 *
 */
fun maxLengthBetweenEqualCharacters(s: String): Int {
    var ans = -1                    // Initialize the answer as -1
    val indArr = IntArray(26) { -1 } // Create an integer array to store the last seen index of each character (initialized to -1)

    for ((index, char) in s.withIndex()) {
        if (indArr[char - 'a'] == -1) {
            // If this character is seen for the first time, store its index in the indArr array
            indArr[char - 'a'] = index
        } else {
            // If this character has been seen before, calculate the distance between the current index and the last seen index
            ans = maxOf(ans, (index - indArr[char - 'a'] - 1))
        }
    }

    return ans
}
