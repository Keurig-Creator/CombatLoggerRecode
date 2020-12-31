package com.keurig.combatlogger

import com.keurig.combatlogger.listeners.AttackListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class CombatLogger : JavaPlugin() {

    companion object Singleton {
        lateinit var instance: CombatLogger
    }

    override fun onEnable() {
        instance = this

        Bukkit.getPluginManager().registerEvents(AttackListener(), this)
    }


}