package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object Compose {

    private val dependencies = listOf(
        "androidx.compose.ui:ui:$COMPOSE_VERSION",
        "androidx.compose.ui:ui-tooling-preview:$COMPOSE_VERSION",
        "androidx.compose.material:material:$MATERIAL",
        "androidx.navigation:navigation-compose:$NAV_VERSION",
        "androidx.constraintlayout:constraintlayout-compose:$CONSTRAINT_COMPOSE_VERSION",
    )

    fun DependencyHandler.compose(cofigurationName: String = "implementation") {
        dependencies.forEach { add(cofigurationName, it) }
    }
}
