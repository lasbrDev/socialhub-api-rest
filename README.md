# SocialHub - Plataforma de Interação Social

## Descrição do Projeto

O SocialHub é uma aplicação que simula uma experiência de interação social entre usuários. Os usuários podem postar status e outros usuários podem adicionar comentários aos posts. O projeto é desenvolvido em Java utilizando o framework Spring Boot e MongoDB como banco de dados.

## Estrutura do Projeto

O projeto está dividido em pacotes, cada um responsável por uma parte específica da aplicação.

- **`br.com.lasbr.socialhub`**: Contém a classe principal da aplicação (`SocialhubApplication`), responsável por iniciar a aplicação Spring Boot.
  
- **`br.com.lasbr.socialhub.domain`**: Contém as classes que representam o modelo de domínio da aplicação. As principais classes são `User` e `Post`, que representam usuários e posts, respectivamente.

- **`br.com.lasbr.socialhub.dto`**: Contém classes DTO (Data Transfer Object) que são utilizadas para transferência de dados entre as camadas da aplicação.

- **`br.com.lasbr.socialhub.repositories`**: Contém interfaces de repositório que estendem o `MongoRepository` do Spring Data MongoDB para acesso ao banco de dados.

- **`br.com.lasbr.socialhub.resources`**: Contém os controladores REST que lidam com as requisições HTTP. `PostResources` trata das operações relacionadas aos posts, enquanto `UserResource` trata das operações relacionadas aos usuários.

- **`br.com.lasbr.socialhub.resources.exception`**: Contém classes para tratamento de exceções específicas da aplicação.

- **`br.com.lasbr.socialhub.resources.util`**: Contém classes utilitárias, como `URL`, responsável por decodificar parâmetros de URL, e outras classes úteis.

- **`br.com.lasbr.socialhub.services`**: Contém as classes de serviço que implementam a lógica de negócio da aplicação. `PostService` e `UserService` realizam operações relacionadas a posts e usuários, respectivamente.

- **`br.com.lasbr.socialhub.services.exception`**: Contém exceções específicas da aplicação.

## Endpoints

### Posts:

- **`GET /posts/{id}`**: Obtém um post pelo ID.

- **`GET /posts/titlesearch?text={text}`**: Busca posts pelo título.

- **`GET /posts/fullsearch?text={text}&minDate={minDate}&maxDate={maxDate}`**: Busca completa considerando texto, data mínima e máxima.

### Usuários:

- **`GET /users`**: Lista de todos os usuários.

- **`GET /users/{id}`**: Obtém um usuário pelo ID.

- **`POST /users`**: Cria um novo usuário.

- **`DELETE /users/{id}`**: Exclui um usuário pelo ID.

- **`PUT /users/{id}`**: Atualiza informações de um usuário pelo ID.

- **`GET /users/{id}/posts`**: Lista de posts de um usuário.

## Exceções Personalizadas

A aplicação trata exceções personalizadas, como a `ObjectNotFoundException`, retornando respostas HTTP adequadas. Isso proporciona uma experiência mais amigável para o usuário.


## Próximas Implementações TO-DO

A seguir estão algumas funcionalidades adicionais que serão implementadas para enriquecer a experiência na plataforma SocialHub:

### Para Posts:

- **Curtir um Post:**
  - **`POST /posts/{id}/like`**: Adiciona uma curtida a um post específico.

- **Compartilhar um Post:**
  - **`POST /posts/{id}/share`**: Compartilha um post específico.

- **Apagar um Comentário:**
  - **`DELETE /posts/{postId}/comments/{commentId}`**: Remove um comentário de um post.

- **Desfazer Curtida em um Post:**
  - **`DELETE /posts/{id}/like`**: Remove a curtida de um post específico.

### Para Usuários:

- **Adicionar Foto ao Perfil:**
  - **`POST /users/{id}/photo`**: Adiciona uma foto ao perfil do usuário.

- **Atualizar Data de Aniversário:**
  - **`PUT /users/{id}/birthday`**: Atualiza a data de aniversário do usuário.

- **Atualizar Descrição do Perfil:**
  - **`PUT /users/{id}/description`**: Atualiza a descrição do perfil do usuário.

### Outros:

- **Listar Curtidas em um Post:**
  - **`GET /posts/{id}/likes`**: Obtém a lista de usuários que curtiram um post.

- **Listar Compartilhamentos de um Post:**
  - **`GET /posts/{id}/shares`**: Obtém a lista de usuários que compartilharam um post.

- **Listar Comentários de um Post:**
  - **`GET /posts/{id}/comments`**: Obtém a lista de comentários de um post.

---

## Requisitos

Para executar a aplicação SocialHub, você precisará dos seguintes requisitos instalados em sua máquina:

- [Java 17](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MongoDB](https://www.mongodb.com/try/download/community)
- [Insomnia](https://insomnia.rest/download)

## Configuração do MongoDB (via Docker - opcional)

Se preferir, você pode usar Docker para configurar um ambiente MongoDB facilmente. Certifique-se de ter o Docker instalado.

Na pasta resources do projeto (src/main/resources) adicione um arquivo docker-compose.yml na raiz do projeto, com as configurações abaixo:


```yml
version: '3.8'

services:
  mongo-dev:
    image: mongo:latest
    container_name: mongo_dev
    networks:
      - REDEMONGO
    volumes:
      - ./db_data:/data/db
    environment:
      MONGO_INITDB_ROOT_USERNAME: root
      MONGO_INITDB_ROOT_PASSWORD: password
    labels:
      - "com.docker.compose.project=mongo-project"
      - "com.docker.compose.service=mongo-dev"
      - "com.docker.volume.name=mongo_dev"

  mongo-ui:
    image: mongo-express:latest
    container_name: mongo_ui
    networks:
      - REDEMONGO
    ports:
      - "8081:8081"
    environment:
      ME_CONFIG_MONGODB_ADMINUSERNAME: root
      ME_CONFIG_MONGODB_ADMINPASSWORD: password
      ME_CONFIG_MONGODB_URL: mongodb://root:password@mongo_dev:27017/
    labels:
      - "com.docker.compose.project=mongo-project"
      - "com.docker.compose.service=mongo-ui"
      - "com.docker.volume.name=mongo_ui"

networks:
  REDEMONGO:
    driver: bridge
```

Para acessar o `mongo-express (mongo_ui),` você pode acessar o endereço http://localhost:8081 

	Username: admin
	Password: pass

![mongo_ui.png](src/main/resources/docs/prints/mongo_ui.png)


## Utilização da Aplicação

Para utilizar a aplicação, você pode clonar este repositório e executar a aplicação localmente. Certifique-se de ter um ambiente configurado com Java e MongoDB.

1. Clone o repositório:

```bash
git clone https://github.com/lasbrDev/socialhub.git
```

Abrir a aplicação na sua IDE favorita para Java e testar.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, propor melhorias ou enviar pull requests.
   
## Licença   

Este projeto está licenciado sob a [MIT LICENSE](LICENSE)
