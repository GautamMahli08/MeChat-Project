plugins {
   // alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
   id("com.google.gms.google-services")
    id("com.android.application")

}

android {
    namespace = "com.example.mechat"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mechat"
        minSdk = 26
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.config)
    implementation(libs.androidx.recyclerview)
    implementation(libs.firebase.storage)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation (libs.ccp)
    implementation (libs.google.services)
    implementation (libs.firebase.firestore.v2400)


    implementation(platform(libs.firebase.bom))
    implementation ("com.firebaseui:firebase-ui-firestore:8.0.2")

    //noinspection UseTomlInstead
    implementation ("com.google.firebase:firebase-auth")
    //noinspection UseTomlInstead
    implementation ("com.github.dhaval2404:imagepicker:2.1")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

}