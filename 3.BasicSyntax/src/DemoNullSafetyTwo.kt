fun main(args: Array<String>) {
    println(hot01(null))    //热null
    println(hot02(null))    //热水
    println(hot03(null))    //java.lang.NullPointerException
}

fun hot01(string: String?): String {
    return "热$string"
}

fun hot02(string: String?): String {
    return "热${string ?: "水"}"
}

fun hot03(string: String?): String {
    return "热${string!!}"
}


