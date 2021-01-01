package com.keurig.combatlogger

import org.bukkit.entity.Player
import java.util.*

class PlayerCache {

    var tagged: Boolean = false
        set(value) {
            println("df")
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

}