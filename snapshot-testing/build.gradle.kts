dependencies {
    testImplementation("io.github.origin-energy:java-snapshot-testing-junit5:3.3.0")
    testImplementation("io.github.origin-energy:java-snapshot-testing-plugin-jackson:3.3.0")

    testImplementation("org.slf4j:slf4j-simple:2.0.0")

    testImplementation(platform("com.fasterxml.jackson:jackson-bom:2.13.4"))
    testImplementation("com.fasterxml.jackson.core:jackson-core")
    testImplementation("com.fasterxml.jackson.core:jackson-databind")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    testImplementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
}
