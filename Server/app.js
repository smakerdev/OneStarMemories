const http = require('http');
const express = require('express');
const app = express();
http.createServer(app);

var router = express.Router();
var db = require('./mongo');
var bodyParser = require('body-parser');
var port = 3000;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: false
}));


var index = require('./routes/index')(router, db.Users, db.Boards);

app.use('/', index);

app.listen(port);

module.exports = app;