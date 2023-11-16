plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}


gradle.taskGraph.whenReady {
    tasks.forEach {task ->
        if (task.name.contains("uploadCrashlyticsMappingFileRelease")) {
            task.enabled = false
        }
    }
}

android {
    namespace = "com.tomato.amelia"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tomato.amelia"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    dataBinding.enable=true
    viewBinding.enable=true
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    //导入retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //Gson retrofit结合Gson框架作json数据转换
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //retrofit2日志打印
    implementation("com.github.ihsanbal:LoggingInterceptor:3.1.0") {
        exclude("org.json","json")
    }
    implementation("com.google.code.gson:gson:2.10.1")

    implementation("com.github.bumptech.glide:glide:4.16.0")

    implementation("com.blankj:utilcodex:1.31.1")
}