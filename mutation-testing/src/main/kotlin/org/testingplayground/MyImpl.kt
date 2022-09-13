package org.testingplayground

class MyImpl {
    fun doSomething(a: Int, b: Int): String {
        if (a < 0 || b < 0) {
            return "Either A or B are negative"
        }
        if (a == 0 && b == 0) {
            return "Both A and B are zero"
        }
        if (a > b) {
            return "A is greater than B"
        }
        return if (b > a) {
            "B is greater than A"
        } else "A and B are equal"
    }
}