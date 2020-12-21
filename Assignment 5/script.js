// Write your JavaScript code here!

/* This block of code shows how to format the HTML once you fetch some planetary JSON!
<h2>Mission Destination</h2>
<ol>
   <li>Name: ${}</li>
   <li>Diameter: ${}</li>
   <li>Star: ${}</li>
   <li>Distance from Earth: ${}</li>
   <li>Number of Moons: ${}</li>
</ol>
<img src="${}">
*/

let missionTargetEl;

let formEl;
let pilotNameEl;
let copilotNameEl;
let fuelLevelEl;
let cargoMassEl;
let launchStatusEl;

let faultyItemsEl;
let pilotStatusEl;
let copilotStatusEl;
let fuelStatusEl;
let cargoStatusEl;

const formElementErrorStyle = "rgba(255, 0, 0, 0.2)"

async function main() {
  missionTargetEl = document.getElementById("missionTarget");

  pilotNameEl = document.getElementById("pilotName")
  copilotNameEl = document.getElementById("copilotName")
  fuelLevelEl = document.getElementById("fuelLevel")
  cargoMassEl = document.getElementById("cargoMass")
  formEl = document.querySelector("#launchForm > form")

  launchStatusEl = document.getElementById("launchStatus")
  faultyItemsEl = document.getElementById("faultyItems")
  pilotStatusEl = document.getElementById("pilotStatus")
  copilotStatusEl = document.getElementById("copilotStatus")
  fuelStatusEl = document.getElementById("fuelStatus")
  cargoStatusEl = document.getElementById("cargoStatus")
  
  formEl.addEventListener("submit", validateForm)
}

function isNumber(value) {
  let parsed = Number(value)
  if(!isNaN(parsed)) {
    return true
  }
  return false
}

function resetErrorStyling() {
  launchStatusEl.style.color = ""
  const elements = [
    pilotNameEl,
    copilotNameEl,
    fuelLevelEl,
    cargoMassEl
  ]

  elements.forEach(el => el.style.backgroundColor = "")

  faultyItemsEl.style.visibility = "hidden"
  cargoStatusEl.innerText = "Cargo mass low enough for launch"
}

async function validateForm(event) {
  event.preventDefault();
  resetErrorStyling()

  const errors = []

  let isPilotFieldErrored;
  let isCoPilotFieldErrored;
  let isFuelLevelFieldErrored;
  let isFuelLevelTooLow;
  let isCargoMassFieldErrored;
  let isCargoMassTooHigh;

  if(pilotNameEl.value === "") {
    errors.push("Pilot Name cannot be empty.")
    pilotNameEl.style.backgroundColor = formElementErrorStyle
    isPilotFieldErrored = true
  }

  if(isNumber(pilotNameEl.value)) {
    errors.push("Pilot Name must be text.")
    pilotNameEl.style.backgroundColor = formElementErrorStyle
    isPilotFieldErrored = true
  }

  if(copilotNameEl.value === "") {
    errors.push("Pilot Name cannot be empty.")
    copilotNameEl.style.backgroundColor = formElementErrorStyle
    isCoPilotFieldErrored = true
  }

  if(isNumber(copilotNameEl.value)) {
    errors.push("Co-Pilot Name must be text.")
    copilotNameEl.style.backgroundColor = formElementErrorStyle
    isCoPilotFieldErrored = true
  }

  if(fuelLevelEl.value === "") {
    errors.push("Fuel Level cannot be empty.")
    fuelLevelEl.style.backgroundColor = formElementErrorStyle
    isFuelLevelFieldErrored = true
  }

  if(!isNumber(fuelLevelEl.value)) {
    errors.push("Fuel Level must be a number.")
    fuelLevelEl.style.backgroundColor = formElementErrorStyle
    isFuelLevelFieldErrored = true
  }

  if(isNumber(fuelLevelEl.value) && Number(fuelLevelEl.value) < 10000) {
    errors.push("Fuel Level too low.")
    fuelLevelEl.style.backgroundColor = formElementErrorStyle
    isFuelLevelTooLow = true
  }

  if(cargoMassEl.value === "") {
    errors.push("Pilot Name cannot be empty.")
    cargoMassEl.style.backgroundColor = formElementErrorStyle
    isCargoMassFieldErrored = true
  }

  if(!isNumber(cargoMassEl.value)) {
    errors.push("Cargo Mass must be a number.")
    cargoMassEl.style.backgroundColor = formElementErrorStyle
    isCargoMassFieldErrored = true
  }

  if(isNumber(cargoMassEl.value) && Number(cargoMassEl.value) > 10000) {
    errors.push("Cargo Mass too high.")
    cargoMassEl.style.backgroundColor = formElementErrorStyle
    isCargoMassTooHigh = true
  }

  if(errors.length > 0) {
    launchStatusEl.innerText = "Shuttle Not Ready for Launch"
    launchStatusEl.style.color = "red"
    let errorString = ""
    errors.forEach(e => errorString += `- ${e}\n`)
    alert(`Please correct the following errors and try again:\n\n${errorString}`)
    
    faultyItemsEl.style.visibility = "inherit"

    if(isPilotFieldErrored) {
      pilotStatusEl.innerText = "Pilot not ready."
    }

    if(isCoPilotFieldErrored) {
      copilotStatusEl.innerText = "Co-Pilot not ready."
    }

    if(isCargoMassFieldErrored) {
      cargoStatusEl.innerText = "Unable to determine cargo mass."
    }

    if(isCargoMassTooHigh) {
      cargoStatusEl.innerText = "Cargo mass too high for launch."
    }

    if(isFuelLevelFieldErrored) {
      fuelStatusEl.innerText = "Unable to determine fuel level."
    }

    if(isFuelLevelTooLow) {
      fuelStatusEl.innerText = "Fuel level too low for launch."
    }
  } else {
    launchStatusEl.innerText = "Shuttle Ready for Launch!"
    launchStatusEl.style.color = "green"
    faultyItemsEl.style.visibility = "inherit"
    pilotStatusEl.innerText = `Pilot ${pilotNameEl.value} Ready`
    copilotStatusEl.innerText = `Co-Pilot ${copilotNameEl.value} Ready`
    fuelStatusEl.innerText = `Fuel level high enough for launch`
    cargoStatusEl.innerText = `Cargo mass low enough for launch`

    await setDestination()
  }
}

async function setDestination() {
  let res = await fetch("https://handlers.education.launchcode.org/static/planets.json")
  let json = await res.json()
  let destination = json[5] // Jupiter/Europa
  missionTargetEl.innerHTML = `
    <h2>Mission Destination</h2>
    <ol>
      <li>Name: ${destination.name}</li>
      <li>Diameter: ${destination.diameter}</li>
      <li>Star: ${destination.star}</li>
      <li>Distance from Earth: ${destination.distance}</li>
      <li>Number of Moons: ${destination.moons}</li>
    </ol>
    <img src="${destination.image}">
  `
}

window.addEventListener("load", main)