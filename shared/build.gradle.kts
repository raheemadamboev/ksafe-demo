plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    android {
        namespace = "xyz.teamgravity.cmpgradle9.shared"

        compileSdk {
            version = release(libs.versions.sdk.compile.get().toInt()) {
                minorApiLevel = 1
            }
        }

        minSdk = libs.versions.sdk.min.get().toInt()

        androidResources {
            enable = true
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            // compose
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.compose.resources)
            implementation(libs.compose.preview)

            // compose material3
            implementation(libs.compose.material3)

            // lifecycle
            implementation(libs.lifecycle.runtime)
            implementation(libs.lifecycle.viewmodel)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.tooling)
}