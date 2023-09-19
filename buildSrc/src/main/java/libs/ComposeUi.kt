package libs

import org.gradle.api.artifacts.dsl.DependencyHandler

object ComposeUi {

    private val dependencies = listOf(
        "androidx.compose.ui:ui-tooling:$COMPOSE_VERSION",
        "androidx.compose.ui:ui-test-manifest:$COMPOSE_VERSION",
    )

    fun DependencyHandler.composeUi(configurationName: String = "debugImplementation") {
        dependencies.forEach { add(configurationName, it) }
    }
}
