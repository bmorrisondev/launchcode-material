/* <div class="astronaut">
   <div class="bio">
      <h3>Mae Jemison</h3>
      <ul>
         <li>Hours in space: 190</li>
         <li>Active: false</li>
         <li>Skills: Physician, Chemical Engineer</li>
      </ul>
   </div>
   <img class="avatar" src="images/mae-jemison.jpg">
</div> */


async function main() {
  try {
    let response = await fetch('https://handlers.education.launchcode.org/static/astronauts.json')
    let json = await response.json()

    json = json.sort((a, b) => a.hoursInSpace - b.hoursInSpace)
  
    let containerEl = document.getElementById("container")
  
    let astronautListElements = `<div>${json.length} Astronauts</div>`
  
    json.forEach((astronaut) => {
      let isActiveHtml = astronaut.active
      if(astronaut.active === true) {
        isActiveHtml = `<span class="active">${astronaut.active}</span>`
      }

      astronautListElements += `
        <div class="astronaut">
          <div class="bio">
              <h3>${astronaut.firstName} ${astronaut.lastName}</h3>
              <ul>
                <li>Hours in space: ${astronaut.hoursInSpace}</li>
                <li>Active: ${isActiveHtml}</li>
                <li>Skills: ${astronaut.skills.join(", ")}</li>
              </ul>
          </div>
          <img class="avatar" src="${astronaut.picture}">
        </div>
      `
    })

    containerEl.innerHTML = astronautListElements
  } catch (err) {
    console.log(err)
  }

  // fetch('https://handlers.education.launchcode.org/static/astronauts.json')
  //   .then((response) => {
  //     return response.json()
  //   })
  //   .then((json) => {
  //     let containerEl = document.getElementById("container")

  //     let astronautListElements = ''

  //     json.forEach((astronaut) => {
  //       astronautListElements += `
  //         <div class="astronaut">
  //           <div class="bio">
  //               <h3>${astronaut.firstName} ${astronaut.lastName}</h3>
  //               <ul>
  //                 <li>Hours in space: ${astronaut.hoursInSpace}</li>
  //                 <li>Active: ${astronaut.active}</li>
  //                 <li>Skills: ${astronaut.skills.join(", ")}</li>
  //               </ul>
  //           </div>
  //           <img class="avatar" src="${astronaut.picture}">
  //         </div>
  //       `
  //     })
  //     containerEl.innerHTML = astronautListElements
  //   })
  //   .catch(err => console.log(err))
}

window.addEventListener("load", main)