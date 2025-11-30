apply(plugin = "info.solidsoft.pitest")

dependencies {
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.28.1")
}

configure<info.solidsoft.gradle.pitest.PitestPluginExtension> {
    junit5PluginVersion.set("1.0.0")
    avoidCallsTo.set(setOf("kotlin.jvm.internal"))
    mutators.set(setOf("STRONGER"))
    targetClasses.set(setOf("org.testingplayground.*"))
    targetTests.set(setOf("org.testingplayground.*"))
    threads.set(Runtime.getRuntime().availableProcessors())
    outputFormats.set(setOf("XML", "HTML"))
    mutationThreshold.set(75)
}