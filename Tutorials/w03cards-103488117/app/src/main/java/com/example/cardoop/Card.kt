package com.example.cardoop

class Card(val rank: String, val suit: String, var faceUp: Boolean = true) {
    fun flip() {
        faceUp = !faceUp
    }

    fun printDetails(): String {
        if (faceUp) {
            return "$rank $suit"
        } else {
            return "------"
        }
    }

    fun getDetails(): String {
        if (faceUp) {
            return "$rank $suit"
        } else {
            return "------"
        }
    }
}