package xyz.teamgravity.cmpgradle9

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform