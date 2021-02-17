package com.keurig.combatlogger.listeners

import com.keurig.combatlogger.CombatLogger
import com.keurig.combatlogger.PlayerCache
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinListeners : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        val cache: PlayerCache = PlayerCache.getCache(player)

        cache.player = player
    }

    @EventHandler
    fun onPlayerLeave(event: PlayerQuitEvent) {
        val player = event.player
        val cache: PlayerCache = PlayerCache.getCache(player)

        cache.tagged = false

        CombatLogger.instance.punishmentManager.onQuit(player)
    }

}