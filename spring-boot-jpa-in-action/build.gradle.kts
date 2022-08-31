plugins{
    kotlin("plugin.jpa") version  Versions.kotlin
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {

    implementation(project(Projects.domain))

    implementation(Dependencies.springBootWeb)
    implementation(Dependencies.springBootJpa)

    runtimeOnly(Dependencies.h2)
    implementation(Dependencies.postgres)

    implementation(Dependencies.springEnvers)

    implementation(Dependencies.queryDslJpa)
    kapt(Dependencies.queryDslApt)
    testImplementation(Dependencies.queryDslJpa)
    testAnnotationProcessor(Dependencies.queryDslApt)
    testImplementation(testFixtures(project(Projects.domain)))
}