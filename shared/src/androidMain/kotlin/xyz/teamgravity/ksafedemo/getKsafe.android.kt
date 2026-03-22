package xyz.teamgravity.ksafedemo

import eu.anifantakis.lib.ksafe.KSafe

actual fun getKSafe(): KSafe {
    return AppModule.ksafe
}