const m = document.querySelector(".menumobile");
const menuu = document.querySelector(".menum");
const barrainferior = document.querySelector(".barrainferior");
const imgreturn = document.querySelector("#imgreturn");

m.addEventListener("click", () => {
  menuu.classList.toggle("active");
  m.classList.toggle("active");
});

imgreturn.addEventListener("click", () => {
    menuu.classList.remove("active");
    m.classList.remove("active");
  });