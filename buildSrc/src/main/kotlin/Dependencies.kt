import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object Dependencies {
    //Compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"
    const val composeMaterial3 = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val activityComposeComp = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val composeTestAndroid = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
    const val composeTestManifest = "androidx.compose.ui:ui-test-manifest:${Versions.compose}"

    //Compose Destinations
    const val composeDestinationsCore = "io.github.raamcosta.compose-destinations:core:${Versions.composeDestinations}"
    const val composeDestinationsKsp = "io.github.raamcosta.compose-destinations:ksp:${Versions.composeDestinations}"

    //Testing
    const val junit = "junit:junit:${Versions.junit}"
    const val junitTest = "androidx.test.ext:junit:${Versions.junitTest}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

//    // Coroutines
//    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"
//    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1"
//    const val coroutinesLifecycle =  "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
//    const val coroutinesRuntime =  "androidx.lifecycle:lifecycle-runtime-ktx:2.6.0-alpha05"


    //Datastore
    const val datastore = "androidx.datastore:datastore-preferences:${Versions.datastore}"

    //Hilt
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt_version}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt_version}"
    const val hiltAndroidXCompliler = "androidx.hilt:hilt-compiler:1.0.0"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt_version}"

    //Kotlin
    const val kotlinAgp = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"

    //Room
    const val room = "androidx.room:room-runtime:${Versions.room_version}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room_version}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room_version}"

    //Retrofit
    const val retrofit =  "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
    const val moshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit_version}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp_version}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp_version}"


}

fun DependencyHandler.testing() {
    test(Dependencies.junit)
    androidTest(Dependencies.junitTest)
    androidTest(Dependencies.espresso)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial3)
    implementation(Dependencies.activityComposeComp)
    debugImplementation(Dependencies.composeUiToolingPreview)
    debugImplementation(Dependencies.composeTestManifest)
    androidTest(Dependencies.composeTestAndroid)
    implementation(Dependencies.composeDestinationsCore)
    ksp(Dependencies.composeDestinationsKsp)
}

//fun DependencyHandler.coroutines() {
//    implementation(Dependencies.coroutinesCore)
//    implementation(Dependencies.coroutinesAndroid)
//    implementation(Dependencies.coroutinesLifecycle)
//    implementation(Dependencies.coroutinesRuntime)
//}

fun DependencyHandler.datastore() {
    implementation(Dependencies.datastore)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hilt)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidXCompliler)
}

fun hiltAgp(): String = Dependencies.hiltAgp

fun kotlinAgp(): String = Dependencies.kotlinAgp


fun DependencyHandler.room() {
    implementation(Dependencies.room)
    implementation(Dependencies.roomKtx)
    ksp(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshi)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpInterceptor)
}

fun DependencyHandler.ui() {
    implementation(project(":core:ui"))
}

fun DependencyHandler.common() {
    implementation(project(":core:common"))
}

fun DependencyHandler.preferences() {
    implementation(project(":preferences"))
}

fun DependencyHandler.loginFeature() {
    implementation(project(":feature:login"))
}