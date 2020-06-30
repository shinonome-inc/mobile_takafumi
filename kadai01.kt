# mobile_takafumi
var numInt = 2000

fun main() {
   println("Jugde leap year program")
   if(numInt % 400 == 0){
       println("true")
   }else if(numInt % 100 == 0){
       println("false")
   }else if(numInt % 4 == 0){
       println("true")
   }else{
       println("false")
   }
   
}
