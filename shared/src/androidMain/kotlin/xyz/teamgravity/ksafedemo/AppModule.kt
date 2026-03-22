package xyz.teamgravity.ksafedemo

import android.content.Context
import eu.anifantakis.lib.ksafe.KSafe

object AppModule {
    private var applicationContext: Context? = null

    val ksafe: KSafe by lazy {
        KSafe(
            context = requireNotNull(applicationContext),
            useStrongBox = true
        )
    }

    ///////////////////////////////////////////////////////////////////////////
    // API
    ///////////////////////////////////////////////////////////////////////////

    fun init(context: Context) {
        applicationContext = context.applicationContext
    }
}