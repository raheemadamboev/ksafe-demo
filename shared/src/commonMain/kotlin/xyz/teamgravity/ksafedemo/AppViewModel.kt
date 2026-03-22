package xyz.teamgravity.ksafedemo

import androidx.lifecycle.ViewModel
import eu.anifantakis.lib.ksafe.KSafe
import eu.anifantakis.lib.ksafe.KSafeWriteMode
import eu.anifantakis.lib.ksafe.compose.mutableStateOf

class AppViewModel(
    ksafe: KSafe = getKSafe()
) : ViewModel() {

    var counter: Int by ksafe.mutableStateOf(
        defaultValue = 0,
        key = "counter",
        mode = KSafeWriteMode.Plain
    )
        private set

    var userProfile: UserProfile by ksafe.mutableStateOf(
        defaultValue = UserProfile(),
        key = "user_profile"
    )
        private set

    ///////////////////////////////////////////////////////////////////////////
    // API
    ///////////////////////////////////////////////////////////////////////////

    fun onIncrementCounter() {
        counter++
    }

    fun onEmailChange(email: String) {
        userProfile = userProfile.copy(
            email = email
        )
    }

    fun onPasswordChange(password: String) {
        userProfile = userProfile.copy(
            password = password
        )
    }
}