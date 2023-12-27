package Arrays

fun main(){
 print(generate(1))
}

fun generate(numRows: Int): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    ans.add(listOf(1))
    for (i in 1 until numRows){
        val sublist = mutableListOf<Int>()
        val prevList = ans[i-1]
        for (j in 0..i){
            val item = when {
                j-1<0 -> {
                    1
                }
                j == i -> {
                    1
                }
                else -> {
                    prevList[j-1]+prevList[j]
                }
            }
            sublist.add(item)
        }

        ans.add(sublist)
    }
    return ans
}