//btns
const btn_Encriptar = document.getElementById("btn_E");
const btn_Desencriptar = document.getElementById("btn_D");
const btn_Copy = document.getElementById("btn_C");
//text
const text = document.getElementById("text");
const text_Encriptado = document.querySelector(".Text-Enc");
//elements to remove
const removeElements = document.querySelector(".box");
//add style .active
const outputText = document.querySelector(".outputText");
const cardPrev = document.querySelector(".cardPrev");
//btn_Copy,Text_Encriptado
//-------------------------------------------------------
//eventos
text.addEventListener("input", () => {
  if (text.value.length == 0) {
    removeElements.classList.remove("hide");
    removeElements.classList.remove("remove");
    outputText.classList.remove("active");
    cardPrev.classList.remove("active");
    btn_Copy.classList.remove("active");
    text_Encriptado.classList.remove("active");
  } else {
    removeElements.classList.add("hide");
  }
});
btn_Encriptar.addEventListener("click", () => {
  console.log("clik encriptar");
  if (text.value.length == 0) {
    alert("Ingrese texto a encriptar");
  } else {
    removeElements.classList.add("remove");
    outputText.classList.toggle("active");
    cardPrev.classList.add("active");
    btn_Copy.classList.add("active");
    text_Encriptado.classList.add("active");
    const rpta = encriptar(text.value);
    text_Encriptado.innerHTML = rpta;
  }
});
btn_Desencriptar.addEventListener("click", () => {
  console.log("click desencriptar");
  if (text.value.length == 0) {
    alert("Ingrese texto a desencriptar");
  } else {
    removeElements.classList.add("remove");
    outputText.classList.add("active");
    cardPrev.classList.add("active");
    btn_Copy.classList.add("active");
    text_Encriptado.classList.add("active");
    const rpta = desencriptar(text.value);
    text_Encriptado.innerHTML = rpta;
  }
});
btn_Copy.addEventListener("click", () => {
  text_Encriptado.select();
  const textCopy = document.execCommand("copy");
  text.value = "";
  text.focus();
  removeElements.classList.remove("hide");
  outputText.classList.remove("active");
  cardPrev.classList.remove("active");
  btn_Copy.classList.remove("active");
  text_Encriptado.classList.remove("active");
  removeElements.classList.remove("remove");
});
function encriptar(word) {
  const wordLower = word.toLowerCase().trim();
  let arrayLetters = [];
  for (let i = 0; i < wordLower.length; i++) {
    switch (wordLower[i]) {
      case "a":
        arrayLetters.push("ai");
        break;
      case "e":
        arrayLetters.push("enter");
        break;
      case "i":
        arrayLetters.push("imes");
        break;
      case "o":
        arrayLetters.push("ober");
        break;
      case "u":
        arrayLetters.push("ufat");
        break;
      default:
        arrayLetters.push(wordLower[i]);
        break;
    }
  }
  return arrayLetters.join("");
}
/*
let word="felicidades por enfrentar este desafio y haberlo concluido con exito!";
console.log(encriptar(word));
*/

function desencriptar(word) {
  let wordLower = word.toLowerCase();
  let keys = ["ai", "enter", "imes", "ober", "ufat"];
  for (let i = 0; i < keys.length; i++) {
    wordLower = wordLower.replaceAll(keys[i], keys[i][0]);
  }
  return wordLower;
}
/*
let palabra="fenterlimescimesdaidenters poberr enternfrenterntair enterstenter dentersaifimesober y haibenterrlober cobernclufatimesdober cobern enterximestober!";
console.log(desencriptar(palabra));
*/
