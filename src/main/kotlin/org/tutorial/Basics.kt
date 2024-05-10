package org.tutorial

import java.lang.Exception

class Basics {
}

var num: Int = 20   // Inferred type Int
var fl = 3.0    // type set when variable initialized
// var keywords can be reassigned
val a = 5   // val cannot be reassigned


fun main(args: Array<String>) {
    println("Hello World: $num $fl")
    val b: Int  // Property must be initialized before first use (deffered assignment)
    val d = 3.14f
    val n = 8L
    val h = 0xff
    val bin = 0b1010
    val t = true
    val ch = '\t'

    val array = intArrayOf(1,2,3,4,5) // val arr = Array(5)
    val arr2 = arrayOf<String>("Kevin", "Jones")
    println("Name is $arr2[0] $arr2[1]")    // interpolates strings


    for (a: String in args) {
        println(a)
    }
    var value = sum(10, 20)
    println(value)
    doNothing()
}

fun sum(a: Int, b: Int): Int {
    return a + b;
}

// Unit replaces void
fun doNothing(): Unit {
    println("doNothing()")
}

fun ifExpressions() {
    // If Expressions
    val a = 2
    val b = 3
    val min = a < b ? a : b         // Kotlin does not support Ternary operator
    val min2 = if (a < b) a else b  // Valid, if not a statement, its an expression, it returns a value
    val min3 = if (a < b) {
        a
    } else {
        b
    }
}

fun exceptions() {
    // All exceptions in Kotlin are Unchecked
    try {
        throwException()
    } catch (e: Throwable) {

    }

    val nums = arrayOf(1)
    var ans = 0
    try {
        ans = nums[1]
    } catch (e: Throwable) {
        0
    }
    println("$ans")
}

fun throwException() { // Java forces us to use: throws Exception
    throw Exception("Hello exception")
}