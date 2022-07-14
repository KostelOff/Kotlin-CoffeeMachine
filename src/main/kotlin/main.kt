const val WATER = 900
const val MILK = 840
const val BEAN = 420
const val CUPS = 9
const val MONEY = 550
const val PASSWORD = "qwerty"

fun main() {

    println("""
Hello!
Select an action:
1 - Buy a coffee drink
2 - Load stocks
3 - Collect the proceeds
4 - Information about ingredients
""".trimIndent())

    while (true) {
        val readLn = readln()
        if (readLn == "1") {
            buy()
            break
        } else if (readLn == "2") {
            fill()
            break
        } else if (readLn == "3") {
            take()
            break
        } else if (readLn == "4") {

            information()
            continue
        } else {
            println("""
                Missing action!
                Select an action:
                1 - Buy a coffee drink
                2 - Load stocks
                3 - Collect the proceeds
                4 - Information about ingredients
            """.trimIndent())
            continue
        }
    }
}

fun machineForBuy(waterMinus: Int, milkMinus: Int, beanMinus: Int, cupMinus: Int, moneyPlus: Int) {

    val water = WATER - waterMinus
    val milk = MILK - milkMinus
    val bean = BEAN - beanMinus
    val cups = CUPS - cupMinus
    MONEY + moneyPlus
    println("""
        Good choice!
        Starting the process.
    """.trimIndent())

    for (i in 0..100 step 10) {
        print("$i%...")
        Thread.sleep(500L)
    }
    println("Ending the process.")
    println("""    
        Done!
        Have a good day! =)
        
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $bean g of coffee beans
        $cups disposable cups
    """.trimIndent())
}

fun machineForFill(waterPlus: Int, milkPlus: Int, beanPlus: Int, cupPlus: Int) {

    val water = WATER + waterPlus
    val milk = MILK + milkPlus
    val bean = BEAN + beanPlus
    val cups = CUPS + cupPlus
    MONEY
    println("""
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $bean g of coffee beans
        $cups disposable cups
        Have a good day!
    """.trimIndent())
}

fun buy() {
    while (true) {

        println("""
What do you want to buy?
Select an action:
1 - Espresso ($4)
2 - Latte ($7)
3 - Cappuccino ($6)
""".trimIndent())

        val readLn = readln()
        if (readLn == "1") {
            machineForBuy(250, 0, 16, 1, 4)
            break
        } else if (readLn == "2") {
            machineForBuy(350, 75, 20, 1, 7)
            break
        } else if (readLn == "3") {
            machineForBuy(200, 100, 12, 1, 6)
            break
        } else {
            println("""
                Missing action!
                Select an action:
                1 - Espresso ($4)
                2 - Latte ($7)
                3 - CCappuccino ($6)
            """.trimIndent())
            continue
        }
    }
}

fun fill() {
    println("""
        Now the coffee machine has:
        $WATER of water
        $MILK ml of milk
        $BEAN g of coffee beans
        $CUPS disposable cups
    """.trimIndent())

    println("Write how many ml of water do you want to add:")
    val waterAdd = try {
        readln().toInt()
    } catch (e: Exception) {
        println("""
            Attention! Enter numeric data!
            Write how many ml of water do you want to add:
        """.trimIndent())
        readln().toInt()
    }

    println("Write how many ml of milk do you want to add:")
    val milkAdd = try {
        readln().toInt()
    } catch (e: Exception) {
        println("""
            Attention! Enter numeric data!
            Write how many ml of milk do you want to add:
        """.trimIndent())
        readln().toInt()
    }

    println("Write how many grams of coffee beans do you want to add:")

    val beansAdd = try {
        readln().toInt()
    } catch (e: Exception) {
        println("""
            Attention! Enter numeric data!
            Write how many grams of coffee beans do you want to add:
        """.trimIndent())
        readln().toInt()
    }

    println("Write how many disposable cups of coffee do you want to add:")
    val cupsAdd = try {
        readln().toInt()
    } catch (e: Exception) {
        println("""
            Attention! Enter numeric data!
            Write how many disposable cups of coffee do you want to add:
        """.trimIndent())
        readln().toInt()
    }
    machineForFill(waterAdd, milkAdd, beansAdd, cupsAdd)
}

fun take() {
    println("""
        To get access to cash, enter the password:
        (to exit, enter "0")
    """.trimIndent())

    while (true) {
        val password = readln()
        if (password == PASSWORD) {
            println("""
        Access allowed!
        
        Proceeds: $$MONEY
        The coffee machine has:
        $WATER of water
        $MILK ml of milk
        $BEAN g of coffee beans
        $CUPS disposable cups
        $${0} of money
        """.trimIndent())
            break
        } else if (password == "0") {
            break
        } else {
            println("""
        Access denied!!!
        To get access to cash, enter the password:
        (to exit, enter "0")
    """.trimIndent())
            continue
        }
    }
    println("Have a good day!")
}

fun information() {
    println("""
        The coffee machine has:
        $WATER of water
        $MILK ml of milk
        $BEAN g of coffee beans
        $CUPS disposable cups
        $$MONEY of money
        
        Select an action:
        1 - Buy a coffee drink
        2 - Load stocks
        3 - Collect the proceeds
        4 - Information about ingredients
        """.trimIndent())
}
