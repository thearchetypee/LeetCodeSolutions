fun main(){
    println(numJewelsInStones("z", "ZZ"))
}

fun numJewelsInStones(jewels: String, stones: String): Int {
    val hashLetters : MutableList<Int> = MutableList(58){0}

    val base = 'A'.toInt()

    var result = 0

    for(i in jewels){
        hashLetters[i.toInt()-base] +=1
    }

    for (i in stones){
        if (hashLetters[i.toInt()-base] > 0){
            result++
        }
    }
    return result
}