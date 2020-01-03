package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    //Difference between val and var
    val player = Player()
    player.castFireball()

    //Aura
    val auraColor = player.auraColor()

    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}



