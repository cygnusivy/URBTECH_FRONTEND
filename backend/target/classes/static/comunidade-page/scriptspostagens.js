document.addEventListener('DOMContentLoaded', function() {
  // Função para buscar as publicações da API
function buscarPublicacoes() {
  // Fazer a chamada para a API
  fetch(`http://localhost:8080/comunidade/selecionaPostagensDaComunidade/1`)
    .then(function (res){
      if (res.status === 200){
        return res.json();
    }else{
      mmsgerro.innerHTML = "Não foi possível carregar os dados";
    }
  })
  .then(data => {
    adicionarPublicacoesAoContainer(data);
  })
  .catch(error => {
    console.error('Erro ao buscar as publicações:', error);
  })
};

// Função para criar uma div para cada publicação
function criarDivPublicacao(publicacao) {
  var divPublicacao = document.createElement("div");
  divPublicacao.className = "post";

  var imgPublicacao = document.createElement("img");
  imgPublicacao.src = publicacao.imgUrl;
  imgPublicacao.alt = "";

  var divComentario = document.createElement("div");
  divComentario.className = "comentario";

  var divCC = document.createElement("div");
  divCC.className = "divcc";

  var imgAutor = document.createElement("img");
  imgAutor.src = publicacao.imgUrlUsuario;
  imgAutor.alt = "";

  var pLegenda = document.createElement("p");
  var strongAutor = document.createElement("strong");

  strongAutor.textContent = publicacao.nomeUsuario + ": ";
  pLegenda.appendChild(strongAutor);
  pLegenda.appendChild(document.createTextNode(publicacao.descricao));

  var button = document.createElement("button");
  button.className = "b3";

  //button.style.backgroundImage = {DeleteIcon};

  //button.style.backgroundColor = "transparent";


  divCC.appendChild(imgAutor);
  divCC.appendChild(pLegenda);
  
  divComentario.appendChild(divCC);
  divComentario.appendChild(button);

  divPublicacao.appendChild(imgPublicacao);
  divPublicacao.appendChild(divComentario);

  //--

  var overlay = document.createElement("div");
  overlay.id = "overlay";

  var divApagar = document.createElement("div");
  divApagar.className = "link-sair";

  var divApagarFinal = document.createElement("div");
  divApagarFinal.className = "sairp1";

  var pTitulo = document.createElement("p");

  var divDescricao = document.createElement("div");
  divDescricao.className = "sairp2";
  var pDescricao = document.createElement("p");

  var divCancelar = document.createElement("div");
  divCancelar.className = "cancelar";
  
  var aCancelar = document.createElement("a");
  aCancelar.id = "cancelar-c";
  var pC = document.createElement("p");

  var aApagar = document.createElement("a");
  var pA = document.createElement("p");
  aApagar.id = "sairfinal";


  divApagar.appendChild(divApagarFinal);
  divApagar.appendChild(divDescricao);
  divApagar.appendChild(divCancelar);

  divApagarFinal.appendChild(pTitulo);
  divDescricao.appendChild(pDescricao);

  divCancelar.appendChild(aCancelar);
  divCancelar.appendChild(aApagar);

  return divPublicacao;
}

// Função para adicionar as divs das publicações ao contêiner
function adicionarPublicacoesAoContainer(listaPublicacoes) {
  var container = document.getElementById("container");

  listaPublicacoes.forEach(function(publicacao) {
    var divPublicacao = criarDivPublicacao(publicacao);
    container.appendChild(divPublicacao);

    document.addEventListener('DOMContentLoaded', function() {
      
      const apagar = divPublicacao.querySelector('.b3');
const alertsair = divPublicacao.querySelector(".link-sair");
const cancelar = divPublicacao.querySelector("#cancelar-c");
const overlay = divPublicacao.querySelector("#overlay");
const defineSair = divPublicacao.querySelector("#sairfinal")
const userIdd = localStorage.getItem('userId');

      apagar.addEventListener('click', () => {
          alertsair.classList.toggle("active");
          overlay.style.display = "block";
       });
      
      cancelar.addEventListener('click', () => {
          alertsair.classList.remove("active");
          overlay.style.display = "none";
      })
      });
  });


}

// Chamada da função para buscar as publicações e adicionar ao contêiner
buscarPublicacoes();

});