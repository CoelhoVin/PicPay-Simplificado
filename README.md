## Desafio Backend PicPay

O PicPay Simplificado é uma plataforma em que é possível depositar e realizar transferência de dinheiro entre usuários. Existem dois tipos de usuários, os comuns e os logistas, ambos tem carteiras e realizam transferências entre eles.


## Regras de Negócio

* Para ambos usuários é necessário nome completo, CPF/CNPJ, e-mail e senha.
* CPF/CNPJ devem ser únicos no sistema.
* Usuários podem enviar dinheiro para logistas e usuários.
* Logistas apenas recebem dinheiro, não realizam transferência.

## 
Este projeto foi desenvolvido para resolver o desafio de backend proposto pelo PicPay, seguindo as instruções fornecidas pelo canal de YouTube Build & Run. Durante o desenvolvimento deste projeto, diversas tecnologias e práticas de desenvolvimento, conforme descrito abaixo.
Tecnologias Utilizadas

    Java
    Spring Boot
    Jakarta Persistence (JPA)
    MySQL (via Docker)
    Spring Cloud OpenFeign
    CompletableFuture
    Hibernate Validator
    SLF4J

## Funcionalidades do Projeto

    Criação de uma API com Spring Boot
    Mapeamento de entidades com Jakarta Persistence
    Comunicação com banco de dados MySQL via Docker
    Comunicação com API externa via Spring Cloud OpenFeign
    Processamento assíncrono com CompletableFuture
    Validação de dados de entrada da API com Hibernate Validator
    Tratamento de exceções da API com ControllerAdvice e Problem Details (RFC 7807)
    Efetuação de logs com SLF4J

## Endpoints da API

      POST /wallets : Cria uma nova carteira
      POST /transfer : Realiza uma transferência


## Resultados

![image](https://github.com/CoelhoVin/PicPay-Simplificado/assets/129123809/b27ffd62-cadc-455d-9ab3-b368c65452de)
<p align="center">
  POST criação de uma nova carteira /wallets
</p>

![image](https://github.com/CoelhoVin/PicPay-Simplificado/assets/129123809/47bea9e5-97ea-42f9-a623-d9f2aaf53b8f)
<p align="center">
  POST não processado - Regra de Negócio  /transfer
</p>

![image](https://github.com/CoelhoVin/PicPay-Simplificado/assets/129123809/3739b9f1-7d03-432a-af6a-f26c09d98975)
<p align="center">
  POST realizar um transferência /transfer
</p>

## Visualização das Tabelas

<p align="center">
    <img src="https://github.com/CoelhoVin/PicPay-Simplificado/assets/129123809/dbbe3169-f18e-4a57-9cf8-9a271f10912b">
</p>
<p align="center">
  Tabela Wallet Type
</p>

<p align="center">
    <img src="https://github.com/CoelhoVin/PicPay-Simplificado/assets/129123809/6dee86db-73fe-4b61-a663-394e51e146a7">
</p>
<p align="center">
  Tabela Wallet
</p>

<p align="center">
    <img src="https://github.com/CoelhoVin/PicPay-Simplificado/assets/129123809/ea0e99cb-4f1f-48e5-8a82-1c46b6c5bd7a">
</p>
<p align="center">
  Tabela Transfer
</p>


