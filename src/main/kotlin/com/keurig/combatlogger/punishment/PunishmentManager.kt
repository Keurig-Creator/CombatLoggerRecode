package com.keurig.combatlogger.punishment

import com.keurig.combatlogger.CombatLogger
import com.keurig.combatlogger.punishment.punishments.BanPunishment
import com.keurig.combatlogger.punishment.punishments.KickPunishment
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

class PunishmentManager(private val plugin: CombatLogger) {

    init {
        initializeDefault()
    }

    companion object {
        private val punishments = mutableListOf<Punishment>()

        @JvmStatic
        fun registerPunishment(punishment: Punishment) {
            this.punishments.add(punishment)
        }

        fun registerPunishment(punishment: Punishment, plugin: Plugin) {
            Bukkit.getPluginManager().registerEvents(punishment, plugin)
            registerPunishment(punishment)
        }
    }

    private fun initializeDefault() {
        registerPunishment(BanPunishment(), plugin)
        registerPunishment(KickPunishment())
    }

    fun unregisterPunishments() {
        punishments.clear()
    }


}