package com.keurig.combatlogger.utils

import org.bukkit.Bukkit
import org.bukkit.ChatColor

class Chat {

    companion object {
        @JvmStatic
        fun color(message: String): String {
            return ChatColor.translateAlternateColorCodes('&', message)
        }

        @JvmStatic
        fun log(message: Any?) {
            return Bukkit.getConsoleSender().sendMessage(color(message as String))
        }
    }

}