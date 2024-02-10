package February24

/**
 * The idea behind this solution is to reduce the time complexity to O(n^2).
 * Let's analyse our brute force solution.
 *  - To get all possible substrings it is taking O(n^2). We cannot optimise
 *     this part as we have to calculate all the substring to check if it's a palindrome
 *     or not.
 *  - Second part of that algorithm check if a string is palindrome or not which takes
 *    O(n) for each substring. If somehow we can find a way to check if a string is palindrome
 *    or not in O(1) then we can reduce the time complexity to O(n^2).
 *
 * How can we check if a string is palindrome or not in O(1)?
 *  - If we know a string is palindrome or not then we can use this info to check if new
 *     string is palindrome after adding character in O(1). e.g. 'aba' is a palindrome
 *     and if we add 'c' on both side i.e. 'cabac' then we only have to check if these
 *     new char are equal of not(which we can do in O(1)).
 *     So we will treat each index as middle index of string and expand both sides by adding
 *     new character on both sides. If any point we find new char are not equal, we move to
 *     next index and if they are equal we increment the result.
 *     But wait, What about even length substring? This above approach only take care
 *     of odd length string e.g. we start with length 1 and added two elements, so size
 *     became 3 and then 5 and so on. To tackle that at every index we will also
 *     start with substring of length 2 e.g. 'aaa' at index 0 we will start with i = 0 and
 *     j = 1 and then keep adding char at both end of substring.
 *
 *  Lets walkthrough the code step by step:
 *  1. Initialise variable result with 0. This will hold the count of palindromic
 *      substrings.
 *  2. Iterate through the element of char using a loop variable i from 0 to n-1.
 *  3. Inside that loop initialise two variables j and k with value i which will denote the
 *      index range of substring.
 *  4. Now start a loop to expand the substring by decrementing j and incrementing k. Check
 *      if new added char to substring are equal or not. If they are equal then increment
 *      the result and keep adding characters, if not then break the loop.
 *  5. Similarly, handle the even length substring by initialising j and k with i and i+1.
 *
 * Time Complexity: O(n^2)
 */
fun countSubstrings(s: String): Int {
    val n = s.length
    var result = 0
    for (i in 0..<n) {
        var j = i
        var k = i
        while (j >= 0 && k < n && s[j] == s[k]) {
            result++
            j--
            k++
        }
        j = i
        k = i+1
        while (j >= 0 && k < n && s[j] == s[k]) {
            result++
            j--
            k++
        }
    }

    return result
}

/**
 * First we tried with brute force approach. Calculating all possible
 * substring and checking if it's a palindrome or not. If it is a palindrome
 * then increasing the count.
 *
 * Time Complexity: O(n^3)
 */
fun countSubstringsApproach1(s: String): Int {
    var ans = 0
    val n = s.length
    for (i in 0..<n) {
        for (j in i..<n) {
            if (isPalindrome(s, i, j)) {
                ans++
            }
        }
    }
    return ans
}

fun isPalindrome(s: String, m: Int, n: Int): Boolean {
    var i = m
    var j = n
    while (i < j) {
        if (s[i] != s[j]) return false
        i++
        j--
    }
    return true
}

fun main() {
    println(countSubstringsApproach1("abc"))
}