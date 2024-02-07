package February24

/**
 * Refer to - https://youtu.be/jSto0O4AJbM?si=KXqINmVcxAi5rRsu
 */

fun minWindow(s: String, t: String): String {
    if (s.length < t.length) return ""
    val tMap = mutableMapOf<Char, Int>()
    for (c in t) {
        tMap[c] = tMap.getOrElse(c) {0} + 1
    }
    val window = mutableMapOf<Char, Int>()
    val needed = t.length
    var minSubLength = Int.MAX_VALUE
    var indexOfMinSub = Pair(-1, -1)
    var have = 0
    var i = 0
    for (j in s.indices) {
        val c = s[j]
        window[c] = window.getOrElse(c) {0} + 1

        if (c in tMap && window[c]!! <= tMap[c]!!) have++

        while (have == needed) {
            if (j-i+1 < minSubLength) {
                minSubLength = j-i+1
                indexOfMinSub = Pair(i, j)
            }
            window[s[i]] = window[s[i]]?.let { it-1 } ?: 0
            if ((window[s[i]] ?: 0) < (tMap[s[i]] ?: -1)) have--
            i++
        }
    }
    return if (indexOfMinSub.first >= 0 && indexOfMinSub.second>=0) {
        s.substring(indexOfMinSub.first, indexOfMinSub.second+1)
    } else ""
}

fun main() {
    println(minWindow("ADOBECODEBANC", "ABC"))
}