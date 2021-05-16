import org.junit.Test

import org.junit.Assert.*

class Chapter3Test {

    @Test
    fun tail() {
        val l1 = List.of(1,2,3,4)
        val l2 = l1.tail()

        assertEquals(l2, List.of(2,3,4))
    }

    @Test
    fun setHead() {
        val l1 = List.of(2,3,4)
        val l2 = l1.setHead(1)

        assertEquals(l2, List.of(1,2,3,4))
    }

    @Test
    fun drop() {
        val l1 = List.of(1,2,3,4)
        val l2 = l1.drop(2)
        assertEquals(l2, List.of(3,4))
        assertEquals(l1.drop(0), List.of(1,2,3,4))
        assertEquals(Nil.drop(0), Nil)
    }

    @Test
    fun dropWhile() {
        val l1 = List.of(1,2,3,4)
        val l2 = l1.dropWhile({it < 3})
        assertEquals(l2, List.of(3,4))
        assertEquals(l1.dropWhile({it < 5}), Nil)
        assertEquals(l1.dropWhile({it < 0}), l1)
    }

    @Test
    fun init() {
        val l1 = List.of(1,2,3,4)
        val l2 = l1.init()

        assertEquals(l2, List.of(1,2,3))
    }
}