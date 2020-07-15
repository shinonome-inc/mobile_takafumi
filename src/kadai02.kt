enum class Hand(val id :Int){
    Gu(0),
    Ti(1),
    Pa(2),
}

enum class Result{
    Win,
    Lose,
    Draw,
}

fun janken(x: Hand) {

    val r = (0..2).random()

    when(r) {
        0 -> {
            println("相手の手は${Hand.Gu}")
        }
        1 -> {
            println("相手の手は${Hand.Ti}")
        }
        2 -> {
            println("相手の手は${Hand.Pa}")
        }
    }

    if(r.equals(0)  && x.equals(Hand.Gu) || r.equals(1) && x.equals(Hand.Ti) || r.equals(2) && x.equals(Hand.Pa)) {
        println(Result.Draw)
    }else if(r.equals(0) && x.equals(Hand.Pa) || r.equals(1) && x.equals(Hand.Gu) || r.equals(2) && x.equals(Hand.Ti)){
        println(Result.Win)
    }else if(r.equals(0) && x.equals(Hand.Ti) || r.equals(1) && x.equals(Hand.Pa) || r.equals(2) && x.equals(Hand.Gu)){
        println(Result.Lose)
    } else {
        println("正しく入力してください")
    }
}

fun main() {
    println("ジャンケンプログラム")

    print("あなたの出す手を入力してください(グーは０、チョキは１、パーは２）：")

    var x = readLine()?.toInt()
    var y:Hand = Hand.Gu

    if(x == 1){
        y = Hand.Ti

    }else if(x == 2) {
        y = Hand.Pa
    }

    janken(y)

}