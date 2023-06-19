'use strict';

const btn_postar_foto = document.querySelector('#btn-postar_foto');
const imagem_postagem = document.querySelector('#imagem-postagem');
const form = document.querySelector('.form-postagem');
const legenda = document.querySelector('#legenda');
const salvar = document.querySelector('#btn-salvar');

const mensagemSucesso = document.getElementById("mensagem-sucesso");
const mensagemErro = document.getElementById("mensagem-erro");

const userId = localStorage.getItem('userId');

let imgUrlPostagem = ".";

let widget_cloudinary = cloudinary.createUploadWidget({

    cloudName : 'dfgyr0fi7',
    uploadPreset : 'preset_pabs'

}, (err, result)=>{
    if(!err && result && result.event === 'success'){
        console.log('Imagem salva com exito', result.info);
        imagem_postagem.src = result.info.secure_url;
        imgUrlPostagem = result.info.secure_url;
    }

//if (result.info.secure_url) {
  //      localStorage.setItem('srcImagemPost', result.info.secure_url);
  ///      console.log(result.info.secure_url);
 //   }
}
);

btn_postar_foto.addEventListener('click', () =>{
    widget_cloudinary.open();
}, false);


function postar(){
    fetch(`https://urbtech-app.herokuapp.com/post/postar`,
    {
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            method: "POST",
            body: JSON.stringify({
                imgUrl: imgUrlPostagem,
                idUsuario: userId,
                descricao: legenda.value
            })
        })
    .then(function (res) {
        if (res.status === 201) {
            mensagemSucesso.innerHTML = "Postagem realizada com sucesso!";
            mensagemSucesso.style.display = "block";
        }else{
            mensagemErro.innerHTML = "Não foi possível atualizar a conta";
            mensagemErro.style.display = "block";
        }
    })
    .catch(function (res) {
        mensagemErro.innerHTML = "Não foi possível atualizar a conta";
        mensagemErro.style.display = "block";
    })
};

salvar.addEventListener('click', () =>{
    postar();
});