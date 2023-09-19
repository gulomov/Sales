package com.myproject.data

class TestClass {
    fun test() {
        val x = 7
        val y = 6
        if (x in 1..y + 1) {
            println("fits in range")
        }
    }
}
