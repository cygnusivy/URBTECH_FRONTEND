/*var map = L.map('map').setView([51.505, -0.09], 13);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

L.marker([51.5, -0.09]).addTo(map)
    .bindPopup('A pretty CSS3 popup.<br> Easily customizable.')
    .openPopup();
*/
var map;

fetch("estacoes.json").then((response) =>
{
    response.json().then((teste) =>
    {
       map = L.map('map').setView([teste.records[0][4], teste.records[0][5]], 13);
            L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);

        teste.records.map((record) => 
        {
            var mark = L.marker(
                L.latLng(
                  parseFloat([record[4]]),
                  parseFloat([record[5]])
                )
              )
              .addTo(map)
              .bindPopup(record[2])
        })
    })
})

function op(c){ 
    var item = document.getElementById('item-'+ c).innerHTML; 
    document.getElementsByTagName('input')[0].value = item
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