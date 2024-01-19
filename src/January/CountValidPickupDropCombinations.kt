package January

fun countOrders(n: Int): Int {
    var prev: Long = 1
    for (i in 1..n) {
        prev = (prev * ((2 * i - 1) * i)) % 1000000007
    }
    return prev.toInt()
}

fun main() {
    println(countOrders(2))
}