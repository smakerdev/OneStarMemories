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
        var nickname = req.body.nickname;
    });

    return router;
}