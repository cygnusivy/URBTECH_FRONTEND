
// Função para buscar as publicações da API
function buscarPublicacoes() {
  // Fazer a chamada para a API
  fetch(`https://5857-45-234-11-160.ngrok-free.app/comunidade/selecionaPostagensDaComunidade/1`)
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

  var imgAutor = document.createElement("img");
  imgAutor.src = publicacao.imgUrlUsuario;
  imgAutor.alt = "";

  var pLegenda = document.createElement("p");
  var strongAutor = document.createElement("strong");

  strongAutor.textContent = publicacao.nomeUsuario + ": ";
  pLegenda.appendChild(strongAutor);
  pLegenda.appendChild(document.createTextNode(publicacao.descricao));

  divComentario.appendChild(imgAutor);
  divComentario.appendChild(pLegenda);

  divPublicacao.appendChild(imgPublicacao);
  divPublicacao.appendChild(divComentario);

  return divPublicacao;
}

// Função para adicionar as divs das publicações ao contêiner
function adicionarPublicacoesAoContainer(listaPublicacoes) {
  var container = document.getElementById("container");

  listaPublicacoes.forEach(function(publicacao) {
    var divPublicacao = criarDivPublicacao(publicacao);
    container.appendChild(divPublicacao);
  });
}

// Chamada da função para buscar as publicações e adicionar ao contêiner
buscarPublicacoes();