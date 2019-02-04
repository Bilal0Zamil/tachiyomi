plugins {
  id("com.android.application")
  id("kotlin-android")
  id("kotlin-kapt")
}

android {
  compileSdkVersion(Config.compileSdk)
  defaultConfig {
    minSdkVersion(Config.minSdk)
    targetSdkVersion(Config.targetSdk)
    applicationId = Config.applicationId
    versionCode = Config.versionCode
    versionName = Config.versionName

    vectorDrawables.useSupportLibrary = true
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFile(getDefaultProguardFile("proguard-android.txt"))
      proguardFile(file("proguard-rules.pro"))
    }
  }
  compileOptions {
    setSourceCompatibility(JavaVersion.VERSION_1_8)
    setTargetCompatibility(JavaVersion.VERSION_1_8)
  }
  sourceSets["main"].java.srcDirs("src/main/kotlin")
}

dependencies {
  implementationProject(Projects.core)
  implementationProject(Projects.coreUi)
  implementationProject(Projects.domain)
  implementationProject(Projects.data)
  implementationProject(Projects.presentation)

  implementation(Deps.toothpick.runtime)
  implementation(Deps.toothpick.smoothie)
  kapt(Deps.toothpick.compiler)

  implementation(Deps.rxAndroid)
  implementation(Deps.cyanea)
  implementation(Deps.androidX.emoji)
}
