const path = require('path')

// Import express and create a new express app
const express = require('express');
const app = express();

const FaunaService = require('@brianmmdev/faunaservice');
const _faunaService = new FaunaService('fnAD8LDU3NACAzvtzTLmQ1oU6w5jEaOC98HflPwV')

// Create a GET request to handle accessing our web page
app.get('/', async (req, res) => {
  if(req.query.firstName && req.query.lastName) {
    _faunaService.createRecord('Forms', req.query)
  }
  res.sendFile(path.join(__dirname + '/public/index.html'));
})

app.get('/submissions', async (req, res) => {
  let submissions = await _faunaService.fetchRecordsInIndex('AllFormsData');
  res.json(submissions)
})

// Define the port we're going to listen for requests on
const port = 3000;

// Tell the app to listen on that port, and log out to the console once its listening.
app.listen(port);
console.log(`listening on http://localhost:${port}`);
