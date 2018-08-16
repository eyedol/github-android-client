import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
  repositories {
    google()
    jcenter()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:${Versions.GRADLE_PLUGIN}")
    classpath(kotlin("gradle-plugin", version = Versions.KOTLIN))
    // NOTE: Do not place your application dependencies here; they belong
    // in the individual module build.gradle files
  }
}

allprojects {
  repositories {
    jcenter()
    google()
    maven(url = "http://oss.sonatype.org/content/repositories/snapshots")
  }
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = Versions.SOURCE_COMPATIBILITY
}
