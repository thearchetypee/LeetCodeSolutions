package December

fun main() {
    println(makeEqual(arrayOf("abc","aabc","bc")))
}

/**
 *  - Initialize an array charCount of size 26 (assuming the lowercase English alphabet).
 *      Each element of this array will represent the count of each character ('a' to 'z') in
 *      the entire array of strings.
 *
 *  - Iterate through all the strings in the input array words. For each character in each string,
 *      update the corresponding count in the charCount array. For example, if you encounter 'a' in
 *      a string, increment charCount[0] (assuming 'a' is at index 0 in the array).
 *
 *  - After counting the characters in all strings, you need to check if it's possible to make all
 *      strings equal. To do this, iterate through the charCount array. If any character count is not
 *      a multiple of the total number of strings in the array, return false. This is because if a character
 *      count is not divisible by the total number of strings, it won't be possible to distribute that character
 *      equally among all strings.
 *
 *  - If all character counts are divisible by the total number of strings, return true. This means that it's possible
 *      to redistribute the characters among the strings to make them all equal.
 *
 *  Time complexity: O(n*lengthOfLongestWordInArray)
 */

fun makeEqual(words: Array<String>): Boolean {
    // Initialize an array to count the occurrence of each character ('a' to 'z')
    val charCount = IntArray(26)

    // Count the occurrences of characters in each word
    for (word in words) {
        for (char in word) {
            // Calculate the index of the character in the charCount array
            val index = char - 'a'

            // Increment the count for the character
            charCount[index]++
        }
    }

    // Get the total number of words in the input
    val totalWords = words.size

    // Check if all characters occur a multiple of totalWords times
    for (count in charCount) {
        if (count % totalWords != 0) {
            // If any character count is not a multiple of totalWords, it's not possible to make all words equal
            return false
        }
    }

    // If all characters occur a multiple of totalWords times, it's possible to make all words equal
    return true
}
