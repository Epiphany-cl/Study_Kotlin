fun main(args: Array<String>) {
    println(heat("水")) // 输出 ‘热水’
    //heat(null) //Kotlin: Null can not be a value of a non-null type String

    //类型后面加?表示可为空
    var age: String? = null
    //抛出空指针异常
    val ages = age!!.toInt()
    //不做处理返回 null
    val ages1 = age?.toInt()
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1

}

fun heat(string: String): String {
    return "热$string"
}
