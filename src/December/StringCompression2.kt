package December

fun main() {
    getLengthOfOptimalCompression("aabbaa", 2)
}

fun getLengthOfOptimalCompression(s: String, k: Int): Int {
    val encoded = StringBuilder()
    var currChar = s[0]
    var currLength = 0
    for(c in s) {
        if (currChar == c) {
            currLength++
        } else {
            encoded.append(currChar)
            if (currLength > 1) {
                encoded.append(currLength)
            }
            currLength = 1
            currChar = c
        }
    }

    encoded.append(currChar)
    if (currLength > 1) {
        encoded.append(currLength)
    }

    var encodedString = encoded.toString()
    encoded.clear()

    var i = 0
    var k1 = k
    while (i<encodedString.length && k1 > 0) {
        if((i+1<encodedString.length) && encodedString[i+1].isDigit()) {
            currChar = encodedString[i]
            val numSb = StringBuilder()
            i++
            while (i<encodedString.length && encodedString[i].isDigit()) {
                numSb.append(encodedString[i])
                i++
            }
            val num = numSb.toString().toInt()
            if ((num <= k1 && num <= 2).not()) {
                encoded.append(currChar)
                encoded.append(numSb.toString())
            } else {
                k1 -= (numSb.length+1)
            }
        } else {
            i++
            k1--
        }
    }
    encodedString = encoded.toString()
    println(encodedString)
    encoded.clear()
    println(k1)
    i = 0
    while (i<encodedString.length && k1 > 0) {
        if((i+1<encodedString.length) && encodedString[i+1].isDigit()) {
            currChar = encodedString[i]
            val numSb = StringBuilder()
            i++
            while (i<encodedString.length && encodedString[i].isDigit()) {
                numSb.append(encodedString[i])
                i++
            }
            val num = numSb.toString().toInt()
            if ((num <= k1).not()) {
                val numLength = numSb.length
                val newLength = (num - k1).toString().length
                if (newLength<numLength) {
                    encoded.append(currChar)
                    encoded.append((num - k1).toString())
                    k1 = 0
                }
            } else {
                k1 -= (numSb.length+1)
            }
        } else {
            i++
            k1--
        }
    }
    encodedString = if (encoded.isNotEmpty()) encoded.toString() else encodedString
    return encodedString.length
}