package January

fun halvesAreAlike(s: String): Boolean {
    val size = s.length
    val set = mutableSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var numOfVowels = 0
    val middle = size / 2
    for (i in 0..<size) {
        if (i < middle) {
            if (set.contains(s[i])) numOfVowels++
        } else {
            if (set.contains(s[i])) numOfVowels--
        }
    }

    return numOfVowels == 0
}


fun main() {
    println(halvesAreAlike("book"))
}