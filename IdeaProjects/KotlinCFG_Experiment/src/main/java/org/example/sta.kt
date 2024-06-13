package org.example

import kotlin.math.log2

fun main() {
    val pi:Double = 300.0.div(400)
    val pi2:Double = 100.0.div(400)
    println(-pi*log2(pi)-pi2*log2(pi2))
}