# Kotlin入门学习

- 目的：了解了解Kotlin

---

- [官网云端ide |无需 登录、配置环境👍| (https://try.kotlinlang.org)](https://try.kotlinlang.org)
- [GitHub的一个中文详细教程](https://github.com/JackChan1999/EasyKotlin)

---

### 1. Hello World *2023年9月22日*

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

### 2. 变量 var

```kotlin
fun main(args: Array<String>) {
    var name = "张三"
    println(name)
    name = "李四"
    println(name)
}
```

- 变量用`var`进行声明
- 不需要表明数据类型，但是也有相应的数据类型(和java类似)
- [java和kotlin数据类型的异同](#java和kotlin数据类型的异同)





---
### Java和Kotlin数据类型的异同

相同点:

- Kotlin保留了Java中的原始数据类型,如Int、Long、Double、Boolean等。
- Kotlin也有String表示字符串,数组Array,集合类型List、Set、Map等。
- Kotlin的Any类型对应Java的Object类型,作为统一的对象基类。

不同点:

- Kotlin没有Java中类似byte、short这样的整数类型。
- Kotlin使用Char表示字符,Java使用char。
- Kotlin有可空类型(Int?),Java中对应的是Integer。
- Kotlin使用Unit取代Java的void返回类型。
- Kotlin有数据类(data class)来简化对象的声明。
- Kotlin没有Java中包装类型的自动装箱拆箱。
- Kotlin有一些额外的便捷类型,如Pair。
- Kotlin类不编译成独立的.class文件,而是直接编译到Java字节码里。
- Kotlin在类型系统、空安全等方面简化和增强了Java的一些设计。

所以整体来说,Kotlin保留了Java中的许多设计,但也进行了一定的改进和增强,使其类型系统更简洁安全。