package xyz.teamgravity.ksafedemo

import eu.anifantakis.lib.ksafe.KSafe

private val ksafe: KSafe by lazy {
    KSafe(
        useSecureEnclave = true
    )
}

actual fun getKSafe(): KSafe {
    return ksafe
}