const val TAVERN_NAME ="Taernyl's Folly"
var playerGold=10
var playerSilver =10


fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")

}

fun performPurchase(price: Double){
    displayBalance()
    val totalPurse = playerGold + (playerSilver/100.0)
    print("Total purse : $totalPurse")

    println("purchasing item for $$price")

    val remainingBalance = totalPurse- price
    println("remaining balance  ${"%.2f".format(remainingBalance)}")
}

fun displayBalance() {
    println("Players purse balance: Gold $playerGold, Silver $playerSilver ")
}

private fun placeOrder(menuData: String) {
    var indexofApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexofApostrophe)
    println("Madrigal speaks with $tavernMaster about their order")


    val(type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)

}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }


