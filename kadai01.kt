# mobile_takafumi
var Int = 2000

fun main() {
   println("Jugde leap year program")
   if(Int % 400 == 0){
       println("true")
   }else if(Int % 100 == 0){
       println("false")
   }else if(Int % 4 == 0){
       println("true")
   }else{
       println("false")
   }
   
}
