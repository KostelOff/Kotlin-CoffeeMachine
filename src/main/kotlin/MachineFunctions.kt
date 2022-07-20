class MachineFunctions {

    private var waterStocks = MachineStocks.WATER.ingredients
    private var milkStocks = MachineStocks.MILK.ingredients
    private var beanStocks = MachineStocks.BEAN.ingredients
    private var cupsStocks = MachineStocks.CUPS.ingredients
    private var moneyStocks = MachineStocks.MONEY.ingredients

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

    private fun machineForBuy(waterMinus: Int, milkMinus: Int, beanMinus: Int, cupMinus: Int, moneyPlus: Int) {

        if (waterStocks < waterMinus) {
            println("Sorry, not enough water!")
        } else if (milkStocks < milkMinus) {
            println("Sorry, not enough milk!")
        } else if (beanStocks < beanMinus) {
            println("Sorry, not enough beans!")
        } else if (cupsStocks < cupMinus) {
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

            waterStocks -= waterMinus
            milkStocks -= milkMinus
            beanStocks -= beanMinus
            cupsStocks -= cupMinus
            moneyStocks += moneyPlus
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

    private fun machineForFill(waterPlus: Int, milkPlus: Int, beanPlus: Int, cupPlus: Int) {

        waterStocks += waterPlus
        milkStocks += milkPlus
        beanStocks += beanPlus
        cupsStocks += cupPlus
    }

    fun informationAboutStocks() {
        println("""
        The coffee machine has:
        $waterStocks ml of water
        $milkStocks ml of milk
        $beanStocks g of coffee beans
        $cupsStocks disposable cups

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
        
        Proceeds: $$moneyStocks
        
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
                            if (moneyStocks <= 0) {
                                println("""
                                I'm not a bank. I do not issue a loan. There is no money. But you hold on!
                            """.trimIndent())
                            } else {
                                moneyStocks -= moneyStocks
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
}