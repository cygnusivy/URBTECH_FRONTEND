const sair = document.querySelector('#sair');
const alertsair = document.querySelector(".link-sair");
const cancelar = document.querySelector("#cancelar-c");
const overlay = document.querySelector("#overlay");
const defineSair = document.querySelector("#sairfinal")
const userIdd = localStorage.getItem('userId');

sair.addEventListener('click', () => {
    alertsair.classList.toggle("active");
    overlay.style.display = "block";
 });

cancelar.addEventListener('click', () => {
    alertsair.classList.remove("active");
    overlay.style.display = "none";
})

defineSair.addEventListener('click', () => {
    localStorage.setItem('userIdd', 0);
})