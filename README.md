# Kotlin入门学习

- 目的：了解了解Kotlin

---

- [官网云端ide |无需 登录、配置环境👍| (https://try.kotlinlang.org)](https://try.kotlinlang.org)
- [GitHub上的一个中文详细教程](https://github.com/JackChan1999/EasyKotlin)

---

### 一. Hello World *2023年9月22日*

```kotlin
fun main(array: Array<String>) {
    println("Hello Kotlin!")
}
```

- `fun`关键字表示定义一个函数
- `main`是函数名,这是一个Kotlin应用的入口点函数
- `(array: Array<String>)`定义了一个叫array的参数,类型是`Array<String>`,表示一个字符串数组
- `{ }`中的代码是main函数的函数体
- `println("Hello Kotlin!")`这一行调用了println函数,并传入了一个字符串参数"Hello Kotlin!"
- Kotlin中不需要以`;`号结尾

### 二. 变量 var / 常量 val / 类型判断 / 显式类型声明

#### 1.变量 var / 常量 val

```kotlin
fun main(args: Array<String>) {
    var name = "张三"
    println(name)
    name = "李四"
    println(name)
}
```

- 变量用`var`进行声明
- 不需要表明数据类型，但是也有相应的数据类型(和java类似) [java和kotlin数据类型的异同](#java和kotlin数据类型的异同)

#### 2.类型判断 / 显式类型声明

```kotlin
fun main(args: Array<String>) {
    /*类型判断 Type Inference*/
    var i = 18 //int类型
    //i = 99999999999 //超出int(2,147,483,647)的范围将会报错

    /*显式类型声明*/
    var j: Long = 99999999999

    //var a  //只声明不进行赋值会报错 因为kotlin不知道a是声明类型
    var a: String //显示类型声明就不会

    /*常量val*/
    val birthday = "2000-1-1"
}
```

- `var`声明变量
- `val`声明常量
- `kotlin`会自动判断数据类型
- 有显式声明的方式指定数据类型

### 三.函数入门

#### 1. 简单的函数Demo

一个打印菱形图案的main函数(main函数是入口函数)

```kotlin
fun main(args: Array<String>) {
    println("  *")
    println(" ***")
    println("*****")
    println(" ***")
    println("  *")
}
```

用方法将打印语句包装

```kotlin
fun main(args: Array<String>) {
    printOneStar()
    printThreeStar()
    printFiveStar()
    printThreeStar()
    printOneStar()
}

fun printOneStar() {
    println("  *")
}

fun printThreeStar() {
    println(" ***")
}

fun printFiveStar() {
    println("*****")
}
```

#### 2. 函数的格式

```kotlin
fun 函数名(参数名: 参数类型): 返回值类型 {
    函数体
}
```

- 使用`fun`关键字定义函数
- 参数格式为:参数名: 参数类型
- 函数返回值指定在函数定义末尾,可省略`Unit`返回类型(相当于java的`void`)
- 函数体使用花括号`{}`包裹
- 返回使用`return`关键字

用kotlin实现计算器

```kotlin
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
```

#### 3. 可变长参数函数 `vararg`

```kotlin
fun main(args: Array<String>) {
    println(sum(1, 2, 3, 4))
}

fun sum(vararg v: Int): Int {
    var sum = 0
    for (vt in v) {
        sum += vt
    }
    return sum
}
```

#### 4.lambda(匿名函数)

```kotlin
fun main(args: Array<String>) {
    val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
    println(sumLambda(1, 2))
}
```

### 四. 基本语法

#### 1. 字符串模板

- `$varName` 表示变量值
- `${varName.fun()}` 表示变量的方法返回值

```kotlin
fun main(args: Array<String>) {
    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"
    println(s1)

    a = 2
    // 模板中的任意表达式：
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
}
```

#### 2. NULL检查机制

在默认条件下，方法是无法传入null的，直接在语法层面杜绝了`NullPointerException` 👍

```kotlin
fun main(args: Array<String>) {
    println(heat("水")) // 输出 ‘热水’
    heat(null) //Kotlin: Null can not be a value of a non-null type String
}

fun heat(string: String): String {
    return "热$string"
}
```

如果要使用空的参数，声明可为空的参数，在使用时要进行空判断处理，有两种处理方式：

- `?` :不做处理返回值为 null 或`?:` 做空判断处理
- `!!` :像Java一样抛出空异常

```kotlin
//类型后面加?表示可为空
var age: String? = null
//抛出空指针异常
val ages = age!!.toInt()
//不做处理返回 null
val ages1 = age?.toInt()
//age为空返回-1
val ages2 = age?.toInt() ?: -1
```

例如:

```kotlin
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
```

`?`也可以用在返回值上：

```kotlin
fun main(args: Array<String>) {
    println(hot04("热水"))    //null
}

fun hot04(string: String): String? {
    return null
}
```

#### 3. 区间

Kotlin 中的区间（Ranges）是一个用来表示一系列值的概念。区间可以表示一组连续的数值、字符或其他可比较的元素。区间在许多情况下都很有用，例如循环、过滤和判断某个值是否在特定范围内等操作。

```kotlin
fun main(args: Array<String>) {
    print("循环输出：")
    for (i in 1..4) print(i) // 输出“1234”
    println("\n----------------")
    print("设置步长：")
    for (i in 1..4 step 2) print(i) // 输出“13”
    println("\n----------------")
    print("使用 downTo：")
    for (i in 4 downTo 1 step 2) print(i) // 输出“42”
    println("\n----------------")
    print("使用 until：")
    // 使用 until 函数排除结束元素
    for (i in 1 until 4) {   // i in [1, 4) 排除了 4
        print(i)
    }
}
```

- `..` ：操作符用于创建闭区间（Closed Range）。它包括指定的起始值和结束值。
- `step` ：用于定义区间中的步长，即两个相邻元素之间的差值。
- `downTo` ：用于创建递减的区间，通常与 `step` 一起使用。
- `until` ：用于创建半开区间（Half-Open Range），不包括结束值。



char的字符也有区间的用法
```kotlin
val a = 'a'..'z'
for (i in a) print(i) //abcdefghijklmnopqrstuvwxyz
```

---

### Java和Kotlin数据类型的异同

相同点:

- Kotlin保留了Java中的原始数据类型,如Int、Long、Double、Boolean等。
- Kotlin也有String表示字符串,数组Array,集合类型List、Set、Map等。
- Kotlin的Any类型对应Java的Object类型,作为统一的对象基类。

不同点:

- Kotlin使用Char表示字符,Java使用char。
- Kotlin有可空类型(Int?),Java中对应的是Integer。
- Kotlin使用Unit取代Java的void返回类型。
- Kotlin有数据类(data class)来简化对象的声明。
- Kotlin没有Java中包装类型的自动装箱拆箱。
- Kotlin有一些额外的便捷类型,如Pair。
- Kotlin类不编译成独立的.class文件,而是直接编译到Java字节码里。
- Kotlin在类型系统、空安全等方面简化和增强了Java的一些设计。

所以整体来说,Kotlin保留了Java中的许多设计,但也进行了一定的改进和增强,使其类型系统更简洁安全。