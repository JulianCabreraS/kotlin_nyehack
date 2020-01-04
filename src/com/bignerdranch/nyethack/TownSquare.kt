package com.bignerdranch.nyethack

class TownSquare : Room("Town Square"){
    override val dangerLevel = super.dangerLevel-3
    private var bellSound = "GWONG"

    final override fun load(): String //avoid to be overriden
    {
        return "The village rally and cheers as  you enter \n ${ringBell()}"
    }

    private fun ringBell() = "The bell tower announces your arrival . $bellSound"
}