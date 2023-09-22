fun main(args: Array<String>) {
    val a = 1
    val b = 2

    println("a = $a | b = $b")
    println("a + b = " + add(a, b))
    println("a - b = " + subtract(a, b))
    println("a * b = " + multiply(a, b))
    println("a / b = " + divide(a, b))
}

//add, subtract, multiply and divide
fun add(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}

fun multiply(a: Int, b: Int): Int {
    return a * b
}

fun divide(a: Int, b: Int): Int {
    return a / b
}

