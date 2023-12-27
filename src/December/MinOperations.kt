package December

import kotlin.math.min

fun main() {
    println(minOperations("10010100"))
}

fun minOperations(s: String): Int {
    var currCharWithOne = '1'
    var currCharWithZero = '0'
    var currOpWithOne = 0
    var currOpWithZero = 0
    for (c in s) {
        if (currCharWithOne != c) {
            currOpWithOne++
        }
        if (currCharWithZero != c) {
            currOpWithZero++
        }
        currCharWithOne = if (currCharWithOne == '1') '0' else '1'
        currCharWithZero = if (currCharWithZero == '1') '0' else '1'
    }
    return min(currOpWithZero, currOpWithOne)
}