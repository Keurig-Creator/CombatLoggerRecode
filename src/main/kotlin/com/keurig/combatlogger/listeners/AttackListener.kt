package com.keurig.combatlogger.listeners

import com.keurig.combatlogger.PlayerCache
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

class AttackListener : Listener {

    @EventHandler
    fun onAttack(event: EntityDamageByEntityEvent) {
        if (event.damager is Player && event.entity is Player) {

            val playerCache: PlayerCache = PlayerCache.getCache(event.damager as Player)
            val targetCache: PlayerCache = PlayerCache.getCache(event.entity as Player)

            playerCache.tagged = true
            targetCache.tagged = true
        }
    }

}