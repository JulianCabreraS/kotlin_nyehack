package com.bignerdranch.nyethack

import java.io.File

class Player(name: String,
             var healthPoints: Int=100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean)
{
    val hometown= selectHometown()


    init {
        require(healthPoints > 0, {"healthpoints must be greater than zero"})
        require(name.isNotBlank(), {"player must have a name"})
    }
    constructor(name: String): this(name,
        isBlessed = true,
        isImmortal = false
    ){
        if(name.toLowerCase() == "kar") healthPoints =40
    }

    var name = "Madrigal"
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()


    fun castFireball(numFireballs: Int = 2) = println("a glass of fireball into existence (x$numFireballs)")

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus(): String {
        var healthStatus = when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches"
            in 75..89 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly"
            } else {
                "has some minor wounds"
            }
            in 15..74 -> "looks pretty hurt"
            else -> "is in awful condition"
        }
        return healthStatus
    }
}