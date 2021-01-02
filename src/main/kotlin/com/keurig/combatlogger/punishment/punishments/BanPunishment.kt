package com.keurig.combatlogger.punishment.punishments

import com.keurig.combatlogger.punishment.Punishment

class BanPunishment : Punishment("ban", 3) {
    
    override fun onQuit(label: String, args: Array<String>) {
        TODO("Not yet implemented")
    }

}