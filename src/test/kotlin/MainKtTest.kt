import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun machineForBuy() {
        val water = 400
        val milk = 340
        val bean = 20
        val cups = 4

        val expected = machineForBuy(350, 340, 20, 4, 6)

        val result = machineForBuy(
            waterMinus = water,
            milkMinus = milk,
            beanMinus = bean,
            cupMinus = cups,
            moneyPlus = 0
        )
        assertEquals(expected, result)
    }

    @Test
    fun machineForFill() {
        val water = 100
        val milk = 160
        val bean = 80
        val cups = 1

        val expected = machineForFill(100, 160, 80, 1)

        val result = machineForFill(
            waterPlus = water,
            milkPlus = milk,
            beanPlus = bean,
            cupPlus = cups
        )
        assertEquals(expected, result)
    }
}