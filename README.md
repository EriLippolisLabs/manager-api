# API de Autenticação com Spring Boot 🔐

API desenvolvida em Spring Boot com autenticação JWT, configuração externalizada via YAML e perfis por ambiente. Estruturada com serviços desacoplados e controladores bem definidos, integra práticas modernas de versionamento no GitHub, garantindo segurança, escalabilidade e fácil manutenção.

---

## 📑 Índice
- [Sobre](#sobre)
- [Tecnologias](#tecnologias)
- [Como executar](#como-executar)
- [Endpoints](#endpoints)

---

## 📖 Sobre
Este projeto tem como objetivo fornecer uma API segura para autenticação de usuários utilizando JWT.  
A configuração é externalizada em arquivos YAML, permitindo fácil adaptação para diferentes ambientes (dev, prod).

---

## 🛠 Tecnologias
- Java 21
- Spring Boot
- Spring Security
- JWT
- Maven
- PostgreSQL

---

## Como executar

git clone https://github.com/seuusuario/seu-repo.git

mvn spring-boot:run

## endpoints

POST /auth/login

GET /users
POST /users
GET /users/{id}
DELETE / /users/{id}
