package com.keurig.combatlogger.punishment

import org.bukkit.entity.Player
import org.bukkit.event.Listener

abstract class Punishment(val name: String, val numberOfArgs: Int) : Listener {

    lateinit var player: Player

    abstract fun onQuit(label: String, args: Array<String>)
}