# README

## Setup

Comece clonando o projeto e executando alguns comandos básicos.

```
    $ git clone git@github.com:guxtavo-as/api_company_supplier.git
```

### Docker

Você precisa ter um ambiente Docker funcional. Siga os links abaixo para instalar, dependendo do seu sistema operacional.

* [Windows](https://docs.docker.com/docker-for-windows/install/)
* [Ubuntu](https://docs.docker.com/install/linux/docker-ce/ubuntu/)
* [OSX](https://docs.docker.com/docker-for-mac/install/)

Você também precisara do docker-compose

* [docker-compose](https://docs.docker.com/compose/install/)

Para saber se o docker está ok e funcionando vá no terminal e digite

```
    $ docker ps
    $ docker-compose ps
```

Se retornar algo semelhante ao que está escrito abaixo, tudo estará bem com sua instalação.

```
CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS               NAMES
```

Isso exigirá que você crie a imagem do contêiner do aplicativo (isso pode demorar um pouco, dependendo da velocidade da sua internet)

```
    $ docker-compose up --build
```

Com isso, acesse http://localhost:4000/ no caso de Linux ou http://<ip>:4000/ sendo o IP da VM, e então você estará com o aplicativo em execução no Docker

Instalação complet!a

---

### Tecnologias

```
    Desenvolvido em Java: eclipse-temurin:17-jdk-alpine
    Banco Postgres: version 42.7.4
    Framework: Springboot
    Biblioteca: Lombok
```