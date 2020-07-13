enum class Hand{
    Gu,
    Ti,
    Pa,
}

enum class Result{
    Win,
    Lose,
    Draw,
}

fun janken(x:Int) {

    val r = (0..2).random()

    if(r == 0){
        println("相手の手は${Hand.Gu}")
    }else if(r == 1) {
        println("相手の手は${Hand.Ti}")
    }else {
        println("相手の手は${Hand.Pa}")
    }

    if(r == 0 && x == 0 || r == 1 && x == 1 || r ==2 && x == 2) {
        println(Result.Draw)
    }else if(r == 0 && x == 2 || r == 1 && x == 0 || r ==2 && x == 1){
    println(Result.Win)
    }else if(r == 0 && x == 1 || r == 1 && x == 2 || r ==2 && x == 0){
        println(Result.Lose)
    } else {
        println("正しく入力してください")
    }
}


fun main() {
    println("ジャンケンプログラム")

    print("あなたの出す手を入力してください(グーは０、チョキは１、パーは２）：")

    val x = readLine()?.toInt()

    janken(x ?. toInt()!!)

}