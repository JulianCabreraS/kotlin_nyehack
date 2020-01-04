package com.bignerdranch.nyethack

open class Room (val name: String){
    protected open val dangerLevel =5
    fun description() = "Room: $name"

    open fun load() = "nothing much to see here"
}




