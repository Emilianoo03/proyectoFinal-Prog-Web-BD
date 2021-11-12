import diccionario from "./diccionario.js";

const dic = diccionario;

console.log(dic[0].respuesta.toLowerCase());

const Rosco = document.getElementById('Rosco');
const btnEnviar = document.getElementById('btnEnviar');
const btnPasapalabra = document.getElementById('btnPasapalabra');

let i = 0;


btnEnviar.addEventListener('click', () => {
    let inputRespuesta = document.getElementById('inputRespuesta').value;
    inputRespuesta = inputRespuesta.toLowerCase();
      
      
       if (inputRespuesta == dic[i].respuesta.toLowerCase()) {
         alert('Correcto');
      } else {
         alert('Incorrecto');
      }

      NextL();
});


function NextL() {
   if (i != 0 ) {
      console.log("ant" , i);

      Rosco.children[i].classList.add('active');
      Rosco.children[i-1].classList.remove('active');
      console.log("dps" , i);
   }else{
      Rosco.children[i].classList.add('active');
      console.log('entre');
   }
   console.log(dic[i].letra);
   document.getElementById("game_text").innerHTML = dic[i].contiene == true ? `Empieza en ${dic[i].letra}
   : ${dic[i].desc}
   ` : `Contiene ${dic[i].letra}: ${dic[i].desc} `;
   i++;
}
