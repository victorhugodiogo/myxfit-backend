plugins {
    // Dev
    idea

    // Spring
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.depMan)

    // Kotlin
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)

    // DBMS
    alias(libs.plugins.jooq)
    alias(libs.plugins.liquibase)

}

group = "br.com.myxfit"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin
    implementation(kotlin("reflect"))
    implementation(libs.jacksonKotlin)

    // Spring
    implementation(libs.spring.starter.web)
    implementation(libs.spring.starter.validation)

    // Persistence
    runtimeOnly(libs.mysql)
    implementation(libs.spring.starter.jooq)
    implementation(libs.spring.data.commons)

    // jOOQ
    jooqGenerator(libs.mysql)

    // Liquibase
    liquibaseRuntime(libs.liquibase)
    liquibaseRuntime(libs.mysql)
    liquibaseRuntime(libs.picocli)

    // Observability
    implementation(libs.spring.starter.actuator)

    // Spring Doc Open API
    implementation(libs.spring.doc.ui)
    implementation(libs.spring.doc.api)

    // Utilities
    implementation(libs.kotlinLogging)
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    bootJar {
        val archiveRelaseName = "myxfit.${archiveExtension.get()}"
        destinationDirectory.set(File(project.rootDir, "/build"))
        archiveFileName.set(archiveRelaseName)
    }
}

// Database parameters
val jdbcDriver = System.getenv("DB_DRIVER").takeIf { it != null } ?: "com.mysql.cj.jdbc.Driver"
val jdbcUrl = System.getenv("DB_URL").takeIf { it != null } ?: "jdbc:mysql://localhost:3306/db_myxfit"
val jdbcUser = System.getenv("DB_USER").takeIf { it != null } ?: "user_myxfit"
val jdbcPassword = System.getenv("DB_PASSWORD").takeIf { it != null } ?: "1234"

jooq {
    version.set(libs.versions.jooq.getOrElse("3.17.7"))
    edition.set(nu.studer.gradle.jooq.JooqEdition.OSS)

    configurations {

        create("main") {
            generateSchemaSourceOnCompilation.set(false)

            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                jdbc.apply {
                    driver = jdbcDriver
                    url = jdbcUrl
                    user = jdbcUser
                    password = jdbcPassword
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    database.apply {
                        name = "org.jooq.meta.mysql.MySQLDatabase"
                        inputSchema = "db_myxfit"
                        excludes = "databasechangelog|databasechangeloglock|test_table"
                        isOutputSchemaToDefault = true
                    }
                    generate.apply {
                        isPojos = false
                        isRecords = false
                        isRoutines = false
                        isDeprecated = false
                        isFluentSetters = true
                        isJavaTimeTypes = true
                        isPojosToString = false
                        isImmutablePojos = false
                        isPojosAsKotlinDataClasses = false
                        isIndexes = false
                        isSequences = false
                    }
                    target.apply {
                        packageName = "br.com.my.infraestrutura.jooq.persistence"
                        directory = "src/generated/jooq"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

liquibase {
    activities.register("main") {
        this.arguments = mapOf(
            "logLevel" to "info",
            "changeLogFile" to "src/main/resources/db/changelog/changelog.yaml",
            "url" to jdbcUrl,
            "username" to jdbcUser,
            "password" to jdbcPassword)
    }
}

val update by tasks.existing

val generateJooq by tasks.existing {
    dependsOn(update)
}