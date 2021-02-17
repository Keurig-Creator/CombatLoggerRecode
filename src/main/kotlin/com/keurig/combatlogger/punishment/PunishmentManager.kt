package com.keurig.combatlogger.punishment

import com.keurig.combatlogger.CombatLogger
import com.keurig.combatlogger.punishment.punishments.BanPunishment
import com.keurig.combatlogger.punishment.punishments.KillPunishment
import com.keurig.combatlogger.utils.Chat
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin

class PunishmentManager(private val plugin: CombatLogger) {

    init {
        registerPunishment(BanPunishment(), plugin)
        registerPunishment(KillPunishment())
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

    fun onQuit(player: Player) {

        val punishmentList = plugin.config.getStringList("punishment")

        for (punishmentArg in punishmentList) {
            val split = punishmentArg.split(":")
            val label = split[0]
            var args = listOf<String>()

            val punishment = getPunishment(label)

            if (punishment == null) {
                Chat.log("&cCannot find $label punishment! Did you misspell the name or forget to register it?")
                continue
            }

            punishment.player = player

            if (punishment.numberOfArgs >= 1) {
                args = split.toTypedArray().copyOfRange(1, split.size).toList()

                if (punishment.numberOfArgs != args.size) {
                    Chat.log("&c${punishment.name}, must have ${punishment.numberOfArgs} argument${if (punishment.numberOfArgs == 1) "" else "s"}!")
                    continue
                }
            } else if (split.size >= 2) {
                Chat.log("&c${punishment.name} has zero arguments but in config has arugments")
                continue
            }

            punishment.onQuit(label, args)
        }
    }

    fun unregisterPunishments() {
        punishments.clear()
    }

    private fun getPunishment(punishmentName: String): Punishment? {
        for (punishment in punishments) {
            if (punishment.name == punishmentName)
                return punishment
        }

        return null
    }


}