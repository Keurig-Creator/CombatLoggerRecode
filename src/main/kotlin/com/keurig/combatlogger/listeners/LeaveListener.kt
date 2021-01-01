package com.keurig.combatlogger.listeners

import com.keurig.combatlogger.PlayerCache
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class LeaveListener : Listener {

    @EventHandler
    fun onPlayerLeave(event: PlayerQuitEvent) {
        val player = event.player
        val cache: PlayerCache = PlayerCache.getCache(player)

        cache.tagged = false
    }

}