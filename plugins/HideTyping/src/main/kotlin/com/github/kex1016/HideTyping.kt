package com.github.kex1016

import android.content.Context
import com.aliucord.annotations.AliucordPlugin
import com.aliucord.entities.Plugin
import com.aliucord.patcher.*
import com.discord.stores.StoreUserTyping

@AliucordPlugin(requiresRestart = false)
class HideTyping : Plugin() {
    override fun start(context: Context) {
        patcher.instead<StoreUserTyping>(
            "setUserTyping", Long::class.java // long channelId
        ) { null }
    }

    override fun stop(context: Context) {
        patcher.unpatchAll()
    }
}
