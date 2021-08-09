import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.ScriptHandlerScope
import org.gradle.plugin.use.PluginDependenciesSpec

/**
 * Extension to add all implementations from a provided list
 */
fun DependencyHandler.api(list: List<String>) = list.forEach { add("api", it) }

/**
 * Extension to add all implementations from a provided list
 */
fun DependencyHandler.implementation(list: List<String>) = list.forEach { add("implementation", it) }

/**
 * Extension to add all androidTestImplementations from a provided list
 */
fun DependencyHandler.androidTestImplementation(list: List<String>) =
    list.forEach { add("androidTestImplementation", it) }

/**
 * Extension to add all testImplementations from a provided list
 */
fun DependencyHandler.testImplementation(list: List<String>) = list.forEach { add("testImplementation", it) }

/**
 * Extension to add all kapt and annotationProcessors from a provided list
 */
fun DependencyHandler.kapt(list: List<String>) = list.forEach { add("kapt", it) }

/**
 * Extension to add all plugins from a provided list
 */
fun PluginDependenciesSpec.id(list: List<String>) = list.forEach { id(it) }

/**
 * Extension to add all classpaths from a provided list
 */
fun ScriptHandlerScope.classpath(list: List<String>) = dependencies { list.forEach { classpath(it) } }
