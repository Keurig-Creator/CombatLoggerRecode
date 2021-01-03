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

        registerConfig()

        punishmentManager = PunishmentManager(this)

        Bukkit.getPluginManager().registerEvents(AttackListener(), this)
        Bukkit.getPluginManager().registerEvents(JoinListeners(), this)

//        config.getConfigurationSection("punishments")!!.getKeys(false).forEach {
//            Chat.log("&4$it.msg = &c" + config.getString("punishments.$it.msg"))
//        }
    }

    override fun onDisable() {
        punishmentManager.unregisterPunishments()
    }

    private fun registerConfig() {
        config.options().copyDefaults()
        saveDefaultConfig()

        updateOldConfig()
    }

    private fun updateOldConfig() {
        if (config.getConfigurationSection("version") == null || config.getInt("version") == 1) {
            println("OLDCONFIG!")
        }
    }


}