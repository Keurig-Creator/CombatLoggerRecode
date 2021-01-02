package com.keurig.combatlogger

import com.keurig.combatlogger.listeners.AttackListener
import com.keurig.combatlogger.listeners.JoinListeners
import com.keurig.combatlogger.punishment.PunishmentManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class CombatLogger : JavaPlugin() {

    companion object Singleton {
        lateinit var instance: CombatLogger
        lateinit var punishmentManager: PunishmentManager
    }

    override fun onEnable() {
        instance = this

        punishmentManager = PunishmentManager(this)

        Bukkit.getPluginManager().registerEvents(AttackListener(), this)
        Bukkit.getPluginManager().registerEvents(JoinListeners(), this)
    }

    override fun onDisable() {
        punishmentManager.unregisterPunishments()
    }


}