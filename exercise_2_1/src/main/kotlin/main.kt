fun fib(n: Int): Int {
    tailrec fun loop(a: Int, b: Int, i: Int): Int = if (i==n) a else loop(b, a+b, i+1)

    return loop(0, 1, 0)
}

fun main(args: Array<String>) {
    println(fib(0))
    println(fib(1))
    println(fib(2))
    println(fib(3))
    println(fib(4))
    println(fib(5))
    println(fib(6))
}