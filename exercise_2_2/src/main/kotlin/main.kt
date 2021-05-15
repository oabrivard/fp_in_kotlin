val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
    tailrec fun loop(x: A, xs: List<A>, isSorted: Boolean) : Boolean =
        if (xs.isEmpty() || !isSorted)
            isSorted
        else
            loop(xs.head, xs.tail, isSorted && order(x, xs.head))


    return if (aa.size < 2) true else loop(aa.head, aa.tail, true)
}

fun main(args: Array<String>) {
    println(isSorted(listOf()) { a: Char, b: Char -> a <= b })
    println(isSorted(listOf('a')) { a, b -> a <= b })
    println(isSorted(listOf('a', 'b', 'c')) { a, b -> a <= b })
    println(isSorted(listOf('a', 'b', 'b')) { a, b -> a <= b })
    println(isSorted(listOf('a', 'c', 'b')) { a, b -> a <= b })
}