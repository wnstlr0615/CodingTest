package pratice.sort

import java.util.TreeMap

fun main(){
    val N = readln().toInt()
    val treeMap = TreeMap<String, Int>()
    repeat(N){
        val str = readln()
        val ext = str.substring(str.lastIndexOf(".") + 1)
        if(!treeMap.containsKey(ext)){
            treeMap[ext] = 1
        }else{
            treeMap[ext] = treeMap[ext]!! + 1
        }
    }
    for(key in treeMap.keys){
        println("$key ${treeMap[key]}")
    }
}