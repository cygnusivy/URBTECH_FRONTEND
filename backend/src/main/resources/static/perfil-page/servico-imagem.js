'use strict';

const btn_foto = document.querySelector('#btn-foto');
const imagem_padrao = document.querySelector('#imagem-padrao');

let widget_cloudinary = cloudinary.createUploadWidget({

    cloudName : 'dfgyr0fi7',
    uploadPreset : 'preset_pabs'

}, (err, result)=>{
    if(!err && result && result.event === 'success'){
        console.log('Imagem salva com exito', result.info);
        imagem_padrao.src = result.info.secure_url;

    }

    if (result.info.secure_url) {
        localStorage.setItem('srcImagemPerfil', result.info.secure_url);
        console.log(result.info.secure_url);
    }
}
);

btn_foto.addEventListener('click', () =>{
    widget_cloudinary.open();
}, false); 