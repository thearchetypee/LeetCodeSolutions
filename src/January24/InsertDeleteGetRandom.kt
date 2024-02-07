package January24



private val set = mutableSetOf<Int>()

/**
 * Inserts a value into the set.
 *
 * @param value The value to insert.
 * @return true if the value was not present and successfully inserted, false otherwise.
 */
fun insert(`val`: Int): Boolean {
    val present = set.contains(`val`)
    set.add(`val`)
    return !present
}

/**
 * Removes a value from the set.
 *
 * @param value The value to remove.
 * @return true if the value was present and successfully removed, false otherwise.
 */
fun remove(`val`: Int): Boolean {
    val present = set.contains(`val`)
    if (present) set.remove(`val`)
    return present
}

/**
 * Returns a random element from the set.
 *
 * @return A randomly selected element from the set.
 */
fun getRandom(): Int {
    return set.random()
}