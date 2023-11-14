# PetLove API

A **PetLove API** é uma pequena e eficiente API REST baseada na landing page de produtos da **Petz**, um conhecido petshop online em todo o Brasil.

O objetivo principal desta API é explorar o framework Spring Boot, juntamente com outras tecnologias, para criar uma solução que persiste informações de produtos em um banco de dados MySQL. Essa API é projetada para ser consumida por qualquer aplicação Web ou Mobile.

## Tecnologias Utilizadas

- Spring Boot 3.1.5
- FlyWay 9.22.3
- Java 17

## Pré-requisitos

Certifique-se de ter os seguintes componentes instalados em sua máquina antes de prosseguir:

- Java 17 ou superior
- Maven 3.x ou superior
- MySQL 8.x em execução na porta 3306
- Postman

## Clonar Projeto

Clone este projeto em uma pasta de sua escolha em seu computador (por exemplo, C:\Projetos).

```bash
git clone https://github.com/seu-usuario/petlove-api.git
```

## Configurar Ambiente

Este projeto foi desenvolvido usando JetBrains IntelliJ, mas a SpringTools Suite 4 também é uma excelente ferramenta para gerenciamento de projetos Spring Boot.

A PetLove API utiliza o Hibernate para se conectar ao banco de dados MySQL. Portanto, é necessário configurar o usuário e senha de acordo com as configurações do MySQL em sua máquina:

1. Abra o arquivo *pom.xml*.
2. Em properties, altere *mysql.db.user* e *mysql.db.password* de acordo com as configurações do seu MySQL.
3. Salve as alterações, atualize e faça o build do Maven.

## Executar Projeto

Execute (ou configure, se necessário) a classe Main, localizada em *src/main/java/edu/fag/petlove*. Isso criará o banco de dados petlovedb no MySQL e inserirá registros por meio das migrações do FlyWay.

## Suporte ao Postman

Como se trata de uma API REST, é necessário usar a ferramenta adequada para testar as rotas. Ao clonar o projeto em seu computador, você encontrará um arquivo chamado **PetLove API.postman_collection.json** na raiz do projeto. Esse arquivo contém a estrutura necessária para realizar testes usando o Postman. Para isso:

1. Abra o Postman e certifique-se de ter um *Workspace* criado.
2. Dentro do seu workspace, clique em *Collections* e em seguida em *Import*.
2. Na janela que foi aberta, escolha a opção *Import Files* e selecione o arquivo *PetLove API.postman_collection.json*.

**Observação**: Antes de testar as rotas, certifique-se de que a aplicação está sendo executada.