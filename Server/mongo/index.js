var mongoose = require('mongoose');

var mongo = mongoose.connection;

mongo.on('error', console.error);
mongo.once('open', function () {
    console.log("Connected to \t DB");
});

var db = mongoose.connect('mongodb://localhost/onestar');

var UserSchema = new mongoose.Schema({
    nickname: {
        type: String
    },
    region: {
        type: String
    }
});

var BoardSchema = new mongoose.Schema({
    title: {
        type: String
    },
    content: {
        type: String
    },
    nickname: {
        type: String
    },
    lat: {
        type: Number
    }
});

var Users = mongoose.model('users', UserSchema);
var Boards = mongoose.model('boards', BoardSchema);

exports.Users = Users;
exports.Boards = Boards;