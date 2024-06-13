package org.example

import java.io.File
import java.util.*

//def codes_with_routes(codes):
//"""
//    returns the routes for the given codes, specified in routes.dat
//    :param codes: the codes for which routes should be extracted
//    :return: set of codes with
//    """
//route_codes = set([])
//for line in open("routes.dat", encoding='utf-8'):
//split = line.split(",")
//fr = split[2].strip("\"")
//to = split[4].strip("\"")
//if fr in codes and to in codes:
//route_codes.add(fr)
//route_codes.add(to)
//return route_codes

fun codes_with_routes(codes:Any):Any{
    val route_codes = TreeSet<String>()
    File("routes.dat").readLines().forEach{line ->
        val split = line.split(",")
        route_codes.add(split[2].replace("\"",""))
        route_codes.add(split[4].replace("\"",""))
    }
    println(route_codes)
    return route_codes
}

//def codes_with_airport_info():
//"""
//    parse all codes from airports.dat that have all required airport information
//
//    :return: set of codes with complete airport information
//    """
//codes = set([])
//for line in open("airports.dat", encoding='utf-8'):
//split = line.split(",")
//if len(split) == 12:
//code = split[4].strip("\"")
//city = split[2].strip("\"")
//country = split[3].strip("\"")
//x = float(split[6])
//y = float(split[7])
//if city and country and x and y:
//codes.add(code)
//return codes
fun codes_with_airport_info(){
    val codes = TreeSet<Any>()
    File("airports.dat").readLines().map{line->
        val split = line.split(",")
        if(split.size==12){
            val code = split[4].replace("\"","")
            val city = split[2].replace("\"","")
            val country = split[3].replace("\"","")
            val x = split[6]
            val y = split[7]
            if(city.isNotBlank() && country.isNotBlank() && x.isNotBlank() && y.isNotBlank()) codes.add(code)

        }
    }
    println(codes)
}


fun main(){
//    val f = File("for_test.txt")
//    f.createNewFile()
//    f.writeText(" \"  \"dsj\"  \nghfgh")
//    val arr = arrayOf("\""," ","\n")
//    val a =File("for_test.txt").readLines().map {
//        it.replace("\n","").replace(" ","").replace("\"","")
//    }
//    val st = "abc"
//    val re = st.replace("b", "")
//    println(st)
    codes_with_routes(codes_with_airport_info())
    

}
