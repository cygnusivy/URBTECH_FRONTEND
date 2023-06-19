const formulario = document.querySelector("form");
const botao = document.querySelector("button")
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha1 = document.querySelector(".senha1");
const Isenha2 = document.querySelector(".senha2");
const mensagemSucesso = document.getElementById("mensagem-sucesso");
const mensagemErro = document.getElementById("mensagem-erro");
  
botao.disabled = true;

function validarSenha() {
  if (Isenha1.value === Isenha2.value) {
    botao.disabled = false;
    Isenha2.style.backgroundColor = "initial";
  } else {
    botao.disabled = true;
    Isenha2.style.backgroundColor = "rgba(255, 0, 0, 0.2)";
  }
}

Isenha1.addEventListener("input", validarSenha);
Isenha2.addEventListener("input", validarSenha);

function cadastrar() {

    fetch(`http://localhost:8080/usuario`,
    {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            email: Iemail.value,
            senha: Isenha1.value,
            senha2: Isenha2.value
        })
    })
    .then(function (res) {
        if (res.status === 201) {
            mensagemSucesso.innerHTML = "Conta criada com sucesso!";
            mensagemSucesso.style.display = "block";
        }else{
            mensagemErro.innerHTML = "Um ou mais campos inválidos!";
            mensagemErro.style.display = "block";
        }
    })
    .catch(function (res) {
        mensagemErro.innerHTML = "Um ou mais campos inválidos!";
        mensagemErro.style.display = "block";
    })
};

function limpar() {
    Inome.value ="";
    Iemail.value ="";
    Isenha1.value ="";
    Isenha2.value ="";
};

formulario.addEventListener('submit', function(event){
    event.preventDefault();

validarSenha();
  if (!botao.disabled) {
    cadastrar();
    limpar();
  }
});