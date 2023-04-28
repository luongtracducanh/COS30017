package au.edu.swin.sdmd.myapp

class Card(_rank: String, _suit: String) {
    private var rank: String = ""
    private var suit: String = ""
    private var faceUp: Boolean = true

    fun printCardDetails() {
        if (faceUp) {
            println("$rank $suit")
        }
        else {
            println("------")
        }
    }

    fun flipCard() {
        faceUp = !faceUp
    }

    init {
        rank = _rank
        suit = _suit
        faceUp = true
    }
}
