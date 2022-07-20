const val PASSWORD = "qwerty"

fun main() {

    val machineFunctions = MachineFunctions()

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
            machineFunctions.buy()
        } else if (readLn == "2") {
            machineFunctions.fill()
        } else if (readLn == "3") {
            machineFunctions.informationAboutStocks()
        } else if (readLn == "4") {
            machineFunctions.actionsForAdministrator()
        } else if (readLn == "0") {
            break
        } else {
            println("Missing action!")
        }
    }
    println("Have a good day! See you soon! ;)")
}