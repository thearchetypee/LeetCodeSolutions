package Arrays

import kotlin.math.max

fun main() {
    println(lengthOfLongestSubstring(" "))
}

fun lengthOfLongestSubstring(s: String): Int {
    val charOccurrenceMap = mutableMapOf<Char, Int>()
    var i = 0
    var j = 0
    var ans = 0
    var temp = 0
    while (i < s.length && j < s.length) {
        if (charOccurrenceMap.containsKey(s[j]).not()) {
            temp++
            ans = max(temp, ans)
            charOccurrenceMap[s[j]] = 1
            j++
        } else {
            temp --
            charOccurrenceMap.remove(s[i])
            i++
        }
    }

    return ans
}
