import org.springframework.boot.gradle.tasks.bundling.BootJar

apply(plugin = "java-test-fixtures")

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true