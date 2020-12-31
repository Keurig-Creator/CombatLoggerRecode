package com.keurig.combatlogger.listeners

import com.keurig.combatlogger.utils.Chat
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent

class AttackListener : Listener {

    @EventHandler
    fun onAttack(event: EntityDamageByEntityEvent) {
        if (event.damager is Player && event.entity is Player) {
            var player = event.damager
            var entity = event.entity

            player.sendMessage(Chat.color("&cur &amom &1is &9GAE"))
        }
    }

}