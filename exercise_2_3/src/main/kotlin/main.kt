fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C = {a -> {b -> f(a,b)}}

fun main(args: Array<String>) {
    val add = {a:Int, b:Int -> a+b}

    val addPart = curry(add)

    val addPart2 = addPart(2)

    val total = addPart2(10)

    println(total)
}