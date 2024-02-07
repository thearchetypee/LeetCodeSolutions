package January24

/**
 *  1. Create a mutable map to store anagrams as key-value pairs. The keys will be
 *      sorted strings (anagrams will have the same sorted string), and the values
 *      will be lists of original strings that are anagrams of each other.
 *
 *  2. Iterate through the input array strs using a for loop.
 *
 *  3. For each string s in strs, create a sorted version of the string.
 *      This is done by converting the string to a character array, sorting
 *      it in ascending order, and then joining the sorted characters back
 *      into a string. This ensures that anagrams will have the same sorted string.
 *
 *  4. Check if the map already contains the sorted string as a key. If it does, add
 *      the original string s to the corresponding list of anagrams. If not, create a
 *       new entry in the map with the sorted string as the key and a new list containing
 *       s as the value.
 *
 *  5. After processing all strings in strs, create an empty list ans to store the final result.
 *
 *  6. Iterate through the entries in the map. For each entry, add the list of anagrams (the value)
 *      to the ans list.
 *
 *  7. Finally, return the ans list, which contains grouped anagrams.
 */
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val map = mutableMapOf<String, MutableList<String>>()
    for(s in strs) {
        val sortedString = s.toCharArray().apply { sort() }.joinToString("")
        if (map.containsKey(sortedString)) {
            map[sortedString]?.add(s)
        } else {
            map[sortedString] = mutableListOf(s)
        }
    }

    val ans = mutableListOf<List<String>>()
    for ((key, value) in map) {
        ans.add(value)
    }

    return ans
}

fun main() {
    val arr = arrayOf("eat","tea","tan","ate","nat","bat")
    val ans = groupAnagrams(arr)

    println(ans)
}