const buildAstronautEl = function(astronaut) {
  let div = document.createElement("div")
  div.className = "astronaut"
  div.innerHTML = `
    <div class="bio">
        <h3>${astronaut.firstName} ${astronaut.lastName}</h3>
        <ul>
          <li>Hours in space: ${astronaut.hoursInSpace}</li>
          <li>Active: ${astronaut.active}</li>
          <li>Skills: ${astronaut.skills.join(", ")}</li>
        </ul>
    </div>
    <img class="avatar" src="${astronaut.picture}">
  `
  return div
}

const main = async function () {
  let url = "https://handlers.education.launchcode.org/static/astronauts.json"
  let response = await fetch(url)
  let data = await response.json()

  let containerEl = document.getElementById("container")

  data.forEach(el => {
    let astronautDiv = buildAstronautEl(el)
    containerEl.appendChild(astronautDiv)
  })
}

window.addEventListener("load", main)