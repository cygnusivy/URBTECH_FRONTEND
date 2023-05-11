const fform = document.querySelector("form");
const nnome = document.querySelector(".nome");
const ddescricao = document.querySelector("#descricao");
const llocaliza = document.querySelector(".localiza");
const nnascimento = document.querySelector(".nascimento");
const ssite = document.querySelector(".site");
const mmsgerro = document.getElementById("mensagem-erro");
const mmsgsucesso = document.getElementById("mensagem-sucesso");
const eeditar = document.querySelector("bteditar");

const estilosErro = {
  color: "#fff",
  fontSize: "12px",
  fontWeight: "bold",
  backgroundColor: "rgba(255, 0, 0, 0.2)",
  width: "100%",
  height: "20px",
  borderRadius: "5px",
  textAlign: "center",
  justifyContent: "center"
};

for (const estiloErro in estilosErro) {
  mmsgsucesso.style[estiloErro] = estilosErro[estiloErro];
}

const estilosSucesso = {
  color: "#fff",
  fontSize: "12px",
  fontWeight: "bold",
  backgroundColor: "rgb(97 255 0 / 20%)",
  width: "100%",
  height: "20px",
  borderRadius: "5px",
  textAlign: "center",
  justifyContent: "center"
};

for (const estiloSucesso in estilosSucesso) {
  mmsgsucesso.style[estiloSucesso] = estilosSucesso[estiloSucesso];
}

const dataAtual = new Date();
const dia = dataAtual.getDate();
const mes = dataAtual.getMonth() + 1;
const ano = dataAtual.getFullYear();
const dataFormatada = `${ano}-${mes}-${dia}`;

const userId = localStorage.getItem('userId');

fetch(`http://localhost:8080/usuario/retornoUsuario/${userId}`)
    .then(function (res){
        if (res.status === 200){
            return res.json();
        }else{
            window.location.href = '/login-page/index.html';
            mmsgerro.innerHTML = "Não foi possível carregar os dados";
            mmsgerro.style.display = "block";
        }
    })
    .then(function (userData){
        nnome.value = userData.name;
        ddescricao.value = userData.descricao;
        llocaliza.value = userData.localizacao;
        nnascimento.value = userData.nascimento;
        ssite.value = userData.site;

        console.log(userData);
    })
    .catch(function (error){
        mmsgerro.innerHTML = "Não foi possível carregar os dados";
        mmsgerro.style.display = "block";
    });

    function aatualizarConta(){

        fetch(`http://localhost:8080/usuario/atualizarUsuario/${userId}`,
        {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "PUT",
            body: JSON.stringify({
                name: nnome.value,
                descricao: ddescricao.value,
                localizacao: llocaliza.value,
                site: ssite.value,
                nascimento: nnascimento.value
            })
        })
        .then(function (res){
            if (res.status === 200){
                mmsgsucesso.innerHTML = "Conta atualizada com sucesso!";
                mmsgsucesso.style.display = "block";
            }else if (res.status === 500){
                mmsgerro.innerHTML = "Não foi possívelo atualizar os dados da conta!";
                mmsgerro.style.display = "block";
            } else{
                mmsgerro.innerHTML = "Não foi possívell atualizar os dados da conta!";
                mmsgerro.style.display = "block";
            }
        })
        .catch(function (res){
            mmsgerro.innerHTML = "Não foi possívelu atualizar os dados da conta!";
            mmsgerro.style.display = "block";
        })
    };

    fform.addEventListener('submit', function(event){
      event.preventDefault();
     if(nnascimento.value > dataFormatada){
        mmsgerro.innerHTML = "Data de nascimento deve ser anterior a data atual";
        mmsgerro.style.display = "block";
     }else{
        aatualizarConta();
     }
    });