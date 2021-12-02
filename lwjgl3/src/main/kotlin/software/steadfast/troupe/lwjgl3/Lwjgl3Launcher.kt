@file:JvmName("Lwjgl3Launcher")

package software.steadfast.troupe.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import software.steadfast.troupe.Core

/** Launches the desktop (LWJGL3) application. */
fun main() {
    Lwjgl3Application(Core(), Lwjgl3ApplicationConfiguration().apply {
        setTitle("Troupe")
        setWindowedMode(640, 480)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
