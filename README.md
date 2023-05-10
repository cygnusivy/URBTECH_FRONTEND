# URBTECH APIs

### Este projeto contem um conjunto de APIs integradas para realizar um CRUD na aplicação desenvolvida. Todo backend foi desenvolvido na linguagem Java, utilizando o framework de desenolvimento Spring Framework e o banco de dados MysQL.
### A versão o Java utilizada durante o desenvolvimento foi a 17 e o servidor da aplicação utilizado foi o tomcat. Para sublir a aplicação basta rodar a classe UrbtechApiAppication e acessar a url localhost:8080 no navegador. A página padrão será a tela inicial da nossa aplicação.

## API de cadastro de usuário (POST)

#### endpoint backend: http://localhost:8080/usuario/cadastro
#### **Caminho de acesso ao frontend:** *Tela inicial > Entrar [TELA DE LOGIN] > Não tem uma conta? Inscreva-se > [TELA DE CADASTRO DE USUÁRIO]*

### A execusão da primeira API é necessária poder utilizar as demais APIs do sistema, sendo esta responsável por realizar o cadastro do usuário.
#### Nesta tela o usuário possui obrigatoriedade de preenchimento para todos os campos requeridos: nome; e-mail; senha; mesma senha. OBS: a senha deve ter no mínimo 8 caracteres.
#### Há um usuário padrão cadastrado, os dados para login são os seguintes:
|**email**|**senha**|
|---|---|
|user@urbtech.com|123456789|
#### Ao realizar o cadastro do usuário uma mensagem será exbida na tela informando se o processo ocorreu com falhas ou com erros. Caso tenha realizado o cadastro com sucesso, o usuário já está habildado para realizar login no sistema.

## API de login de usuário (POST)

#### endpoint backend: http://localhost:8080/login/loginUsuario
#### **Caminho de acesso ao frontend:** *Tela inicial > Entrar [TELA DE LOGIN]*

#### Para realizar o login no sistema basta inserir o email e a senha do usuário. Caso os dados coincidam com os dados do usuário, o login será efetuado com sucesso. O usuário irá cair diretamente no home com os mapas e, para acessar o perfil do usuário, basta clicar nó ícone da foto no cando superior direito da tela. Nesta tela, as informações do usuário serão exibidas da forma como foram cadastradas na tela de cadastro. Contudo, os campos bio, localização, data de nascimento e site ainda não estarão preenchidos. Neste sentido, é necessário preencher os campos e clicar no botão "Editar perfil" que as informações serão atualizadas.
