package Arrays

import java.util.Stack

fun main() {

}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (i in s.indices) {
        if (stack.isNotEmpty()) {
            if ((s[i] == ')' && stack.peek() =='(') || (s[i] == ']' && stack.peek() =='[') || (s[i] == '}' && stack.peek() =='{') ) {
                stack.pop()
            } else {
                stack.add(s[i])
            }
        } else {
          stack.add(s[i])
        }
    }

    return stack.isEmpty()
}