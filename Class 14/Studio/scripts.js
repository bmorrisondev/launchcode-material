// Write your JavaScript code here.
// Remember to pay attention to page loading!

function init() {
  let takeOffButton = document.getElementById("takeoff")
  let flightStatusEl = document.getElementById("flightStatus")
  let shuttleBackgroundEl = document.getElementById("shuttleBackground")
  let spaceShuttleHeightEl = document.getElementById("spaceShuttleHeight")
  let landingButton = document.getElementById("landing")
  let missionAbortButton = document.getElementById("missionAbort")
  let rocketImg = document.getElementById("rocket")
  let shuttleBackground = document.getElementById("shuttleBackground")

  let upButton = document.getElementById("up")
  let downButton = document.getElementById("down")
  let rightButton = document.getElementById("right")
  let leftButton = document.getElementById("left")

  takeOffButton.addEventListener("click", function () {
    let confirm = window.confirm("Confirm that the shuttle is ready for takeoff.")
    if(confirm === true) {
      flightStatusEl.innerText = "Shuttle in flight."
      shuttleBackgroundEl.style = "background-color: blue"
      let currentShuttleHeight = Number(spaceShuttleHeightEl.innerText)
      currentShuttleHeight += 10000
      spaceShuttleHeightEl.innerText = currentShuttleHeight
    }
  })

  landingButton.addEventListener("click", function () {
    window.alert("The shuttle is landing. Landing gear engaged.")
    flightStatusEl.innerText = "The shuttle has landed."
    shuttleBackgroundEl.style = "background-color: green"
    spaceShuttleHeightEl.innerText = "0"
  })
  
  missionAbortButton.addEventListener("click", function () {
    let confirm = window.confirm("Confirm that you want to abort the mission.")
    if(confirm === true) {
      flightStatusEl.innerText = "Mission aborted."
      shuttleBackgroundEl.style = "background-color: green"
      spaceShuttleHeightEl.innerText = "0"
    }
  })

  const navButtonCallback = function (event) {
    if(event.srcElement.id === "up") {
      let currentTopMargin = rocketImg.style.marginTop
      currentTopMargin = currentTopMargin.replace("px", "")
      currentTopMargin = Number(currentTopMargin)
      currentTopMargin -= 10
      rocketImg.style.marginTop = `${currentTopMargin}px`
      
      let currentShuttleHeight = Number(spaceShuttleHeightEl.innerText)
      currentShuttleHeight += 10000
      spaceShuttleHeightEl.innerText = currentShuttleHeight
    }

    if(event.srcElement.id === "down") {
      let currentTopMargin = rocketImg.style.marginTop
      currentTopMargin = currentTopMargin.replace("px", "")
      currentTopMargin = Number(currentTopMargin)
      currentTopMargin += 10
      rocketImg.style.marginTop = `${currentTopMargin}px`
      
      let currentShuttleHeight = Number(spaceShuttleHeightEl.innerText)
      currentShuttleHeight -= 10000
      spaceShuttleHeightEl.innerText = currentShuttleHeight
    }

    if(event.srcElement.id === "right") {
      let currentLeftMargin = rocketImg.style.marginLeft
      currentLeftMargin = currentLeftMargin.replace("px", "")
      currentLeftMargin = Number(currentLeftMargin)
      currentLeftMargin += 10
      rocketImg.style.marginLeft = `${currentLeftMargin}px`
    }

    if(event.srcElement.id === "left") {
      let currentLeftMargin = rocketImg.style.marginLeft
      currentLeftMargin = currentLeftMargin.replace("px", "")
      currentLeftMargin = Number(currentLeftMargin)
      currentLeftMargin -= 10
      rocketImg.style.marginLeft = `${currentLeftMargin}px`
    }
  }

  upButton.addEventListener("click", navButtonCallback)
  downButton.addEventListener("click", navButtonCallback)
  rightButton.addEventListener("click", navButtonCallback)
  leftButton.addEventListener("click", navButtonCallback)

  // When the "Up", "Down", "Right", and "Left" buttons are clicked, the following should happen:
  //   The rocket image should move 10 px in the direction of the button that was clicked.
  //   If the "Up" or "Down" buttons were clicked, then the shuttle height should increase or decrease by 10,000 miles

}

window.onload = init
