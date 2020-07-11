enum class enumhand{
    Gu,
    Ti,
    Pa,
}

enum class enumresult{
    Win,
    Lose,
    Draw
}

fun janken () {

    var x = readLine()?.toInt()

    var r = (0..2).random()

    if(r == 0){
        print("相手の手は")
        println(enumhand.Gu)
    }else if(r == 1) {
        print("相手の手は")
        println(enumhand.Ti)
    }else {
        print("相手の手は")
        println(enumhand.Pa)
    }

    if(r == 0 && x == 0 || r == 1 && x == 1 || r ==2 && x == 2) {
        println(enumresult.Draw)
    }else if(r == 0 && x == 2 || r == 1 && x == 0 || r ==2 && x == 1){
    println(enumresult.Win)
    }else if(r == 0 && x == 1 || r == 1 && x == 2 || r ==2 && x == 0){
        println(enumresult.Lose)
    } else {
        println("正しく入力してください")
    }

}


fun main() {
    println("ジャンケンプログラム")

    print("あなたの出す手を入力してください(グーは０、チョキは１、パーは２）：")

    janken()

}
