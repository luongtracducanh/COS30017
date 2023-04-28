package au.edu.swin.sdmd.w03_calculations

import java.io.File

fun main() {
    val list = mutableListOf<Word>()
    File("C:\\Users\\Pro\\Documents\\Swinburne\\COS30017\\w09persistence-103488117\\app\\src\\main\\java\\au\\edu\\swin\\sdmd\\w03_calculations\\input.txt")
        .forEachLine {
            val temp = it.split(",")
            list.add(Word(temp[0], temp[1].toInt()))
        }

    list.forEach {
        println(it.word)
    }
    list.forEach {
        println(it.num)
    }
}

data class Word(val word: String, val num: Int)