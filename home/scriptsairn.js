const sair2 = document.querySelector('#sair2');
const alertsair2 = document.querySelector(".link-sair-n");
const cancelar2 = document.querySelector("#cancelar-c-n");
const overlay22 = document.querySelector("#overlay-n-2");
const defineSairn = document.querySelector("#sairfinal-n")
const userId = localStorage.getItem('userId');

sair2.addEventListener('click', () => {
    alertsair2.classList.toggle("active");
    overlay22.style.display = "block";
 });

cancelar2.addEventListener('click', () => {
    alertsair2.classList.remove("active");
    overlay22.style.display = "none";
})

defineSairn.addEventListener('click', () => {
    localStorage.setItem('userId', 0);
})