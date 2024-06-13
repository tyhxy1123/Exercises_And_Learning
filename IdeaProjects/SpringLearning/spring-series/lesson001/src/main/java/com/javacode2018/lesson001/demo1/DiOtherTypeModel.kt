package com.javacode2018.lesson001.demo1

import java.util.*

class DiOtherTypeModel {
    var list1: List<String> = LinkedList()
    var set1: Set<String> = HashSet()
    var map1: Map<String, Int> = TreeMap()
    var array1: Array<Int> = Array(1) { 0 }
    var properties1: Properties = Properties()

    constructor(list1: List<String>, set1: Set<String>, map1: Map<String, Int>, array1: Array<Int>, properties1: Properties) {
        this.list1 = list1
        this.set1 = set1
        this.map1 = map1
        this.array1 = array1
        this.properties1 = properties1
    }

    constructor()

    override fun toString(): String {
        return "DiOtherTypeModel(list1=$list1, set1=$set1, map1=$map1, array1=${array1.contentToString()}, properties1=$properties1)"
    }

}