package com.keurig.combatlogger.utils

import org.bukkit.ChatColor

class Chat {

    companion object {
        fun color(message: String): String {
            return ChatColor.translateAlternateColorCodes('&', message)
        }
    }

}