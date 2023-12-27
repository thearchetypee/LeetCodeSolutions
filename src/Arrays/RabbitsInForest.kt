fun main(){

}

fun numRabbits(answers: IntArray): Int {
    val numberOfRabbitsSet: MutableSet<Int> = mutableSetOf()

    for (i in answers) {
        numberOfRabbitsSet.add(i + 1)
    }

    return numberOfRabbitsSet.sum()
}