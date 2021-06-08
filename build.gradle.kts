import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
    // JXPanda基于Mybatis-plus的代码生成器插件
    id("com.jxpanda.generator") version "2.1.5"

}
object Version {
    const val PANDA_COMMONS = "2.6.1"
    const val MYBATIS_PLUS = "3.2.0"
    const val JJWT = "0.9.1"
    const val JETCACHE = "2.5.11"
    const val SWAGGER2 = "2.9.2"
    const val KOTLINX_COROUTINES = "+"
    const val ALIPAY = "4.8.62.ALL"
    const val SDD_COMMONS = "1.0.33"
    const val HTTP_CLIENT = "4.5.10"
    const val COMMONS_POOL2 = "2.7.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://nexus.jxpanda.com/repository/maven-releases/")
        credentials {
            username = "ezor"
            password = "Ezor2019@)!("
        }
    }
}

dependencies {
    //kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.3")
    //jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.10.1")
    //springboot
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    //权限
    implementation("io.jsonwebtoken:jjwt:${Version.JJWT}")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    // swagger2
    implementation("io.springfox:springfox-swagger-ui:${Version.SWAGGER2}")
    implementation("io.springfox:springfox-swagger2:${Version.SWAGGER2}")
    // 公共类
    implementation("com.jxpanda:jxpanda-commons:${Version.PANDA_COMMONS}")
    // 模板引擎
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    // 拼多多
  // implementation("com.pinduoduo:pop-sdk:1.10.79")
    //单元测试
    implementation(fileTree(mapOf("dir" to "lib", "include" to listOf("*.jar"))))

    testImplementation("org.springframework.boot:spring-boot-starter-test")

//    implementation("org.springframework.boot:spring-boot-starter-log4j2")
    //redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("com.alicp.jetcache:jetcache-starter-redis-lettuce:${Version.JETCACHE}")
    // 重复提交
//    implementation("org.springframework.boot:spring-boot-starter-aop")
//    implementation("org.apache.commons:commons-pool2:2.7.0")
    // apache
//    implementation("org.apache.commons:commons-pool2:${Version.COMMONS_POOL2}")
//    implementation("org.apache.httpcomponents:httpclient:${Version.HTTP_CLIENT}")

}


// 数据库相关依赖
dependencies {
    runtime("mysql:mysql-connector-java")
    implementation("com.baomidou:mybatis-plus-boot-starter:${Version.MYBATIS_PLUS}")
}
// 从spring-boot的依赖中去除logback，改用log4j2
//configurations {
//    all {
//        exclude(module = "spring-boot-starter-logging")
//        exclude(module = "logback-classic")
//        exclude(module = "log4j-over-slf4j")
//    }
//}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<BootJar> {
    archiveBaseName.set("application")
    archiveVersion.set("")
}