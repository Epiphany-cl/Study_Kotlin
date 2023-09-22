fun main(args: Array<String>) {
    /*类型判断 Type Inference*/
    var i = 18 //int类型
    //i = 99999999999 //超出int(2,147,483,647)的范围将会报错

    /*显示类型声明*/
    var j: Long = 99999999999

    //var a  //只声明不进行赋值会报错 因为kotlin不知道a是声明类型
    var a: String //显示类型声明就不会

    /*常量val*/
    val birthday = "2000-1-1"
}