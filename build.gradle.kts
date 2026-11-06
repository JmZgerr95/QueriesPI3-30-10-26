plugins {
	java
	id("org.springframework.boot") version "4.1.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "br..com.senac.sp.pi3.3mb.blog"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	dependencies {
		implementation("com.querydsl:querydsl-jpa:5.1.0:jakarta")
		annotationProcessor("com.querydsl:querydsl-apt:5.1.0:jakarta")
		annotationProcessor("jakarta.persistence:jakarta.persistence-api")
		implementation("org.springframework.boot:spring-boot-h2console")
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-hateoas")
		implementation("org.springframework.boot:spring-boot-starter-validation")
		implementation("org.springframework.boot:spring-boot-starter-webmvc")
		implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.1.0")
		implementation("io.github.openfeign.querydsl:querydsl-jpa:7.0")
		annotationProcessor("io.github.openfeign.querydsl:querydsl-apt:7.0:jpa")
		compileOnly("org.projectlombok:lombok")
		developmentOnly("org.springframework.boot:spring-boot-devtools")
		runtimeOnly("com.h2database:h2")
		annotationProcessor("org.projectlombok:lombok")
		annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
		testImplementation("org.springframework.boot:spring-boot-starter-data-jpa-test")
		testImplementation("org.springframework.boot:spring-boot-starter-hateoas-test")
		testImplementation("org.springframework.boot:spring-boot-starter-validation-test")
		testCompileOnly("org.projectlombok:lombok")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
		testAnnotationProcessor("org.projectlombok:lombok")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}