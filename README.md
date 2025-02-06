# 📌 Sistema de Gestão e Controle  

## 📖 Sobre o Projeto  
Este projeto tem como objetivo facilitar o **gerenciamento de vendas, controle financeiro e organização de fornecedores e produtos**. Com uma estrutura modular e bem definida, o sistema permite um acompanhamento eficiente de pagamentos, estoque e relatórios.  

## 🏗️ Arquitetura do Projeto  
O projeto segue uma **arquitetura bem definida**, separando responsabilidades entre diferentes camadas:  

- **🧠 Core** → Contém a lógica de negócio, organizada em domínios, gateways e use cases.  
- **🛠️ Infra** → Implementa persistência, mapeamentos, DTOs e comunicação com serviços externos.  
- **🎭 Apresentação** → Responsável pela interface de comunicação com o sistema.  

## 🚀 Tecnologias Utilizadas  
O projeto utiliza tecnologias modernas para garantir **eficiência, escalabilidade e boas práticas**:  

- **Java 21**  
- **Spring Boot** (Web, Security, Data JPA)  
- **Hibernate/JPA** para persistência  
- **JUnit & Mockito** para testes automatizados  
- **Lombok** para reduzir boilerplate  
- **Arquitetura Limpa** e princípios SOLID  

## 📂 Estrutura de Pastas  
```
📦 projeto  
 ┣ 📂 core  
 ┃ ┣ 📂 domain (7 classes)  
 ┃ ┣ 📂 Enum (3 enums)  
 ┃ ┣ 📂 gateway (7 interfaces)  
 ┃ ┣ 📂 usecases (8 módulos: débito, estoque, fornecedor, interfaces, etc.  )  
 ┣ 📂 infra  
 ┃ ┣ 📂 beans (7)  
 ┃ ┣ 📂 dto (7)  
 ┃ ┣ 📂 exceptions (vazio, por enquanto)  
 ┃ ┣ 📂 gatewayinfra (7)  
 ┃ ┣ 📂 mappers (8)  
 ┃ ┣ 📂 persistence (7) → 📂 entities (7)  
 ┃ ┣ 📂 presentation (6 até o momento)  
 ┣  📝 main (arquivo main do Spring)  
```

## 📌 Funcionalidades  
✅ Cadastro e gerenciamento de **vendas**  
✅ Controle de **fornecedores** e **estoque**  
✅ Registro de **pagamentos e débitos**  
✅ Geração de **relatórios**  

## 🛠️ Como Executar o Projeto  

### 📌 Pré-requisitos  
Antes de começar, você precisará ter instalado:  
- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)  
- [Maven](https://maven.apache.org/download.cgi)  
- Banco de dados PostgreSQL ou MySQL (configurável)  

### 📌 Passos para rodar  
1. Clone o repositório:  
   ```sh
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```  
2. Acesse o diretório do projeto:  
   ```sh
   cd nome-do-projeto
   ```  
3. Configure as credenciais do banco no `application.properties`  
4. Execute o projeto com Maven:  
   ```sh
   mvn spring-boot:run
   ```  
5. Acesse a API no navegador: `http://localhost:8080`(Ou seja, ainda não disponivel)  

## 🧪 Testes  
Para rodar os testes automatizados:  
```sh
mvn test
```  

## 📝 Melhorias Futuras  
- 📌 Implementação de autenticação com **JWT**  
- 📌 Melhorias no sistema de relatórios  
- 📌 Integração com serviços externos  

## 🤝 Contribuição  
Se quiser contribuir com o projeto, fique à vontade para abrir **Issues** e enviar **Pull Requests**!  

📌 **Autor**: [Seu Nome](https://github.com/seu-usuario)  
