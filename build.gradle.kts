plugins {
    id("com.android.application") version "8.5.2" apply false
    id("com.android.library") version "8.5.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
}
dependencies {
    // Wajib untuk AppCompatActivity
    implementation("androidx.appcompat:appcompat:1.7.1")

    // Wajib untuk ContextCompat, startForegroundService, dll.
    implementation("androidx.core:core-ktx:1.13.1")

    // ... dependensi lain yang sudah ada
}