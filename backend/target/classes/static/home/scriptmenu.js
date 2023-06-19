const menuButton = document.getElementById("menu-button");
const menuButtonMenu = document.getElementById("menu-button-menu");
const menu = document.getElementById("menu");
const barraPesquisa = document.querySelector(".barrapesquisa");
const overlay2 = document.querySelector("#overlay-n");

menuButton.addEventListener("click", () => {
  menu.classList.toggle("active");
  barraPesquisa.classList.toggle("active");
  overlay2.style.display = "block";
});

menuButtonMenu.addEventListener("click", () => {
  menu.classList.remove("active");
  barraPesquisa.classList.remove("active");
  overlay2.style.display = "none";
});