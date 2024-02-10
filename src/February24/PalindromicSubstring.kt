package February24

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
        for(j in i..<n) {
            if(isPalindrome(s.substring(i, j+1))) {
                ans++
            }
        }
    }
    return ans
}

fun isPalindrome(s: String): Boolean {
    var i = 0
    var j = s.length-1
    while ( i < j) {
        if (s[i] != s[j]) return false
        i++
        j--
    }
    return true
}

fun main() {
    println(countSubstringsApproach1("abc"))
}