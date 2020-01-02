import java.io.File

const val TAVERN_NAME ="Taernyl's Folly"



val menuList = File("data/tavern-menu-data.txt").readText().split("\n")
val patronGold = mutableMapOf<String, Double>()
var patronList = mutableListOf<String>("Eli", "Mordoc", "Sophie")
val lastName = listOf<String>("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()


fun main(args: Array<String>)
{
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach {
        patronGold[it]=6.0
    }

    var orderCount =0
    while(orderCount <=9){
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }



}

fun performPurchase(price: Double, patronName: String){
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexofApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexofApostrophe)

    val(type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    performPurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims : ${toDragonSpeak("ah, delicious $name!")}"
    } else {
        "$patronName says : thanks for the $name"
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


