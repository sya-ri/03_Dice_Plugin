package com.github.syari.plugin.dice

import com.github.syari.plugin.dice.Main.Companion.plugin
import com.github.syari.spigot.api.command.command

object CommandCreator {
    fun register() {
        plugin.command("dice") {
            aliases = listOf("d")
            execute {
                val amount = args.getOrNull(0)?.toIntOrNull()
                val max = args.getOrNull(1)?.toIntOrNull() ?: 6
                if (amount != null) {
                    var sum = 0
                    repeat(amount) {
                        sum += (1..max).random()
                    }
                    sender.send("&fサイコロを振った結果は &6$sum &fです")
                } else {
                    sender.send("&cサイコロの数を整数で入力してください")
                }
            }
        }
    }
}