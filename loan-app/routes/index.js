var express = require('express');
var request = require('request');
var http = require('http');
var router = express.Router();

const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
];

function convertDate(inputFormat) {
    function pad(s) { return (s < 10) ? '0' + s : s; }
    var d = new Date(inputFormat);
    return [pad(d.getDate()), pad(monthNames[d.getMonth()])].join(' ');
}

/* GET home page. */
router.get('/home', function(req, res, next) {
    if(req.session.user_id == undefined){
        res.redirect("/login");
    }
    let data = {};
    console.log("Breakpoint 1");
    /*Get Credit score*/
    let post_options = {
        uri: "http://20.42.24.143:9070/credit/score?customerId=" +req.session.user_id,/*place microservice url here */
        method: "GET",
        rejectUnauthorized: false,
    };
    request(post_options, function (error, response, body) {
        console.log("response: " +response.statusCode);
        if(response.statusCode == "200"){
            let credit_score = JSON.parse(response.body);
            data.credit_score = credit_score.score;
            console.log("Breakpoint 2");

            /*Get loan amount*/
            post_options = {
                uri: "http://20.42.24.143:9070/loans/status?customerId="+req.session.user_id+"&loanStatus=Active",/*place microservice url here */
                method: "GET",
                rejectUnauthorized: false,
            };
            request(post_options, function (error, response, body) {
                if(response.statusCode == "200"){
                    let amount_body = JSON.parse(response.body);
                    data.loan_amount = amount_body[0].amount;
                    console.log("Breakpoint 1");

                    /*Get Loans in the last three months*/
                    post_options = {
                        uri: "http://20.42.24.143:9070/loans/all?customerId=" +req.session.user_id,/*place microservice url here */
                        method: "GET",
                        rejectUnauthorized: false,
                    };
                    request(post_options, function (error, response, body) {
                        if(response.statusCode == "200"){
                            let history = JSON.parse(response.body);
                            let _hist = [];
                            for (let i = 0; i < history.length; i++) {
                                _hist[i] = {
                                    loan_amount : history[i].amount,
                                    date: convertDate(history[i].requestDate)
                                }
                            }
                            data.history = _hist;
                            console.log(data);
                            res.render('index',
                                {   title: 'Loan App',
                                    data: data,
                                }
                            );
                        }
                    });
                }
            });
        }else{
            res.redirect("/login");
        }
    });

});

router.get('/login', function(req, res, next) {
    res.render('login', { title: 'Login' });
});

router.post('/login', function(req, res, next) {
    let post_data = {
        "username": req.body.username
    };

    if(post_data.username === ""){
        res.redirect('/login', {message: " User ID required"});
    }
    req.session.user_id = req.body.username;
    console.log(req.session.user_id);

    res.redirect("/home");
});

router.post('/logout', function(req, res, next) {
    req.session.destroy();
    res.redirect("/login");
});

module.exports = router;