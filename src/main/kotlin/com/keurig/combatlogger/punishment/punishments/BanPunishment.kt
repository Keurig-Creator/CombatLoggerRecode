package com.keurig.combatlogger.punishment.punishments

import com.keurig.combatlogger.punishment.Punishment
import com.keurig.combatlogger.utils.Chat

class BanPunishment : Punishment("BAN", 2) {


    override fun onQuit(label: String, args: List<String>) {

        Chat.log("&a${args[0]}")
        Chat.log("&a${args[1]}")

    }

}