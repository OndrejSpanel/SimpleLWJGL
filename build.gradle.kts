plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.lwjgl:lwjgl:3.3.3")
    implementation("org.lwjgl:lwjgl-glfw:3.3.3")
    implementation("org.lwjgl:lwjgl-opengl:3.3.3")

    runtimeOnly("org.lwjgl:lwjgl:3.3.3:natives-windows")
    runtimeOnly("org.lwjgl:lwjgl-glfw:3.3.3:natives-windows")
    runtimeOnly("org.lwjgl:lwjgl-opengl:3.3.3:natives-windows")

    runtimeOnly("org.lwjgl:lwjgl:3.3.3:natives-windows-x86")
    runtimeOnly("org.lwjgl:lwjgl-glfw:3.3.3:natives-windows-x86")
    runtimeOnly("org.lwjgl:lwjgl-opengl:3.3.3:natives-windows-x86")

    runtimeOnly("org.lwjgl:lwjgl:3.3.3:natives-linux")
    runtimeOnly("org.lwjgl:lwjgl-glfw:3.3.3:natives-linux")
    runtimeOnly("org.lwjgl:lwjgl-opengl:3.3.3:natives-linux")
}

tasks {
    test {
        useJUnitPlatform()
    }

    shadowJar {
        archiveBaseName.set("lwjgl-hello")
        archiveClassifier.set("")
        archiveVersion.set("")
        manifest {
            attributes["Main-Class"] = "org.example.HelloWorld"
        }
    }
}
