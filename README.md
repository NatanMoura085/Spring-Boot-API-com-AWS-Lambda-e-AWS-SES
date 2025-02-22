# Spring Boot API com AWS Lambda e AWS SES

Este projeto é uma aplicação Spring Boot que integra com o AWS Lambda e o AWS SES para fornecer uma API que pode ser utilizada para acionar funções Lambda e enviar e-mails usando o Simple Email Service (SES) da AWS.

## Funcionalidades

- **AWS Lambda**: Permite invocar funções Lambda de maneira simples.
- **AWS SES**: Envia e-mails com facilidade através do serviço SES da AWS.

## Pré-requisitos

Antes de rodar este projeto, verifique os seguintes requisitos:

- Java 11 ou superior
- Maven 3.6+ para gerenciamento de dependências
- Conta na AWS com permissões para acessar AWS Lambda e SES
- AWS CLI configurado (opcional, mas recomendado para testes locais)

## Dependências

As dependências principais do projeto são:

- Spring Boot
- Spring Web
- AWS SDK (para Lambda e SES)
- Spring Cloud Function (para invocar funções Lambda)

No arquivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.amazonaws</groupId>
        <artifactId>aws-java-sdk-lambda</artifactId>
    </dependency>
    <dependency>
        <groupId>com.amazonaws</groupId>
        <artifactId>aws-java-sdk-ses</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-function-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
</dependencies>
