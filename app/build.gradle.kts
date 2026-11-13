// Dafa Ardianto
// 3420230004 Teknik Informatika

plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.tugas6dafaardianto"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.example.tugas6dafaardianto"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

// Konfigurasi Nama File APK Output menjadi Tugas6DafaArdianto.apk
androidComponents {
    onVariants { variant ->
        variant.outputs.forEach { output ->
            output.outputFileName.set("Tugas6DafaArdianto.apk")
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}