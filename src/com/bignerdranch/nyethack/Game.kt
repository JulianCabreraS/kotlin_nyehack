package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    //Difference between val and var
    val player = Player("Madrigal")
    player.castFireball()

    var currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())


    //Aura
    val auraColor = player.auraColor()

    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}



