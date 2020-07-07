fun numInt(a:Int):Int {
    if (a % 400 == 0) {
        println("true")
    } else if (a % 100 == 0) {
        println("false")
    } else if (a % 4 == 0) {
        println("true")
    } else {
        println("false")
    }
    return a
}

fun main() {
    println("閏年判定プログラム")

    numInt(3000)
}

