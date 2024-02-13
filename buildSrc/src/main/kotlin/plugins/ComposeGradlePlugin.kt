package plugins

import com.android.build.gradle.LibraryExtension
import compose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class ComposeGradlePlugin: Plugin<Project> {

    override fun apply(project: Project) {
        setProjectConfig(project)
        with(project) {
            dependencies {
                compose()
            }
        }
    }

    private fun setProjectConfig(project: Project) {
        project.android().apply {
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = "1.5.8"
            }
        }
    }

    private fun Project.android(): LibraryExtension {
        return extensions.getByType(LibraryExtension::class.java)
    }
}