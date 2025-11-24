plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.myapp"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.myapp"
        minSdk = 30
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.activity:activity-compose:1.9.2")

    // Compose BOM (CORRECT)
    implementation(platform("androidx.compose:compose-bom:2024.10.01"))

    // Compose UI (no versions)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Material3
    implementation("androidx.compose.material3:material3")

    // Foundation (LazyColumn, LazyRow, etc.)
    implementation("androidx.compose.foundation:foundation")

    // Navigation Compose (LATEST)
    implementation("androidx.navigation:navigation-compose:2.9.6")

    // Debug tools
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    // Tests
    testImplementation(libs.junit)
    androidTestImplementation("androidx.test.ext:junit:1.3.0.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.7.0")
}

