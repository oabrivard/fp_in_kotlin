fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C = {a,b -> f(a)(b)}

fun main(args: Array<String>) {
    val add = {a:Int -> {b:Int -> a+b}}
    println(add(2)(10))

    val addUncurried = uncurry(add)
    println(addUncurried(2,10))
}