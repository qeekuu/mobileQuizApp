plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.mobilequizapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.mobilequizapp"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }

	testOptions {
        unitTests.isIncludeAndroidResources = true 
    }	

	buildFeatures {
		viewBinding = true
	}

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "17"
    }
	
	java {
		toolchain {
			languageVersion.set(JavaLanguageVersion.of(17))
		}
	}

    // jesli comopse:
    // buildFeatures { compose = true }
    // composeOptions { kotlinCompilerExtensionVersion = "1.5.5"}
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")	

	//tests
	testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:2.1.0") // do testowania LiveData/ViewModel
	androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

	// KTX dla Activity/Fragment aby użyć by viewModels()
    implementation("androidx.activity:activity-ktx:1.6.1")
    implementation("androidx.fragment:fragment-ktx:1.5.5")

    // ViewModel + LiveData KTX
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")	
	// Compose
    // implementation(platform("androidx.compose:compose-bom:2023.10.00"))
    // implementation("androidx.compose.ui:ui")
    // implementation("androidx.compose.material3:material3")
    // implementation("androidx.activity:activity-compose")
    // implementation("androidx.compose.ui:ui-tooling-preview")
    // debugImplementation("androidx.compose.ui:ui-tooling")	
}

