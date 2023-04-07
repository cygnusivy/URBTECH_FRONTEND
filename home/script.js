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

function dropdown(p) {
  var e = document.getElementsByClassName("dropdown")[0];
  var d = ["block", "none"];

  e.style.display = d[p];
}