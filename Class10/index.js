const Express = require('express');
const app = new Express();
const bodyParser = require('body-parser');
const axios = require('axios');

app.use(bodyParser.json())

app.get('/hello-world', async (req, res) => {
  res.send('Hello World!')
})

app.get('/gists/:username', async (req, res) => {
  try {
    let response = await axios.get(`https://api.github.com/users/${req.params.username}/gists`)
    res.send(response.data.map(g => g.description))
  } catch (err) {
    res.send("an error occurred")
  }
})

app.listen(3030, () => console.log("app listening on 3030")) 