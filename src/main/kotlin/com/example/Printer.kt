package com.example

class Printer {
    var printMsg=""
    var count=0
    fun print(text: String){
        count++
        printMsg=text
    }
}
