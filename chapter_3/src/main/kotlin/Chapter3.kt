sealed class List<out A> {

    companion object {
        fun <A> of(vararg aa: A): List<A> {
            val tail = aa.sliceArray(1 until aa.size)
            return if (aa.isEmpty()) Nil else Cons(aa[0], of(*tail))
        }

        fun sum(ints: List<Int>): Int =
            when (ints) {
                is Nil -> 0
                is Cons -> ints.head + sum(ints.tail)
            }

        fun product(doubles: List<Double>): Double =
            when (doubles) {
                is Nil -> 1.0
                is Cons -> if (doubles.head == 0.0) 0.0 else doubles.head * product(doubles.tail)
            }

        fun <A> append(a1: List<A>, a2: List<A>): List<A> =
            when (a1) {
                is Nil -> a2
                is Cons -> Cons(a1.head, append(a1.tail, a2))
            }
    }
}

object Nil : List<Nothing>() {
    override fun toString(): String = "Nil"
}

data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()

fun <A> List<A>.tail(): List<A> =
    when(this) {
        is Nil -> Nil
        is Cons -> this.tail
    }

fun <A> List<A>.setHead(x: A): List<A> = Cons(x, this)

fun <A> List<A>.drop(n: Int): List<A> {
    tailrec fun loop(xs : List<A>, i: Int): List<A> = if (i==0) xs else loop(xs.tail(), i-1)

    return loop(this, n)
}

fun <A> List<A>.dropWhile(f: (A) -> Boolean): List<A> {
    tailrec fun loop(xs : List<A>): List<A> =
        when(xs) {
            is Nil -> Nil
            is Cons -> if (!f(xs.head)) xs else loop(xs.tail)
        }

    return loop(this)
}

fun <A> List<A>.init(): List<A> {
    tailrec fun loop(xs: List<A>, acc: List<A>) : List<A> =
        when(xs) {
            is Nil -> Nil
            is Cons -> if (xs.tail==Nil) acc else loop(xs.tail, List.append(acc, List.of(xs.head)))
        }

    return loop(this, Nil)
}

fun main(args: Array<String>) {
    println("Hello World!")
}