package demo

sealed class Demo01
class Demo02
class SubDemo03:Demo01()
class Port(var value:Int = 22, var securied:Boolean = false) {
    operator fun invoke(λ: Port.() -> Unit) {

    }
}

class Configuration(var host:String="", var port:Port=Port()) {
    operator fun invoke(λ:Configuration.()->Unit) {

    }
}

fun main() {

    val config = Configuration()

    config{
        host="127.0.0.1"
        port{
            value = 443
            securied = true
        }
    }

}