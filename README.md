# URBTECH APIs

### Este projeto contém um conjunto de APIs integradas para realizar um CRUD na aplicação desenvolvida. Todo backend foi desenvolvido na linguagem Java, utilizando o framework de desenvolvimento Spring Framework e o banco de dados MysQL.
### A versão do Java utilizada durante o desenvolvimento foi a 17 e o servidor da aplicação utilizado foi o Tomcat. Para subir a aplicação basta rodar a classe UrbtechApiAppication e acessar a url localhost:8080 no navegador. A página padrão será a tela inicial da nossa aplicação.

### Para que os processos funcionem corretamente é necessário configurar o banco de dados no arquivo de propriedades application.properties. Para isso é necessário adicionar o username e o password da conexão com o banco de dados para que o schema seja criado. Sem o sucesso desta etapa a aplicação não funcionará.

## API de cadastro de usuário (POST)

#### endpoint backend: http://localhost:8080/usuario/cadastro
#### **Caminho de acesso ao frontend:** *Tela inicial > Entrar [TELA DE LOGIN] > Não tem uma conta? Inscreva-se > [TELA DE CADASTRO DE USUÁRIO]*

### A execução da primeira API é necessária para poder utilizar as demais APIs do sistema, sendo esta responsável por realizar o cadastro do usuário.
#### Nesta tela o usuário possui obrigatoriedade de preenchimento para todos os campos requeridos: nome; e-mail; senha; mesma senha. OBS: a senha deve ter no mínimo 8 caracteres.
#### Há um usuário padrão cadastrado, os dados para login são os seguintes:
|**email**|**senha**|
|---|---|
|user@urbtech.com|123456789|
#### Ao realizar o cadastro do usuário uma mensagem será exibida na tela informando se o processo ocorreu com falhas ou com erros. Caso tenha realizado o cadastro com sucesso, o usuário já está habilitado para realizar login no sistema.

## API de login de usuário (POST)

#### endpoint backend: http://localhost:8080/login/loginUsuario
#### **Caminho de acesso ao front end:** *Tela inicial > Entrar [TELA DE LOGIN]*

#### Para realizar o login no sistema basta inserir o email e a senha do usuário. Caso os dados coincidam com os dados do usuário, o login será efetuado com sucesso. O usuário irá cair diretamente no home com os mapas e, para acessar o perfil do usuário, basta clicar no ícone da foto no canto superior direito da tela. Nesta tela, as informações do usuário serão exibidas da forma como foram cadastradas na tela de cadastro. Contudo, os campos bio, localização, data de nascimento e site ainda não estarão preenchidos. Neste sentido, é necessário preencher os campos e clicar no botão "Editar perfil" que as informações serão atualizadas.

## API para retorno de dados no perfil do usuário (GET)

#### endpoint backend: http://localhost:8080/usuario/retornoUsuario/{id}
#### **Caminho de acesso ao frontend:** *Tela inicial > Entrar [TELA DE LOGIN] (botão "ENTRAR") > [TELA DE HOME] (botão do ícone do perfil) > [TELA DE PERFIL DO USUÁRIO]*

#### Após o login no sistema, os dados serão retornados automaticamente na tela de perfil do usuário. Caso as informações sejam retornadas com sucesso, significa que a api está funcionando sem problemas. É possível alterar todas as informações no perfil do usuário.

## API para atualização de dados no perfil do usuário (PUT)

#### endpoint backend: http://localhost:8080/usuario/atualizaUsuario/{id}
#### **Caminho de acesso ao frontend:** *Tela inicial > Entrar [TELA DE LOGIN] (botão "ENTRAR") > [TELA DE HOME] (botão do ícone do perfil) > [TELA DE PERFIL DO USUÁRIO]*

#### Para atualizar os dados os usuários basta alterar dos dados retornados na página e clicar no botão "Editar perfil"

## API para deletar usuário (DELETE)

#### endpoint backend: http://localhost:8080/usuario/apagarUsuario/{id}

#### A API para deleção de usuário não foi integrada ao frontend, porém é possível testá-la via Postman, basta utilizar o endpoint passando o id do usuário a ser deletado.

