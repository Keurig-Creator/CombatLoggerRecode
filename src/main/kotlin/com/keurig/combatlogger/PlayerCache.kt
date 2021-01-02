package com.keurig.combatlogger

import com.keurig.combatlogger.utils.Chat
import org.bukkit.entity.Player
import java.util.*

class PlayerCache {

    lateinit var player: Player

    var tagged: Boolean = false
        set(value) {
            addCombat(player)
            field = value
        }

    companion object {
        private val CACHE_MAP = mutableMapOf<UUID, PlayerCache>()

        fun getCache(player: Player): PlayerCache {
            var cache: PlayerCache? = CACHE_MAP[player.uniqueId]

            if (cache == null) {
                cache = PlayerCache()
                CACHE_MAP[player.uniqueId] = cache
            }

            return cache
        }
    }

    private fun addCombat(player: Player) {
        if (!tagged)
            player.sendMessage(Chat.color("&cYou are now in combat!"))
    }

    private fun removeCombat(player: Player) {

    }

}