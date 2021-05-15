fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C = {a -> f(g(a))}

fun main(args: Array<String>) {
    val square = {a:Int -> a*a}
    val by10 = {a:Int -> a*10}
    println(by10(square(2)))

    val square_by10 = compose(by10,square)
    println(square_by10(2))
}