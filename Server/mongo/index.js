var mongoose = require('mongoose');

var mongo = mongoose.connection;

mongo.on('error', console.error);
mongo.once('open', function () {
    console.log("Connected to \t DB");
});

var db = mongoose.connect('mongodb://localhost/onestar');

// var ListSchema = new mongoose.Schema({
//     name: {
//         type: String
//     },
//     url: {
//         type: String
//     }
// })

// var Lists = mongoose.model('lists', ListSchema);

// exports.Lists = Lists;