package au.edu.swin.sdmd.myapp
import java.util.*

fun main(args: Array<String>) {
//    val a = println("This is an expression")
//    println(a)
//    val temp = 10
//    val msg = "The water temp is ${if (temp > 50) "warm" else "cold"}"
//    println(msg)
    feedTheFish()
}

fun feedTheFish() {
    val day = selectDay()
    val foods = arrayOf("vegetable", "flakes")
    val food = foods[Random().nextInt(foods.size)]
    println("Today the fish eat ${food} and it is ${day}")
}

fun selectDay() : String {
    val listOfDays = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return listOfDays[Random().nextInt(listOfDays.size)]
}
