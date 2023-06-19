const formulario = document.querySelector("form");
const botao = document.querySelector("button");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const mensagemErro = document.getElementById("mensagem-erro");

botao.disabled = true;

function logar() {

    fetch(`https://urbtech-app.herokuapp.com/login/loginUsuario`,
    {
        headers: {
            "Accept": "application/json",
            "Content-Type": "application/json"
        },
        method: "POST",
        body: JSON.stringify({
            email: Iemail.value,
            senha: Isenha.value
        })
    })
    .then(function (res) {
     if (res.status === 201) {
        return res.json();
     }else{
        mensagemErro.innerHTML = "Email e/ou senha inválido(os)";
        mensagemErro.style.display = "block";
     }
     console.log(res)
     })
     .then(function (data) {
        localStorage.setItem('userId', data.idUser);
        window.location.href = "../home/index.html";
     })
     .catch(function (res) {
        mensagemErro.innerHTML = "Email e/ou senha inválido(os)";
        mensagemErro.style.display = "block";
     })
};

formulario.addEventListener('submit', function(event){
    event.preventDefault();
    logar();
});