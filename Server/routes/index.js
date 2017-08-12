module.exports = (router, Users, Boards) => {
    router.get('/', function (req, res) {
        res.send('Hello');
    })
    
    .post('/api/register', function (req, res) {
        var nickname = req.body.nickname;
        var region  = req.body.region;

        var data = new Users({
            nickname: nickname,
            region: region
        });

        data.save(function (err, output) {
            if (err)
                return console.error(err);
            return res.json({
                success: true,
                output: output
            });
        });

    })

    .post('/api/entry', function (req, res) {
        var title = req.body.title;
        var content = req.body.content;
        var nickname = req.body.nickname;
        var lat = req.body.lat;
        var lng = req.body.lng;
    
        var data = new Boards({
            title: title,
            content: content,
            nickname: nickname,
            lat: lat,
            lng: lng
        });

        data.save(function (err, output) {
            if (err)
                return console.error(err);
            return res.json({
                success: true,
                output: output
            });
        });
    });

    return router;
}