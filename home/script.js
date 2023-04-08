/*var map = L.map('map').setView([51.505, -0.09], 13);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

L.marker([51.5, -0.09]).addTo(map)
    .bindPopup('A pretty CSS3 popup.<br> Easily customizable.')
    .openPopup();
*/
var map;
var opcao = "estacoes.json";
var markers;

function fetchMapData(opcao) {
  if (!map) {
    fetch(opcao)
      .then((response) => response.json())
      .then((teste) => {
        map = L.map("map").setView(
          [teste.records[0][4], teste.records[0][5]],
          13
        );

        L.tileLayer("https://tile.openstreetmap.org/{z}/{x}/{y}.png", {
          attribution:
            '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
        }).addTo(map);

        markers = L.layerGroup().addTo(map);

        teste.records.forEach((record) => {
          var mark = L.marker(
            L.latLng(parseFloat([record[4]]), parseFloat([record[5]]))
          )
            .addTo(markers)
            .bindPopup(record[2]);
        });
      });
  } else {
    fetch(opcao)
      .then((response) => response.json())
      .then((teste) => {
        markers.clearLayers();

        teste.records.forEach((record) => {
          var mark = L.marker(
            L.latLng(parseFloat([record[4]]), parseFloat([record[5]]))
          ).bindPopup(record[2]);

          markers.addLayer(mark);
        });
      });
  }
}

fetchMapData(opcao);

function op(c) {
  var item = document.getElementById("item-" + c).innerHTML;
  document.getElementsByName("opcoes")[0].value = item;
  if (item === "Estacoes de locacao") {
    opcao = "locacoes.json";
  } else if (item === "Estacoes de Reparo") {
    opcao = "estacoes.json";
  } else if (item === "Acidentes") {
    opcao = "acidentes.json";
  } else {
    opcao = "estacoes.json";
  }
  fetchMapData(opcao);
}

function dropdown(p){
    var e = document.getElementsByClassName('dropdown')[0];
    var d = ['block','none'];

    e.style.display = d[p]
}

function setTopo(){
    $(window).scrollTop(0);
}
$(window).bind('scroll', setTopo);

function opMob(c){
  var item = document.getElementById("item-" + c).innerHTML;
  document.getElementsByName("opcoes")[0].value = item;
  if (item === "Estacoes de locacao") {
    opcao = "locacoes.json";
  } else if (item === "Estacoes de Reparo") {
    opcao = "estacoes.json";
  } else if (item === "Acidentes") {
    opcao = "acidentes.json";
  } else {
    opcao = "estacoes.json";
  }
  fetchMapData(opcao);
}

function dropdownMob(p){
    var e = document.getElementsByClassName('dropdown-mobile')[0];
    var d = ['block','none'];

    e.style.display = d[p]
}

var big = true;

$('#inputmobile').click(function() {
    if(big) {
      big = false;
      $('.barrainferior').css('top', '74vh');
      dropdownMob(1);
    } else {
      big = true;
      $('.barrainferior').css('top', '64vh');
      dropdownMob(0);
    }
  });

$('.divider').click(function() {
  if(big) {
    big = false;
    $('.barrainferior').css('top', '74vh');
    dropdownMob(1);
  } else {
    big = true;
    $('.barrainferior').css('top', '64vh');
    dropdownMob(0);
  }
});