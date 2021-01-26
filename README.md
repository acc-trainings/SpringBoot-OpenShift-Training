# Customer API

# Spring Boot API Development

#### **`Spring Initializr`** - Create Project Structure
![spring-initializer](https://github.com/acc-trainings/customer-api/blob/main/img/spring-initializer.gif)

#### **`POM`**
Update [POM](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html#:~:text=A%20Project%20Object%20Model%20or,default%20values%20for%20most%20projects.) as following
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.4.1</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.acc.training</groupId>
	<artifactId>customer-api</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>customer-api</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>11</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.5.2</version>
		</dependency>
 </dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<!-- This 2019 version is required for OpenAPI 3 -->
				<groupId>io.swagger.codegen.v3</groupId>
				<artifactId>swagger-codegen-maven-plugin</artifactId>
				<version>3.0.24</version>
				<executions>
					<execution>
						<goals>
							<goal>generate</goal>
						</goals>
						<configuration>
							<inputSpec>${project.basedir}/src/main/resources/customer-api.yml</inputSpec>
							<language>spring</language>
							<output>${project.build.directory}/generated-sources/</output>
							<generateSupportingFiles>false</generateSupportingFiles>
							<modelPackage>com.acc.training.customerapi.model</modelPackage>
							<apiPackage>com.acc.training.customerapi.api</apiPackage>
							<configOptions>
								<interfaceOnly>true</interfaceOnly>
							</configOptions>
						</configuration>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>build-helper-maven-plugin</artifactId>
				<version>3.2.0</version>
				<executions>
					<execution>
						<id>add-source</id>
						<phase>generate-sources</phase>
						<goals>
							<goal>add-source</goal>
						</goals>
						<configuration>
							<sources>
								<source>${project.build.directory}/generated-sources/src/main/java</source>
							</sources>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>
```

#### **`Run the application`**
![run application](https://github.com/acc-trainings/customer-api/blob/main/img/run-spring.gif)



