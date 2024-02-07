package February24


/**
 * Maintain an array of count which will hold the number of
 * occurrence of a character. In question constraints are given that
 * string will only contain lowercase character that means we can maintain
 * an array of length 26. Now iterate over string and increase the count of
 * characters. Now we have count of all the characters, so we again iterate
 * over string and check for first character with count one. If we find a char
 * with count 1 then return it otherwise return -1.
 */
fun firstUniqueChar(s: String): Int {
    val count = IntArray(26) { 0 }
    for(i in s) {
        count[i-'a']++
    }

    for (i in s.indices) {
        if (count[s[i]-'a'] == 1) {
            return i
        }
    }
    return -1
}