var water = 400
var milk = 200
var bean = 50
var cups = 4
var money = 100
const val PASSWORD = "qwerty"

fun main() {
    println("""
        Hello!
        What a beautiful day! 
        Maybe a cup of fragrant coffee? ;)
    """.trimIndent())

    while (true) {
        println("""
Select an action (click on the button):
1 - Buy a coffee drink
2 - Load stocks
3 - Information about stocks
4 - For the administrator
0 - Exit
""".trimIndent())
        val readLn = readln()
        if (readLn == "1") {
            buy()
        } else if (readLn == "2") {
            fill()
        } else if (readLn == "3") {
            informationAboutStocks()
        } else if (readLn == "4") {
            actionsForAdministrator()
        } else if (readLn == "0") {
            break
        } else {
            println("Missing action!")
        }
    }
    println("Have a good day! See you soon! ;)")
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
                3 - Cappuccino ($6)
            """.trimIndent())
        }
    }
}

fun machineForBuy(waterMinus: Int, milkMinus: Int, beanMinus: Int, cupMinus: Int, moneyPlus: Int) {

    if (water < waterMinus) {
        println("Sorry, not enough water!")
    } else if (milk < milkMinus) {
        println("Sorry, not enough milk!")
    } else if (bean < beanMinus) {
        println("Sorry, not enough beans!")
    } else if (cups < cupMinus) {
        println("Sorry, not enough cups!")
    } else {
        println("""
        Good choice!
        Starting the process.
    """.trimIndent())

        for (i in 0..100 step 10) {
            print("$i%...")
            Thread.sleep(500L)
        }
        println("""
            Ending the process.
            Done!
            
        """.trimIndent())

        water -= waterMinus
        milk -= milkMinus
        bean -= beanMinus
        cups -= cupMinus
        money += moneyPlus
    }
}

fun fill() {

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
    println("Done!")
}

fun machineForFill(waterPlus: Int, milkPlus: Int, beanPlus: Int, cupPlus: Int) {

    water += waterPlus
    milk += milkPlus
    bean += beanPlus
    cups += cupPlus
}

fun informationAboutStocks() {
    println("""
        The coffee machine has:
        $water ml of water
        $milk ml of milk
        $bean g of coffee beans
        $cups disposable cups

        """.trimIndent())
}

fun actionsForAdministrator() {
    while (true) {

        println("""
            To access, enter the password 
            (to access the main menu, press "0")
        """.trimIndent())

        val password = readln()

        if (password == PASSWORD) {
            println("""
        Access allowed!
        
        Proceeds: $$money
        
        """.trimIndent())

            while (true) {
                println("""
                Do you want to take the money?
                Select an action (click on the button):
                1 - Take the money
                2 - Exit
            """.trimIndent())

                when (readln()) {
                    "1" -> {
                        if (money <= 0){
                            println("""
                                I'm not a bank. I do not issue a loan. There is no money. But you hold on!
                            """.trimIndent())
                        } else{
                            money -= money
                            println("Done!")
                        }
                        break
                    }
                    "2" -> break
                    else -> {
                        println("Missing action!")
                        continue
                    }
                }
            }
        } else if (password == "0") {
            break
        } else {
            println("Access denied!")
            continue
        }
        break
    }
}