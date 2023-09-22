fun main(args: Array<String>) {
   println(sum(1,2,3,4))
}

fun sum(vararg v:Int):Int{
    var sum = 0
    for(vt in v){
        sum += vt
    }
    return sum
}