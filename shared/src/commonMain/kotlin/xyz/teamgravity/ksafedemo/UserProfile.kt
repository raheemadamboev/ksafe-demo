package xyz.teamgravity.ksafedemo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfile(
    @SerialName("email") val email: String = "",
    @SerialName("password") val password: String = ""
)