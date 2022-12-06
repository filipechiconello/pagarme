# Pagar Me API

API desenvolvida como desafio.
### Pré-requisitos
O que você precisa instalar para rodar o projeto?

* [Gradle](https://gradle.org/)
* [JDK-17](https://www.oracle.com/technetwork/pt/java/javase/downloadsjdk8-downloads-2133151.html)
* [JRE-17](https://www.oracle.com/technetwork/pt/java/javase/downloadsjre8-downloads-2133155.html)
* [DOCKER](https://docs.docker.com/)

### Instalação

git clone https://gitlab.com/friboi/backend/app-manager-api/app-manager-api.git

### Como rodar a API

#### Docker Compose Build and Run
```
sh docker-compose-dev.sh
```

### Para validar se foi instalado corretamente:
```
http://localhost:8080/healthcheck
```
### Para acessar a documentação do Swagger:
```
http://localhost:8080/swagger-ui.html#/
```

## Tecnologias utilizadas

* [Gradle](https://gradle.org/) - De aplicativos móveis a microsserviços, de pequenas empresas a grandes empresas, a Gradle ajuda as equipes a construir, automatizar e fornecer software melhor, mais rapidamente.
* [Spring Boot Web Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) - Starter para construção de web, incluindo aplicativos RESTful, usando o Spring MVC. Usa o Tomcat como o contêiner incorporado padrão
* [Lombok](https://projectlombok.org/) - O Projeto Lombok é uma biblioteca java que se conecta automaticamente ao seu editor e cria ferramentas, apimentando seu java. Nunca escreva outro método getter ou equals novamente, com uma anotação sua classe tem um construtor com todos os recursos, Automatize suas variáveis ​​de registro e muito mais.
* [Model Mapper](http://modelmapper.org/) - Os aplicativos geralmente consistem em modelos de objetos semelhantes, mas diferentes, em que os dados em dois modelos podem ser semelhantes, mas a estrutura e as preocupações dos modelos são diferentes. O mapeamento de objetos facilita a conversão de um modelo em outro, permitindo que modelos separados permaneçam segregados.
* [Swagger](https://swagger.io/) - Simplifique o desenvolvimento de API para usuários, equipes e empresas com o conjunto de ferramentas open source e profissional Swagger.
* [Spring Boot Actuator Starter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator) - Iniciador para usar o Atuador do Spring Boot, que fornece recursos prontos para produção para ajudá-lo a monitorar e gerenciar seu aplicativo.